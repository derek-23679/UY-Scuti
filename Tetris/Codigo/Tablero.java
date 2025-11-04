// Tablero 10 ancho x 20 alto (o más para manejo de errores)
public class Tablero {
    int[][] matrizJuego;

    public Tablero() {
        matrizJuego = new int[20][10];
    }
}
/*
 * Métodos
 * 1. romper fila (horizontal y vertical)
 * 2. completar fila
 * 3. verificar color dominante
 * 4. regla del combo: se rompen consecutivamente filas del mismo color dominante, un combo por fila e.g. x2 x3 x4
 * 5. Colocar pieza
 * 6. Game over si se pasa de altura (20).
 * Se eliminan de abajo para arriba para cálculo de puntaje
 * Tomar en cuenta colisiones: bordes de la matriz y otros bloques colocados
 * Cuando se rompe fila bajar las piezas de arriba (si es horizontal)
 * Puntaje siempre visible
 * FILA VERTICAL DE 4 MISMO COLOR ROMPE FILA
 */