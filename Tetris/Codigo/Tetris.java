/*
 *
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
 * 
 */

public class Tetris {
    private int[][] tablero;
    private String[][] tableroColor; // Lo mismo que tablero pero con String del color
    
    public Tetris() {
        tableroVacio(20, 10); // Tablero 10 ancho x 20 alto (o más para manejo de errores)
        printMatrix();
    }

    private void printMatrix() {
        // Marco superior
        for (int i = 0; i < tablero[0].length + 2; i++) {
            System.out.print(Color.PURPLE + "=");
        }

        for (int i = 0; i < tablero.length; i++) {
            System.out.print(Color.PURPLE + "\n■"); // Marco lateral

            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[i][j] == 1) {
                    switch (tableroColor[i][j]) {
                        case "RED": System.out.print(Color.REDBG + "█");
                        case "GREEN": System.out.print(Color.GREENBG + "█");
                        case "YELLOW": System.out.print(Color.YELLOWBG + "█");
                        case "BLUE": System.out.print(Color.BLUEBG + "█");
                        case "CYAN": System.out.print(Color.CYANBG + "█"); 
                    }
                } else {
                    System.out.print(Color.RESET + " ");
                }
            }

            System.out.print(Color.PURPLE + "■"); // Marco lateral
        }

        // Marco inferior
        for (int i = 0; i < tablero[0].length + 2; i++) {
            if (i == 0) {
                System.out.println();
                System.out.print(Color.PURPLE + "=");
            } else {
                System.out.print(Color.PURPLE + "=" + Color.RESET);
            }
        }
    }

    private void tableroVacio(int filas, int columnas) {
        tablero = new int[filas][columnas];
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                tablero[i][j] = 0;
            }
        }
    }
}