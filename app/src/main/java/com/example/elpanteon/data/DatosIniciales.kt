package com.example.elpanteon.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object DatosIniciales {

    suspend fun insertarDioses(database: AppDatabase) {
        withContext(Dispatchers.IO) {
            val dao = database.diosDao()

            if (dao.obtenerTodos().isEmpty()) {
                val glosario = listOf(
                    Dios(nombre = "Odín", atributo = "Sabiduría y guerra", reino = "Asgard", nota = "Padre de todos", imagen = "https://i.pinimg.com/736x/cb/b1/73/cbb1730da1454fa945dd634b0745b79b.jpg"),
                    Dios(nombre = "Frigg", atributo = "Matrimonio y profecía", reino = "Asgard", nota = "Madre de todos", imagen = "https://i.pinimg.com/736x/78/48/6c/78486c7d78a0f2c4c4a4a7c5e7c01464.jpg"),
                    Dios(nombre = "Thor", atributo = "Trueno y fuerza", reino = "Asgard", nota = "Dios del trueno", imagen = "https://i.pinimg.com/736x/c6/c9/15/c6c9159c7197f644f73d373d8b769254.jpg"),
                    Dios(nombre = "Sif", atributo = "Fertilidad y cosechas", reino = "Asgard", nota = "Esposa de Thor", imagen = "https://i.pinimg.com/736x/aa/bc/22/aabc224e5d9c4908ad5edc4edfea98e5.jpg"),
                    Dios(nombre = "Freyr", atributo = "Fertilidad y prosperidad", reino = "Vanaheim", nota = "Dios de la abundancia", imagen = "https://i.pinimg.com/736x/11/96/ec/1196ecf45f6ddd90d10639c64c994ae8.jpg"),
                    Dios(nombre = "Freyja", atributo = "Amor y magia", reino = "Fólkvangr", nota = "Diosa Vanir", imagen = "https://i.pinimg.com/736x/97/a6/a4/97a6a45247972fd0a5c95e5be17971fa.jpg"),
                    Dios(nombre = "Eir", atributo = "Sanación y medicina", reino = "Asgard", nota = "Diosa sanadora", imagen = "https://i.pinimg.com/736x/42/8a/ae/428aae5d5a50fd5df4579b0ed3ba69f1.jpg"),
                    Dios(nombre = "Njörðr", atributo = "Mar y navegación", reino = "Asgard - Nóatún", nota = "Dios del mar", imagen = "https://i.pinimg.com/736x/a8/84/3b/a8843be454b700db237817cc7da8c82f.jpg"),
                    Dios(nombre = "Hel", atributo = "Diosa y muerte", reino = "Helheim", nota = "Se considera, es Hermanastra de Freyja", imagen = "https://i.pinimg.com/736x/89/fd/c8/89fdc8e4fd360c7e48b1acf2aac39403.jpg"),
                    Dios(nombre = "Heimdall", atributo = "Vigilancia y protección", reino = "Asgard - Bifröst", nota = "Avisa del Ragnarök", imagen = "https://i.pinimg.com/736x/5b/69/5a/5b695a6949074643b91891594eb771a6.jpg"),
                    Dios(nombre = "Tyr", atributo = "Honor y guerra justa", reino = "Asgard", nota = "Dios de la guerra", imagen = "https://i.pinimg.com/736x/ae/1d/48/ae1d485e5093aca8455f3659f5cf5213.jpg"),
                    Dios(nombre = "Skaði", atributo = "Invierno y caza", reino = "Jötunheimr - Þrymheimr", nota = "nombre de Escandinavia `Tierra de Skaði´", imagen = "https://i.pinimg.com/736x/d3/fe/42/d3fe422100f7ee37af8a94b487c712b0.jpg"),
                    Dios(nombre = "Ull", atributo = "Tiro con arco y esquí", reino = "Asgard", nota = "Reina en las nieves", imagen = "https://i.pinimg.com/736x/ad/1f/47/ad1f474195fafbbb430036002b818f06.jpg")
                )
                glosario.forEach { dao.insertar(it) }
            }
        }
    }
}