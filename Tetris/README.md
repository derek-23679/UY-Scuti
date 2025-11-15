# UY-Scuti
## Proyecto: Tetris
Tarea programada 2

## Integrantes:

C5G480 - Derek Liang Zheng

C35226 - Daniel Mora Matamoros

C5H687 - Cristian Moya Portalanza

## Descripción:

* Características (Objetivo y alcance)
**Objetivo:** Tetris en consola con sistema de puntuación basado en un árbol de frecuencias autobalanceado.

**Alcance:**
- Tablero de 10x20
- 5 piezas con diferente forma
- Controles WASD + ENTER
- Detección de colisión
- Cada pieza de colores diferentes
- Ghost Piece
- Gravedad tras limpiar fila/columna

* Instrucciones de uso (Cómo compilar y ejecutar)
**Requisitos:** Java JDK

**Compilación:**
- Abrir la terminal
- Llegar al directorio UY-Scuti/Tetris/Codigo (con cd UY-Scuti/Tetris/Codigo)
- Compilar (javac .\Main.java)
- Ejecutar (java Main)

* Controles
- W: Rotar pieza
- A: Mover pieza a la izquierda
- D: Mover pieza a la derecha
- S: Bajar pieza (se coloca)
- Q: Salir del juego

* Diseño (Decisiones de diseño, 1-2 párrafos, explicar estructura POO)
Está diseñado con la estructura POO en mente, las clases están definidas de manera que las responsabilidades estén separadas. **Arbol** se encarga de contar la frecuencia en la que aparecen los colores y los almacena en un árbol binario autobalanceado (izquierda y derecha) de ahí sale el sistema de puntuación.
**CalculadorPuntaje** asigna los puntos otorgados por cada color según su frecuencia. **Color** tiene referencias para los print a color. **Main** es el punto de entrada del programa. Finalmente, **Tetris** es donde se programó la mayoría de la lógica del código, no está tan bien segmentado, tiene todos los métodos que involucren el tablero (mostrar la pieza, romper filas/columnas, Ghost Piece, mensajes, etc).

* Limitaciones y futuro
**Limitaciones:**
- Algunos mensajes están muy básicos
- La gravedad no está refinada (está raro el sistema que baja los bloques)
- No funciona por tiempo
- No se puede bajar la pieza parcialmente
- Hay que presionar ENTER para cualquier acción
- La mayoría se programó en la clase Tetris

**Futuro:**
- Mejorar la interfaz
- Mejorar la gravedad
- Pieza actual cae con el tiempo
- Bajar la pieza actual parcialmente
- Eliminar necesidad de ENTER
- Mejorar la estructura POO