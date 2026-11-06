package com.example.elpanteon

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.elpanteon.data.AppDatabase
import com.example.elpanteon.data.DatosIniciales
import com.example.elpanteon.data.Dios
import com.example.elpanteon.ui.theme.ElPanteonTheme
import com.example.elpanteon.ui.theme.germaniaOne
import com.example.elpanteon.ui.theme.pirataOne
import com.example.elpanteon.ui.theme.unifrakturCook

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ElPanteonTheme {

                var dioses by remember {
                    mutableStateOf<List<Dios>>(emptyList())
                }

                var cargando by remember {
                    mutableStateOf(true)
                }

                LaunchedEffect(Unit) {
                    val database = AppDatabase.obtenerBaseDatos(applicationContext)
                    DatosIniciales.insertarDioses(database)

                    dioses = database.diosDao().obtenerTodos()

                    cargando = false
                }

                PantallaInicio(
                    dioses = dioses,
                    cargando = cargando
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaInicio(
    dioses: List<Dios>,
    cargando: Boolean
) {
    val context = LocalContext.current

    var busqueda by remember {
        mutableStateOf("")
    }

    var searchActive by remember {
        mutableStateOf(false)
    }

    val diosesFiltrados = dioses.filter {
        it.nombre.contains(busqueda, ignoreCase = true)
    }

    // Reinos únicos para la sección visual de Yggdrasil
    val reinos = dioses.distinctBy { it.reino }

    val listaEstado = androidx.compose.foundation.lazy.rememberLazyListState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "El Panteón",
                        style = MaterialTheme.typography.headlineSmall.copy(
                            fontFamily = pirataOne,
                            fontSize = 32.sp
                        )
                    )
                }
            )
        },

        bottomBar = {
            NavigationBar {

                // 1. Perfil
                NavigationBarItem(
                    selected = false,
                    onClick = {
                        Toast.makeText(
                            context,
                            "Perfil próximamente",
                            Toast.LENGTH_SHORT
                        ).show()
                    },
                    icon = {
                        Icon(Icons.Default.Person, contentDescription = "Perfil")
                    },
                    label = { Text("Perfil") }
                )

                // 2. Home
                NavigationBarItem(
                    selected = true,
                    onClick = {
                        busqueda = ""
                        searchActive = false
                        // La pantalla principal ya está visible
                    },
                    icon = {
                        Icon(Icons.Default.Home, contentDescription = "Inicio")
                    },
                    label = { Text("Home") }
                )

                // 3. Biblioteca
                NavigationBarItem(
                    selected = false,
                    onClick = {
                        Toast.makeText(
                            context,
                            "Biblioteca próximamente",
                            Toast.LENGTH_SHORT
                        ).show()
                    },
                    icon = {
                        Icon(Icons.Default.Favorite, contentDescription = "Biblioteca")
                    },
                    label = { Text("Biblioteca") }
                )

                // 4. Retroceso
                NavigationBarItem(
                    selected = false,
                    onClick = {
                        (context as? ComponentActivity)?.finish()
                    },
                    icon = {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Retroceso")
                    },
                    label = { Text("Atrás") }
                )
            }
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            // 2. Sección Yggdrasil
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                TextButton(
                    onClick = {
                        Toast.makeText(
                            context,
                            "Exploración de Yggdrasil próximamente",
                            Toast.LENGTH_SHORT
                        ).show()
                    },
                ) {
                    Text(
                        text = "Yggdrasil  >",
                        fontSize = 22.sp,
                        style = MaterialTheme.typography.headlineMedium.copy(
                            fontFamily = unifrakturCook
                        ),
                        color = Color(0xFF006A4E)
                    )
                }

                Text(
                    text = "LOS NUEVE MUNDOS",
                    fontSize = 10.sp,
                    letterSpacing = 0.18.em,
                    color = Color(0xFF8A8173)
                )
            }



            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentPadding = PaddingValues(horizontal = 12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(reinos) { dios ->

                    Card(
                        modifier = Modifier
                            .width(130.dp)
                            .fillMaxHeight(),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Box(
                                modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f)
                            ) {
                                AsyncImage(
                                    model = dios.imagen,
                                    contentDescription = dios.reino,
                                    contentScale = ContentScale.Crop,
                                    placeholder = painterResource(R.drawable.alternativa),
                                    error = painterResource(R.drawable.alternativa_b_n),
                                    fallback = painterResource(R.drawable.biograma),
                                )

                                Text(
                                    text = dios.reino,
                                    fontSize = 18.sp,
                                    style = MaterialTheme.typography.bodySmall.copy(
                                        fontFamily = germaniaOne
                                    ),
                                    modifier = Modifier.align(Alignment.BottomCenter).padding(6.dp),
                                    color = Color(0xFFFFFFFF)
                                )
                            }
                        }
                    }
                }
            }

            // 3. SearchBar
            SearchBar(
                query = busqueda,
                onQueryChange = {
                    busqueda = it
                },
                onSearch = {
                    searchActive = false
                },
                active = searchActive,
                onActiveChange = {
                    searchActive = it
                },
                placeholder = {
                    Text("Search leyend")
                },
                leadingIcon = {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = "Buscar"
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(PaddingValues(12.dp, 0.dp, 12.dp, 8.dp))
            ) {
                diosesFiltrados.take(4).forEach { dios ->
                    ListItem(
                        headlineContent = {
                            Text(dios.nombre)
                        },
                        modifier = Modifier.clickable {
                            busqueda = dios.nombre
                            searchActive = false
                        }
                    )
                }
            }

            // 4. Glosario y tarjetas
            LazyColumn(
                state = listaEstado,
                modifier = Modifier.fillMaxWidth()
                    .height(98.dp + 110.dp * 3),
                contentPadding = PaddingValues(12.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                // Cabecero dentro de la lista desplazable
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Glosario",
                            style = MaterialTheme.typography.headlineMedium.copy(
                                fontFamily = unifrakturCook
                            ),
                            modifier = Modifier
                                .padding(vertical = 8.dp)
                                .clickable{
                                    val intent = android.content.Intent(
                                        context,
                                        GlosarioActivity::class.java
                                    )
                                    context.startActivity(intent)
                                },
                            color = Color(0xFF006A4E)
                        )

                        Text(
                            text = "ARCHIVO DE LEYENDAS",
                            fontSize = 10.sp,
                            letterSpacing = 0.18.em,
                            color = Color(0xFF8A8173)
                        )
                    }
                }

                if (cargando) {
                    item {
                        CircularProgressIndicator()
                    }
                } else if (diosesFiltrados.isEmpty()) {
                    item {
                        Text("No se encontraron dioses.")
                    }
                } else {

                    items(
                        items = diosesFiltrados,
                        key = { it.id }
                    ) { dios ->

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    val intent = android.content.Intent(
                                        context,
                                        TarjetaDiosActivity::class.java
                                    )
                                    intent.putExtra("DIOS_ID", dios.id)
                                    context.startActivity(intent)
                                },
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(110.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                AsyncImage(
                                    model = dios.imagen,
                                    contentDescription = dios.nombre,
                                    contentScale = ContentScale.Crop,
                                    placeholder = painterResource(R.drawable.alternativa),
                                    error = painterResource(R.drawable.alternativa_b_n),
                                    fallback = painterResource(R.drawable.biograma),
                                    modifier = Modifier
                                        .width(110.dp)
                                        .fillMaxHeight()
                                )

                                Column(
                                    modifier = Modifier.padding(12.dp),
                                    Arrangement.spacedBy(12.dp)
                                ) {
                                    Text(
                                        text = dios.nombre,
                                        fontWeight = FontWeight.Bold,
                                        style = MaterialTheme.typography.titleMedium
                                    )

                                    Text(
                                        text = dios.atributo,
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = Color(0xFF8A8173)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}