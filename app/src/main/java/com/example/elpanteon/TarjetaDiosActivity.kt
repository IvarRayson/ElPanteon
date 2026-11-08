package com.example.elpanteon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.elpanteon.data.AppDatabase
import com.example.elpanteon.data.Dios
import com.example.elpanteon.data.Mito
import com.example.elpanteon.ui.theme.ElPanteonTheme
import com.example.elpanteon.ui.theme.cormorantGaramond

class TarjetaDiosActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val diosId = intent.getIntExtra("DIOS_ID", -1)

        setContent {
            ElPanteonTheme {

                var dios by remember { mutableStateOf<Dios?>(null) }
                var mitos by remember { mutableStateOf<List<Mito>>(emptyList()) }
                var cargando by remember { mutableStateOf(true) }

                LaunchedEffect(diosId) {
                    if (diosId != -1) {
                        val database = AppDatabase.obtenerBaseDatos(applicationContext)

                        dios = database.diosDao().obtenerPorId(diosId)
                        mitos = database.mitoDao().obtenerPorDios(diosId)
                    }
                    cargando = false
                }

                when {
                    cargando -> {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    }

                    dios != null -> {
                        TarjetaDios(
                            dios = dios!!,
                            mitos = mitos,
                            volver = { finish() }
                        )
                    }

                    else -> {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(24.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text("No se ha encontrado el dios.")
                            Button(onClick = { finish() }) {
                                Text("Volver al glosario")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TarjetaDios(
    dios: Dios,
    mitos: List<Mito>,
    volver: () -> Unit
) {
    var favorito by remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {

            // 1. Imagen principal y 3. Botón superpuesto
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(750.dp)
            ) {

                AsyncImage(
                    model = dios.imagen,
                    contentDescription = "Imagen de ${dios.nombre}",
                    contentScale = ContentScale.Fit,
                    placeholder = painterResource(R.drawable.alternativa),
                    error = painterResource(R.drawable.alternativa_b_n),
                    fallback = painterResource(R.drawable.biograma),
                    modifier = Modifier.fillMaxSize()
                )

                // Botón superpuesto para marcar como favorito
                Button(
                    onClick = { favorito = !favorito },
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(16.dp)
                ) {
                    Text(if (favorito) "♥ Favorito" else "♡ Favorito")
                }
            }

            // 4. Nombre de la leyenda
            Text(
                text = dios.nombre,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )

            // 5. Column: organiza las secciones
            Column(
                modifier = Modifier.padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {

                // 6. Historia y leyendas
                Text(
                    text = "Historia y leyendas",
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )

                if (mitos.isEmpty()) {
                    Text("Todavía no hay historias registradas para este dios.")
                } else {
                    mitos.forEach { mito ->
                        Text(
                            text = mito.titulo,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.SemiBold
                        )

                        Text(
                            text = mito.historia,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }

                // Reino
                Text(
                    text = "Reino: ${dios.reino}",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.SemiBold
                )

                // 7. Row: atributos
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    HorizontalDivider(
                        modifier = Modifier.weight(1f),
                        thickness = 1.dp,
                        color = MaterialTheme.colorScheme.outlineVariant
                    )
                    Text(
                        text = "Atributos",
                        style = MaterialTheme.typography.titleLarge
                    )
                    HorizontalDivider(
                        modifier = Modifier.weight(1f),
                        thickness = 1.dp,
                        color = MaterialTheme.colorScheme.outlineVariant
                    )
                }

                val atributos = dios.atributo
                    .split(Regex("\\s+y\\s+|,"))
                    .map { it.trim() }
                    .filter { it.isNotBlank() }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    atributos.forEach { atributo ->
                        Surface(
                            shape = RoundedCornerShape(20.dp),
                            color = Color(0xFF87BEAF)
                        ) {
                            Text(
                                text = atributo,
                                modifier = Modifier.padding(
                                    horizontal = 14.dp,
                                    vertical = 8.dp
                                ),
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }

                // 8. Nota
                if (!dios.nota.isNullOrBlank()) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        HorizontalDivider(
                            modifier = Modifier.weight(1f),
                            thickness = 1.dp,
                            color = MaterialTheme.colorScheme.outlineVariant
                        )

                        Text(
                            text = "Curiosidades",
                            style = MaterialTheme.typography.titleLarge
                        )

                        HorizontalDivider(
                            modifier = Modifier.weight(1f),
                            thickness = 1.dp,
                            color = MaterialTheme.colorScheme.outlineVariant
                        )
                    }

                    Text(
                        text = dios.nota,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            lineHeight = 28.sp
                        )
                    )
                }

                // 9. Botón de ancho completo
                Button(
                    onClick = volver,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF006A4E)
                    )
                ) {
                    Text("Volver al glosario")
                }
            }
        }
    }
}
