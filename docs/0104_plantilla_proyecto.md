# Plantilla: propuesta del Proyecto A

---

## 0 · Datos

| |              |
|---|--------------|
| **Nombre de la app** | El Panteon   |
| **Autor/a** | Ivar Pereira |
| **Fecha** | 22/10/26     |

---

## 1 · La idea en una frase

> Qué hace tu app y para quién, en una sola frase.
> Fórmula: «Una app que permite a [quién] hacer [qué] para [para qué].»
> 
Es una app de mitologgia Nórdica, para usuarios interesados. 

---

## 2 · El problema

> ¿Qué problema resuelve? ¿Cómo se resuelve hoy sin tu app?
> 
informacion accesible y didactica. Expuesta de un modo moderno y actual.

Paginas web, libros, vídeos...
---

## 3 · Personas usuarias

> ¿Quién la va a usar? Describe a una persona concreta: edad, soltura con la
> tecnología, cuándo y dónde abre la app, cuánto tiempo le dedica y qué pasa
> si le falla.
> 
Personas de entre 15 y 45 años interesadas en la mitología nórdica, con conocimientos tecnológicos básicos o avanzados. Utilizan la app desde el móvil, en casa o durante sus ratos libres, dedicando entre 5 y 15 minutos a descubrir dioses, criaturas e historias.
Si la app falla, pueden perder el interés y recurrir a otras fuentes de información.
---

## 4 · Funcionalidades

### Imprescindibles (sin esto la app no tiene sentido)

| #  | Funcionalidad                                                                             |
|----|-------------------------------------------------------------------------------------------|
| F1 | Catálogo de dioses: información sobre los dioses y diosas, sus atributos y sus historias. |
| F2 | Dominio y hogar: información sobre el lugar donde habita dentro de Yggdrasil.             |
| F3 | Biblioteca personal: añade los dioses a una biblioteca personal del usuario.              |

### Opcionales (si sobra tiempo)

| #  | Funcionalidad                                                                                 |
|----|-----------------------------------------------------------------------------------------------|
| O1 | Bestiario mitológico: información sobre criaturas, seres y monstruos de la mitología nórdica. |
| O2 |                                                                                               |

---

## 5 · Pantallas

| Pantalla   | Para qué sirve                              | Se llega desde |
|------------|---------------------------------------------|----------------|
| Inicio     | Presenta la app.                            | (arranque)     |
| Perfil     | Ajustes perfil.                             | Inicio         |
| Glosario   | Muestra una lista de dioses para consultar. | Inicio         |
| Ficha      | Presenta información detallada.             | Glosario       |
| Yggdrasil  | Explorar Yggdrasil.                         | Inicio         |
| Biblioteca | Muestra una lista para consultar favoritos. | Inicio         |

---

## 6 · Bocetos

> Dibuja las pantallas principales. A mano y fotografiado es válido.
> Pega aquí las imágenes o indica el nombre de los archivos adjuntos.

---

## 7 · Qué datos guarda la app

| Tipo de dato | Campos                                   | Ejemplo                                                                                                                                                                                                                                                                                                                                                                          |
|--------------|------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Dios         | nombre, atributos, reino, nota e imagen. | Odín, sabiduría, Asgard, <<aLll Father>>, png                                                                                                                                                                                                                                                                                                                                    |
| Mito         | dios, título, historia, imagen.          | Odín, El precio de la sabiduría, "Un día, descubrió la existencia del pozo de Mímir, una fuente sagrada cuyas aguas otorgaban una sabiduría extraordinaria. Sin embargo, Mímir, el guardián del pozo, no permitía que cualquiera bebiera de él. Cuando Odín pidió beber de sus aguas, Mímir le exigió un precio: debía entregar uno de sus ojos a cambio del conocimiento.", png |
| Biblioteca   | usuario, favoritos.                      | Listado de dioses favoritos del usuario.                                                                                                                                                                                                                                                                                                                                         |

---

## 8 · Encaje con los requisitos del módulo

> Apartado obligatorio: ninguna casilla puede quedar vacía.

| Requisito                                                             | Dónde encaja en tu app                                                                        | Tema |
|-----------------------------------------------------------------------|-----------------------------------------------------------------------------------------------|------|
| **Persistencia de datos** — la información sobrevive al cerrar la app | los favoritos se guardan localmente y permanecen disponibles al volver a abrir la aplicación. | 4    |
| **Servicio web** — la app consulta datos por internet                 | La aplicación consulta recursos de Internet para obtener y mostrar imágenes                   | 5    |
| **Sensor o localización**                                             | el aclerometro permite al usuario explorar Yggdrasil.                                         | 6    |
| **Contenido multimedia** — foto, audio, vídeo o animación             | muestran ilustraciones mediante Coil y se reproduce música ambiental en una actividad.        | 7    |

---

## 9 · Riesgos

| Lo que me preocupa                                            | Plan B                                                                                   |
|---------------------------------------------------------------|------------------------------------------------------------------------------------------|
| Las imágenes remotas tardan en cargar o no están disponibles. | mostrar png alternativa. Crear un espacio, tablero privado, para organizar las imágenes. |
| El sensor produce movimientos involuntarios u otro error.     | permitir seleccionar los mundos mediante pulsación.                                      |
| El desarrollo supera el tiempo disponible.                    | Priorizar la persistencia, limitar funcionalidad biblioteca.                             |
---

## Antes de entregar

- [ ] La idea cabe en una frase.
- [ ] El público es una persona concreta, no «todo el mundo».
- [ ] Hay **3 o 4** funcionalidades imprescindibles, no diez.
- [ ] Cada funcionalidad imprescindible tiene su pantalla.
- [ ] Hay bocetos de las pantallas principales.
- [ ] **Las cuatro casillas del apartado 8 están rellenas.**
- [ ] Está identificado al menos un riesgo con su plan B.
