package com.example.elpanteon.data

import androidx.room.withTransaction
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object DatosMitosIniciales {

    //únicamente permite asociar cada historia al nombre del dios antes de conocer su ID.
    private data class RelatoMito(
        val dios: String,
        val titulo: String,
        val historia: String
    )

    private val leyendas = listOf(

        // ODÍN *
        RelatoMito(
            "Odín",
            "El sacrificio de Odín por las runas",
            """
            Odín, padre de los dioses, deseaba alcanzar
            un conocimiento que ningún otro ser poseía.
            Deseaba conocer la magia, el destino
            y los secretos que gobernaban la existencia.
            Sabía que para conseguirlo tendría que pagar
            un precio terrible.

            Estubo colgado durante nueve días y nueve
            noches de Yggdrasil, atravesado por su propia
            lanza, Gungnir, Durante aquellos nueve días,
            Odín miró hacia las profundidades y,
            finalmente, vislumbró las runas y el universo.
            Obtubo el conocimiento de la magia.

            '''Sé que colgué de un árbol azotado por
            el viento durante nueve noches enteras,
            herido por una lanza y entregado a Odín,
            yo mismo a mí mismo.'''... Hávamál.
            """.trimIndent()
        ),

        RelatoMito(
            "Odín",
            "El sacrificio en el árbol del mundo",
            """
            Odín Padre de todos y señor de Asgard, sabía
            que existían conocimientos que todavía
            escapaban a su comprensión. Aunque era muy
            poderoso, deseaba conocer todos los secretos
            del universo y alcanzar la sabiduría infinita.
            
            Un día, Odín descubrió que bajo las raíces
            de Yggdrasil, el árbol que todo lo conecta,
            se encontraba el pozo de Mímir, cuyas aguas
            otorgaban un conocimiento extraordinario.
            
            Acudió al guardián del pozo, Mímir, y le pidió
            beber de sus aguas.
            Sin embargo, Mímir le exigió un sacrificio:
            debía entregar uno de sus ojos como pago.
            Sin dudarlo, Odín aceptó. Sacrificó su ojo
            izquierdo y lo entregó a Mímir, quien le
            permitió beber del pozo y así comprender
            secretos que ningún otro dios conoce.
            """.trimIndent()
        ),

        // FRIGG *
        RelatoMito(
            "Frigg",
            "El juramento para proteger a Baldr",
            """
            Baldr, hijo de Odín y Frigg, comenzó a tener
            sueños que anunciaban su muerte.
            Preocupada por su destino, Frigg recorrió los
            mundos y pidió a todas las cosas que juraran
            no hacer daño a su hijo.

            El fuego, el agua, los metales, las piedras,
            incluso los animales aceptaron su petición.
            Frigg creyó que Baldr estaría protegido para
            siempre.
            
            Sin embargo, había olvidado una pequeña planta,
            el muérdago, al que consideró demasiado joven
            e insignificante para representar un peligro.
            
            Loki descubrió aquella excepción y la utilizó
            para engañar a Höðr, hermano de Baldr,
            provocando que lanzara una rama de muérdago
            contra él.
            
            El dios luminoso cayó. Frigg intentó
            recuperarlo del reino de Hel, pero su tristeza
            no pudo cambiar el destino.
            """.trimIndent()
        ),

        // THOR *
        RelatoMito(
            "Thor",
            "La pesca de Jörmungandr",
            """
            Thor, dios del trueno, deseaba enfrentarse a
            Jörmungandr, la enorme serpiente que rodea
            Midgard y muerde su propia cola.

            Durante un viaje con el gigante Hymir, Thor
            preparó un anzuelo utilizando la cabeza de un
            buey como cebo. Después se adentró en el mar
            hasta que consiguió atraer a la enorme serpiente.
            
            Jörmungandr emergió de las profundidades del
            agua y ambos enemigos se contemplaron frente a
            frente.
            Thor levantó su martillo dispuesto a golpear,
            mientras el mar se agitaba violentamente
            y Midgar tembló.

            Atemorizado, Hymir cortó el sedal y la
            serpiente regresó a las profundidades.
            
            El enfrentamiento definitivo tendrá lugar 
            durante el Ragnarök, cuando Thor conseguiría
            matar a Jörmungandr, aunque moriría poco
            después por el veneno de la criatura.
            """.trimIndent()
        ),

        // SIF
        RelatoMito(
            "Sif",
            "El cabello dorado de Sif",
            """
            Era conocida por su hermoso cabello dorado,
            símbolo de belleza y prosperidad. Una noche,
            Loki decidió gastarle una cruel broma y cortó
            todo su cabello mientras dormía.

            Cuando Thor descubrió lo ocurrido, montó en
            cólera y amenazó a Loki con una terrible
            venganza si no encontraba una solución.

            Loki acudió entonces a los hijos de Ivaldi,
            unos extraordinarios artesanos enanos, que
            fabricaron una cabellera de oro capaz de crecer
            sobre la cabeza de Sif como si fuera natural.

            Los enanos también crearon otros objetos
            extraordinarios, entre ellos el barco Skíðblaðnir
            y la lanza Gungnir.

            Más tarde, otros artesanos fabricaron el martillo
            Mjölnir para Thor. Así, una travesura de Loki
            terminó dando origen a algunos de los objetos
            más famosos de la mitología nórdica.
            """.trimIndent()
        ),

        // FREYR **
        RelatoMito(
            "Freyr",
            "El amor de Freyr",
            """
            Freyr, dios de la fertilidad y la prosperidad, se sentó un día en el trono de Odín, Hliðskjálf, desde donde podía contemplarlo todo, los nueve mundos. Su mirada llegó hasta Jötunheimr, y vió su todo, una hermosa giganta cuya belleza lo cautivó profundamente.

            Consumido por el amor, Freyr dejó de encontrar alegría en sus actividades habituales. Su servidor Skírnir se ofreció a viajar hasta Jötunheimr para conseguir su mano. Skírnir llegó ante ella y, después de ofrecerle regalos y pronunciar palabras dotadas de magia, escritas por Freyr, consiguió un encuentro en el bosque, después de nueve noches.

            Freyr obtuvo el amor que deseaba, pero perdió Sumarbrander, una ausencia que tendría consecuencias durante el Ragnarök.
            """.trimIndent()
        ),

        // FREYJA **
        RelatoMito(
            "Freyja",
            "El collar de los Brísingar - Sörla þáttr_",
            """
            Descubrió la joya en el taller de cuatro enanos llamados Brísingar.
            
            Fascinada por su belleza, deseó conseguirla y entregarles una recompensa por su trabajo. Pero la joya fue robada mientras dormía y acudió a Heimdall para recuperarla.
            
            Loki, siempre atento a los secretos de los dioses, descubrió cómo había conseguido la joya. Se lo contó a Odín, quien, molesto por el asunto, ordenó a Loki que robara el collar, permitiendole hacerse pasar por el.
            
            Loki sabía que no podría acercarse a Freyja sin ser descubierto. Su morada estaba protegida por el guardian, y la diosa dormía con el collar prendido al cuello. Así que recurrió a sus poderes de transformación.
            
            Cuando Freyja descubrió el robo, reclamó su joya. Odín impuso a Freyja una condición para recuperarla. Le exigió que provocara una guerra entre dos reyes mortales, enfrentando a sus ejércitos en una batalla interminable.

            Ambos bandos debían lucharan sin descanso hasta que sus guerreros muertos resucitaran al día siguiente para volver a combatir.
            
            Freyja aceptó y, de este modo, recuperó su collar Brísingamen. Esta historia pertenece al Sörla þáttr_.
            
            ¿Y qué ocurrió con Heimdall?
            Existe otra tradición mucho más antigua, Húsdrápa_ en la que Heimdall descubre el robo.

            El collar quedó asociado para siempre con la belleza, el poder y la riqueza de Freyja.
            """.trimIndent()
        ),

        // EIR &00000000
        RelatoMito(
            "Eir",
            "La guardiana de la sanación - Fjölsvinnsmál",
            """
            En Lyfjaberg, un bastión en la tierra de los gigantes, habita Eir y un séquito de nueve doncellas de la sanación. Se dice que La montaña en sí misma funciona como un santuario mágico de salud.
            
            Según la tradición, el monte posee propiedades tan milagrosas que cualquier persona que logre escalarlo se curará por completo incluso  de la vejez, dotando de juventud.
            
            La protección de la vida es una forma de poder entre dioses.
            """.trimIndent()
        ),

        // NJÖRÐR **
        RelatoMito(
            "Njörðr",
            "El matrimonio entre Njörðr y Skaði",
            """
            Después de la muerte del gigante Þjazi, su hija Skaði acudió armada a Asgard para exigir compensación a los Æsires.
            
            Los dioses le ofrecieron desposar, para ello debía elegir un consorte, pero con una condición.
            Skaði aceptó, creyó reconocer los hermosos pies de Baldr, pero en realidad pertenecían a Njörðr, dios del mar y la navegación.

            Ambos se casaron e intentaron vivir juntos. Sin embargo, amaba el sonido de las olas, mientras Skaði prefería la nieve de las altas montañas. Acordaron alternar su residencia, pasando temporadas en Nóatún y otras en Þrymheimr, para solventarlo. Y su unión era Sol, y los bancos de niebla sobre los mares escalaban hasta lo alto de las cumbres nevadas protegiendo su calor.
            Su unión se convirtió en un relato sobre dos naturalezas que no podían convivir fácilmente.
            """.trimIndent()
        ),

        // HEL **
        RelatoMito(
            "Hel",
            "El reino de los muertos",
            """
            Cuando los dioses descubrieron el peligro que podían representar los hijos de Loki, decidieron separarlos y asegurar sus destinos.
            A Hel le fue entregado un reino en las profundidades de Yggdrasil, que recibió el nombre de su reina, quedando ligado a ella a traves de un vínculo que trascendía la propia corona: Hel, la reina que no solo lo gobernaba, sino que le había otorgado su propia identidad.

            Allí recibía a quienes llegaban al mundo de los muertos sin haber encontrado su final en el campo de batalla. Su reino está gobernado por sus propias leyes y no todos pueden abandonarlo libremente.
            
            Cuando Baldr murió, su espíritu llegó hasta el reino de Hel. Los dioses enviaron a Hermóðr, su hermano, para pedir su liberación.
            Hel aceptó. Con una condición: todas las criaturas deberían llorar por Baldr. Todas lo hicieron salvo una, una figura llamada Þökk, se negó. Así, Baldr permaneció en el reino de Hel hasta el Ragnarök, el final de los tiempos.
            
            Caprichoso el destino que permite a la nuestra, señora de todos proteger a Paz, y brindarle su protección y su cama y su hogar hasta pasado el Ragnarók, el destino final de los dioses y de Yggdrasil. Una batalla colosal en la que dioses, gigantes y monstruos se presentan por El Årbol. Porque la guerra es la Destrucción, y el mundo renace y surge de la Paz, Una NUEVA Hera. 
            """.trimIndent()
        ),

        // HEIMDALL *
        RelatoMito(
            "Heimdall",
            "El centinela del Bifröst",
            """
            Es el vigilante de los dioses y protector del puente Bifröst, el camino resplandeciente que conecta Midgard y Asgard. Su origen es extraordinario: las tradiciones nórdicas lo relacionan con nueve madres.
            Posee sentidos tan extraordinarios que escucha la hierva crecer, y observarla a enormes distancias.

            Su hogar esta cerca del puente y apenas necesitaba dormir. Su principal misión es proteger las fronteras del reino Asgard, el su vigía protector. Para cumplirla, custodia el Gjallarhorn, un cuerno cuyo sonido podría escucharse por todos los mundos. Cuando llegara el Ragnarök, Heimdall haría sonar el cuerno para anunciar el comienzo de la batalla. Allí se enfrentaría con Loki, hiriéndose de muerte uno al otro.
            """.trimIndent()
        ),

        // TYR *
        RelatoMito(
            "Tyr",
            "El sacrificio de Tyr ante Fenrir",
            """
            El gigantesco lobo, crecía de forma tan amenazadora que los dioses comenzaron a temer su poder. Intentaron encadenarlo varias veces, pero rompía todas las cadenas. Los enanos fabricaron Gleipnir, una atadura mágica hecha con elementos imposibles.

            El lobo sospechó que aquello era una trampa y exigió que uno de los dioses colocara su mano en sus fauces como garantía. Tyr aceptó el desafío y puso su mano derecha dentro de la boca de Fenrir. Cuando el lobo descubrió que no podía liberarse, cerró sus mandíbulas y segó la mano de Tyr.

            El dios perdió su mano, pero los demás consiguieron contener a Fenrir hasta el Ragnarök. Su sacrificio es símbolo de valor y responsabilidad.
            """.trimIndent()
        ),

        // SKAÐI **
        RelatoMito(
            "Skaði",
            "El amor de Ullr",
            """
            Es la diosa del invierno y la cacería con arco.
            Era hija del gigante Þjazi, y cuando este fue asesinado por los Æsir, Skaði marchó a Asgard en busca de venganza, para exigir justicia. Temeroso de que los Æsires enfrentaran a la diosa del invierno, Odín le ofreció a Skaði poner los ojos de su padre como estrellas y desposar un dios.
            Los dioses negociaron con ella y le ofrecieron elegir marido. La única condición impuesta fue elegir compañero con sólo ver los pies de los pretendientes. Ella esperaba elegir los hermosos pies de Baldr, pero erró el tiro y escogió a Njörðr, un Vanir.
            Intentaron compartir sus hogares, pero sus preferencias eran incompatibles. Njörðr no soportaba los lobos y el frío de las montañas, mientras Skaði echaba de menos su nieve cuando permanecía junto al mar. No estaban hechos el uno para el otro y, finalmente, se distanciaron.
            Hay quien afirma, que tras el primer matrimonio, se casó de nuevo.
            'Amado Ullr reina en mi nieve..', un esquiador. Hijo de Sif y adoptivo de Thor.
            Tal vez vio el reflejo de los pies de su padre, una Arquera nunca erra un tiro sin intención.
            """.trimIndent()
        ),

        // ULL *
        RelatoMito(
            "Ull",
            "El dios del escudo y las nieves",
            """
            Ull aparece en la tradición nórdica como una figura divina vinculada con el arco, la caza, los esquís y el dominio de los paisajes invernales.

            En los poemas antiguos se menciona su residencia, Ýdalir, cuyo nombre puede traducirse como los valles de los tejos.
            Este árbol proporciona una madera apreciada para fabricar los mejores arcos. Y le regalo uno a su mujer al desposarla.

            También se conserva una referencia a Ull relacionada con los juramentos solemnes, lo que demuestra que su importancia iba más allá de la caza y el combate.

            Aunque las fuentes no conservan una gran aventura individual protagonizada por él.
            """.trimIndent()
        ),

        // URÐR **
        RelatoMito(
            "Urðr",
            "Las Tres Señoras",
            """
            Urðr es una de las tres Nornas, las figuras que conocen y determinan el destino de los seres de los nueve mundos.
            
            Junto a sus hermanas Verðandi y Skuld, habitaron cerca al Pozo de Urd, el pozo del destino bajo las raíces de Yggdrasil. Las tres Nornas cuidaban del árbol cósmico y riegaban sus raíces con el agua del pozo, acompañada de una sustancia blanca que protege su corteza.

            Urðr representa lo que ya había sucedido:
            el pasado, las acciones realizadas y las consecuencias que permanecen.

            Ni siquiera los dioses pueden escapar completamente al destino que las Nornas conocen y custodian.
            """.trimIndent()
        ),

        // VERÐANDI **
        RelatoMito(
            "Verðandi",
            "Las Tres Señoras",
            """
            Verðandi es una de las tres Nornas que habita el Lago Urðarbrunnr, en el centro del árbol.

            Su nombre está relacionado con aquello que está sucediendo, con el presente y con el devenir de los acontecimientos. Es el momoento.

            Junto a Urðr y Skuld, participa en el cuidado del árbol del mundo y en el conocimiento del destino de Dioses y mortales. Mientras el pasado permanece en la memoria de Urðr y el futuro en Skuld, Verðandi representa el instante en el que vivimos, en el que las decisiones se convierten en acontecimientos.

            Su figura recuerda que cada acción forma parte del destino que se construye a cada instante.
            """.trimIndent()
        ),
        RelatoMito(
            "Verðandi",
            "Las Señoras en Völuspá_",
            """
            Yo sé que se riega un fresno sagrado,
            el alto Yggdrasil, con blanco limo;
            eso es el rocío que baja del valle;
            junto al pozo de Urd siempre verde se yergue.
            Vienen de allá muy sabias mujeres,
            tres, de las aguas que están bajo el árbol;
            una Urd se llamaba, la otra Verdandi,
            -su tabla escribían- Skuld la tercera;
            los destinos regían, les daban sus vidas
            a los seres humanos, su suerte a los hombres...
            """.trimIndent()
        ),

        // SKULD **
        RelatoMito(
            "Skuld",
            "Las Tres Señoras",
            """
            Skuld es la tercera de las Nornas, junto a sus hermanas Urðr y Verðandi.

            Su nombre se relacione con aquello que deba ocurrir, con la obligación y con lo que aún está pendiente.

            Las tres hermanas habiten junto a Urd, cuiden las raíces del Yggdrasil y conocedora del destino de los seres.

            Esta vinculada con el futuro y los conocimientos que todavía deberán cumplirse.

            En algunas tradiciones también aparece relacionada con las valquirias, Aquellas figuras que participan en la elección de los guerreros de Yggdrasil.

            Su presencia recuerda que el destino no siempre es conocido por quienes deben enfrentarse a él.
            """.trimIndent()
        ),

        // ANGRBOÐA **
        RelatoMito(
            "Angrboða",
            "La Madre de los Tres",
            """
            Se unió en matrimonio con Loki.
            De su unión tiene tres hijos: Fenrir, el lobo;
            Jörmungandr, la serpiente que rodea y sella las mareas en Midgard; y Hel, Diosa que godierna Hel.

            Cuando Odín y los demás conocieron las proezas sobre aquellos, comprendieron que tenían un papel decisivo en la destrucción del orden establecido.

            Los dioses separaron a los tres. Para armoniar el ore.
            Fenrir se encadenó, Jörmungandr se sumergió al océano y Hel gobierna su propio reino. Sin embargo, sus destinos no podrían evitarse. Durante el Ragnarök, los hijos de Angrboða participarían en la caída del Universo.
            """.trimIndent()
        ),

        // BALDR **
        RelatoMito(
            "Baldr",
            "La muerte del Dios luminoso",
            """
            Baldr era conocido por su belleza y bondad. Era hijo de Padre y Madre de todos, y su muerte se convertiría en uno de los acontecimientos más trágicos de la mitología nórdica.

            Después de que Frigg lograra que casi todas las cosas Dijeron servirle; Los dioses comenzaron a divertirse (de no hacerle daño) lanzándole objetos que rebotaban sin causarle herida alguna. Loki descubrió que el muérdago no había realizado ningún juramento.
            Aprovechando la ceguera de Höðr, entrego el muerdago al ciego, lo animó para que lanzara una rama de aquella planta a Baldr. Lo que la convirtió en flecha, lo engañó. El proyectil atravesó al dios y acabó csu vida. Su hermano viajó hasta el reino de Helheim para intentar recuperarlo, pero la condición impuesta por la diosa de los muertos no pudo cumplirse.

            La muerte de Baldr se convirtió
            en uno de los presagios del Ragnarök.
            """.trimIndent()
        ),

        // ÞRÚÐR **
        RelatoMito(
            "Þrúðr",
            "La boda evitada",
            """
            Þrúðr es la hermana de Móði, Magni y Lóriði hija de Thor y Sif.

            Alvíss llegó ante Thor convencido de que podía reclamar la mano de Þrúðr. El dios del trueno no aceptó fácilmente aquella propuesta y decidió poner a prueba su inteligencia. Thor comenzó a formular preguntas sobre los nombres que los distintos pueblos daban al cielo, la tierra, el sol, la luna y otros elementos del universo.

            Alvíss respondió con extraordinaria sabiduría, pero Thor prolongó el interrogatorio hasta que apareció el Amanecer.
            Así, Thor impidió la unión entre Alvíss y su hija.
            """.trimIndent()
        ),

        // ALVÍSS **
        RelatoMito(
            "Alvíss",
            "El desafío de Thor al enano sabio",
            """
            Un relato famoso cuenta que el enano Alvíss pretendía casarse con ella, a cambio de unas armas que había fabricado para los dioses. 
            Thor ideó un plan para evitarlo sometiendo al enano a una prueba que duró toda la noche. En lugar de enfrentarse directamente, el dios decidió desafiarlo mediante preguntas sobre el conocimiento de los diferentes pueblos.

            Alvíss respondió correctamente a todas las preguntas, demostrando su enorme conocimiento. Pero Thor había conseguido perdurarlo hasta el amanecer. Cuando los primeros rayos del sol alcanzaron al enano, este quedó convertido en piedra.

            Este relato, conservado en el poema Alvíssmál, muestra cómo Thor utilizando la astucia y el tiempo venció a un adversario sin combatir tansiquiera.
            """.trimIndent()
        ),

        // GERÐR **
        RelatoMito(
            "Gerðr",
            "La llegada de Skírnir a Jötunheimr",
            """
            Una hermosa giganta vivía en Jötunheimr. Su encuentro con Freyr cambió su destino.
            Cuando Freyr la contempló desde el trono de Odín, quedó profundamente enamorado. Sin embargo, no podía viajar fácilmente hasta ella, por lo que pidió a Skírnir que lo sirviera.

            Skírnir aceptó la misión y recibió como recompensa la Espada de Freyr, una espada mágica capaz de luchar por sí sola... Al llegar ante Gerðr, le ofreció regalos y riquezas, pero ella rechazó sus primeras propuestas. ¡Skírnir recurrió a la magia! y consiguió que Gerðr aceptara encontrarse con Freyr en su bosque, Barri.
            El relato conservado en el poema Skírnismál cuenta cómo aquella unión quedó ligada al destino de Freyr, que entregó su espada para conseguir el amor Verdadero.
            """.trimIndent()
        )
    )

    suspend fun insertarMitos(database: AppDatabase) {

        withContext(Dispatchers.IO) {

            database.withTransaction {

                val dioses = database.diosDao().obtenerTodos()

               // Convertir a mapa la list (clave .nombre - valor obj. Dios)
                val diosesPorNombre = dioses.associateBy { it.nombre }

                val dao = database.mitoDao()

                // Obtener los mitos existentes junto con sus dioses.
                val mitosExistentes = dao.obtenerMitosConDios()
                    .map { it.mito.diosId to it.mito.titulo }
                    .toMutableSet()

                leyendas.forEach { leyenda ->

                    val dios = diosesPorNombre[leyenda.dios]
                        ?: return@forEach

                    val clave = dios.id to leyenda.titulo

                    // Inserta únicamente si no existe.
                    if (mitosExistentes.add(clave)) {
                        dao.insertar(
                            Mito(
                                diosId = dios.id,
                                titulo = leyenda.titulo,
                                historia = leyenda.historia
                            )
                        )
                    }
                }
            }
        }
    }
}
