/*
 * Al menos las 4 FORMAS del tetris clásico
 * 
 * El COLOR es ALEATORIO, cada bloque de la pieza tiene un color aleatorio (puede ser diferente)
 * 
 * Los COLORES dan PUNTOS dependiendo de cómo están posicionados según su FRECUENCIA en el ÁRBOL AUTOBALANCEADO
 */
public class Pieza {
    private int[][] forma;
    private int color; // color = número, facilita el print

    public Pieza(int[][] forma, int color) {
        this.forma = forma;
        this.color = color;
    }

/*
 * Método rotar: izquierda, derecha y abajo en sentido reloj
 * Controles: WASD y enter (bajar la pieza de una)
 * La pieza no baja a menos que se pulse S (abajo)
 * W no tiene función en este programa.
 */
}
