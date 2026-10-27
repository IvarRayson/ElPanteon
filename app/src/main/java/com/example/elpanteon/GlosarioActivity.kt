package com.example.elpanteon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.elpanteon.data.AppDatabase
import com.example.elpanteon.data.Dios
import com.example.elpanteon.ui.theme.ElPanteonTheme
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.ui.res.painterResource


class GlosarioActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ElPanteonTheme {
                var dioses by remember { mutableStateOf<List<Dios>>(emptyList()) }

                LaunchedEffect(Unit) {
                    dioses = AppDatabase
                        .obtenerBaseDatos(applicationContext)
                        .diosDao()
                        .obtenerTodos()
                }

                CatalogoOfGods(dioses)
            }
        }
    }
}

@Composable
fun CatalogoOfGods(dioses: List<Dios>) {

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Text(
                text = "Glosario de dioses",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(dioses, key = { it.id }) { dios ->

                    Card(
                        modifier = Modifier.clickable {
                        }
                    ) {
                        Column {
                            AsyncImage(
                                model = dios.imagen,
                                contentDescription = dios.nombre,
                                contentScale = ContentScale.Crop,
                                // muestra la imagen provisional mientras carga.
                                placeholder = painterResource(R.drawable.alternativa),
                                // muestra la alternativa si falla la descarga.
                                error = painterResource(R.drawable.alternativa_b_n),
                                // muestra la alternativa si dios.imagen es null.
                                fallback = painterResource(R.drawable.biograma),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(140.dp)
                            )

                            Text(
                                text = dios.nombre,
                                style = MaterialTheme.typography.titleMedium,
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}