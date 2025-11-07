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
    private String[][] tablero;

    public Tetris() {
        tablero = new String[20][10];
        Pieza actual = new Pieza();
        Pieza siguiente = new Pieza();

        System.out.println("Tablero inicial");
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[i][j] != null) {
                    System.out.print(Color.BLUE + "ALGO" + Color.RESET);
                } else {
                    System.out.print("NULO");
                }
            }
            System.out.println();
        }

        System.out.println("Nuevo tablero con pieza actual");
        
        // Copia de tablero
        String[][] tableroTemp = new String[20][10];
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                tableroTemp[i][j] = tablero[i][j];  // Copia real
            }
        }
        
        // Colocar la pieza en el tablero temporal
        String[][] formaActual = actual.getForma();
        for (int i = 0; i < formaActual.length && i < tableroTemp.length; i++) {
            for (int j = 0; j < formaActual[0].length && j < tableroTemp[0].length; j++) {
                if (formaActual[i][j] != null) {
                    tableroTemp[i][j] = formaActual[i][j];
                }
            }
        }
        
        // Tablero temporal
        for (int i = 0; i < tableroTemp.length; i++) {
            for (int j = 0; j < tableroTemp[0].length; j++) {
                if (tableroTemp[i][j] != null) {
                    switch (tableroTemp[i][j]) {
                        case "RED": 
                            System.out.print(Color.RED + "██" + Color.RESET);
                            break;
                        case "GREEN": 
                            System.out.print(Color.GREEN + "██" + Color.RESET);
                            break;
                        case "YELLOW": 
                            System.out.print(Color.YELLOW + "██" + Color.RESET);
                            break;
                        case "BLUE": 
                            System.out.print(Color.BLUE + "██" + Color.RESET);
                            break;
                        case "CYAN": 
                            System.out.print(Color.CYAN + "██" + Color.RESET);
                            break;
                    }
                } else {
                    System.out.print("  "); // Espacio vacío
                }
            }
            System.out.println();
        }

        System.out.println("Siguiente pieza");
        String[][] formaSiguiente = siguiente.getForma();
        for (int i = 0; i < formaSiguiente.length; i++) {
            for (int j = 0; j < formaSiguiente[0].length; j++) {
                if (formaSiguiente[i][j] != null) {
                    switch (formaSiguiente[i][j]) {
                        case "RED": 
                            System.out.print(Color.RED + "██" + Color.RESET);
                            break;
                        case "GREEN": 
                            System.out.print(Color.GREEN + "██" + Color.RESET);
                            break;
                        case "YELLOW": 
                            System.out.print(Color.YELLOW + "██" + Color.RESET);
                            break;
                        case "BLUE": 
                            System.out.print(Color.BLUE + "██" + Color.RESET);
                            break;
                        case "CYAN": 
                            System.out.print(Color.CYAN + "██" + Color.RESET);
                            break;
                    }
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}