package com.example.elpanteon.data

import androidx.room.withTransaction
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object DatosIniciales {

    suspend fun insertarDioses(database: AppDatabase) {
        withContext(Dispatchers.IO) {

            database.withTransaction {
                val glosario = listOf(
                    Dios(nombre = "Odín", atributo = "Æsir, Alfǫðr, sabiduría, conocimiento y guerra", reino = "Asgard", nota = "Reina en el Valaskjálf, palacio de Asgard. Su techo está cubierto de plata y en él se encuentra Hliðskjálf, el trono de Odín, desde donde puede observar los nueve mundos.", imagen = "https://i.pinimg.com/736x/96/ba/e6/96bae6fa5a51a0b103dec1b3f8ff39a7.jpg"),
                    Dios(nombre = "Frigg", atributo = "Æsir, matrimonio y profecía", reino = "Asgard", nota = "Madre de todos.", imagen = "https://i.pinimg.com/736x/78/48/6c/78486c7d78a0f2c4c4a4a7c5e7c01464.jpg"),
                    Dios(nombre = "Thor", atributo = "Æsir, trueno y fuerza", reino = "Asgard", nota = "Dios del trueno.", imagen = "https://i.pinimg.com/736x/c6/c9/15/c6c9159c7197f644f73d373d8b769254.jpg"),
                    Dios(nombre = "Sif", atributo = "Æsir, fertilidad y cosechas", reino = "Asgard", nota = "Esposa de Thor.", imagen = "https://i.pinimg.com/736x/aa/bc/22/aabc224e5d9c4908ad5edc4edfea98e5.jpg"),
                    Dios(nombre = "Freyr", atributo = "Vanir, fertilidad y prosperidad", reino = "Vanaheim", nota = "Recibió Álfheim como regalo cuando era niño.", imagen = "https://i.pinimg.com/736x/11/96/ec/1196ecf45f6ddd90d10639c64c994ae8.jpg"),
                    Dios(nombre = "Freyja", atributo = "Vanir, amor, magia, belleza, guerra y muerte", reino = "Fólkvangr", nota = "Recoge a la mitad de los guerreros caídos en combate para llevarlos a su palacio, Fólkvangr; Odín recibe a la otra mitad en el Valhalla.", imagen = "https://i.pinimg.com/736x/97/a6/a4/97a6a45247972fd0a5c95e5be17971fa.jpg"),
                    Dios(nombre = "Eir", atributo = "Æsir, sanación y medicina", reino = "Asgard", nota = "Diosa sanadora.", imagen = "https://i.pinimg.com/736x/42/8a/ae/428aae5d5a50fd5df4579b0ed3ba69f1.jpg"),
                    Dios(nombre = "Njörðr", atributo = "Vanir, mar y navegación", reino = "Asgard - Nóatún", nota = "Dios del mar.", imagen = "https://i.pinimg.com/736x/a8/84/3b/a8843be454b700db237817cc7da8c82f.jpg"),
                    Dios(nombre = "Hel", atributo = "Jötnar, Diosa y muerte", reino = "Helheim", nota = "Se considera, es Hermanastra de Freyja.", imagen = "https://i.pinimg.com/736x/89/fd/c8/89fdc8e4fd360c7e48b1acf2aac39403.jpg"),
                    Dios(nombre = "Heimdall", atributo = "Æsir, vigilancia y protección", reino = "Asgard - Bifröst", nota = "Avisa del Ragnarök.", imagen = "https://i.pinimg.com/736x/5b/69/5a/5b695a6949074643b91891594eb771a6.jpg"),
                    Dios(nombre = "Tyr", atributo = "Æsir, honor y guerra justa", reino = "Asgard", nota = "Dios de la guerra.", imagen = "https://i.pinimg.com/736x/ae/1d/48/ae1d485e5093aca8455f3659f5cf5213.jpg"),
                    Dios(nombre = "Skaði", atributo = "Jötnar, invierno y caza", reino = "Jötunheimr - Þrymheimr", nota = "nombre a Escandinavia `Tierra de Skaði´.", imagen = "https://i.pinimg.com/736x/d3/fe/42/d3fe422100f7ee37af8a94b487c712b0.jpg"),
                    Dios(nombre = "Ull", atributo = "Æsir, tiro con arco y esquí", reino = "Asgard - Ýdalir", nota = "Reina en las nieves.", imagen = "https://i.pinimg.com/736x/ad/1f/47/ad1f474195fafbbb430036002b818f06.jpg"),
                    Dios(nombre = "Urðr", atributo = "Norna, El pasado o lo que ya ha ocurrido", reino = "Lago Urðarbrunnr", nota = "Una de las tres Nornas. Teje el destino de los hombres y los dioses.", imagen = "https://i.pinimg.com/736x/87/db/c2/87dbc23be1f3349bfe01dc176fe039d1.jpg"),
                    Dios(nombre = "Verðandi", atributo = "Norna, El presente o lo que está ocurriendo", reino = "Lago Urðarbrunnr", nota = "Una de las tres Nornas. Teje el destino de los hombres y los dioses.", imagen = "https://i.pinimg.com/736x/b6/b2/87/b6b2877236065f44d8ccd14d4c0cc3eb.jpg"),
                    Dios(nombre = "Skuld", atributo = "Norna, El futuro o lo que debe ocurrir", reino = "Lago Urðarbrunnr", nota = "Una de las tres Nornas. Teje el destino de los hombres y los dioses.", imagen = "https://i.pinimg.com/736x/4c/df/19/4cdf198503ecc4b25c3570f5466b1611.jpg"),
                    Dios(nombre = "Angrboða", atributo = "Jötnar, destino y destrucción", reino = "Jötunheimr", nota = "Pareja de Loki y madre de Fenrir, Jörmungandr y Hel.", imagen = "https://i.pinimg.com/736x/0b/f4/4c/0bf44c8b04838b9ad7b15008b8cbb28d.jpg"),
                    Dios(nombre = "Baldr", atributo = "Æsir, luz, belleza, pureza y bondad", reino = "Asgard", nota = "Hijo de Odín y Frigg. Su muerte, causada por Höðr mediante una trampa de Loki con muérdago, anuncia el comienzo del Ragnarök.", imagen = "https://i.pinimg.com/736x/f8/c6/70/f8c6708adf08a7a1c1677711205d5de8.jpg"),
                    Dios(nombre = "Þrúðr", atributo = "Æsir, Fuerza y poder", reino = "Asgard", nota = "Hija de Thor y Sif. Valquiria guerrera del Vanhalla.", imagen = "https://i.pinimg.com/736x/e9/bd/14/e9bd14953e37f016a3130a59267f9e57.jpg"),
                    Dios(nombre = "Alvíss", atributo = "Dvergr, herrero y conocimiento", reino = "Svartálfaheimr", nota = "Enano que pretendía casarse con Þrúðr. Thor lo desafió con preguntas hasta el amanecer, cuando la luz del sol lo convirtió en piedra.", imagen = "https://i.pinimg.com/736x/42/4f/e9/424fe9b904114d3e3c1aabcb01206fdc.jpg"),
                    Dios(nombre = "Gerðr", atributo = "Jötnar, belleza y fertilidad", reino = "Jötunheimr", nota = "Hermosa giganta que se convierte en esposa de Freyr y vinculada a Álfheim por el.", imagen = "https://i.pinimg.com/736x/f7/72/1d/f7721defdadd762350966019e4692899.jpg")
                    )

                val dao = database.diosDao()
                val diosesExistentes = dao.obtenerTodos()

                val nombresExistentes = diosesExistentes
                    .map{ it.nombre}
                    .toSet()

                val diosesNuevos = glosario.filter{
                    it.nombre !in nombresExistentes
                }

                diosesNuevos.forEach{
                    dao.insertar(it)
                }

                actualizarImagenesIniciales(dao, glosario)
            }
        }
    }

    private suspend fun actualizarImagenesIniciales(
        dao: DiosDao,
        glosario: List<Dios>
    ) {
        glosario.forEach { dios ->
            dao.actualizarImagen(
                nombre = dios.nombre,
                nuevaUrl = dios.imagen.orEmpty()
            )
        }
    }
}