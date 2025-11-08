import java.util.Scanner;

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
    private Pieza actual;
    private Pieza siguiente;
    private int filaPieza;   // posición vertical de la pieza actual
    private int colPieza;    // posición horizontal de la pieza actual
    
    public Tetris() {
        tablero = new String[20][10];
        actual = new Pieza();
        siguiente = new Pieza();
        filaPieza = 0;
        colPieza = tablero[0].length / 2 - 1;

        // Mostrar controles solo una vez al inicio (es molesto que se muestre en cada iteración)
        System.out.println("Controles: A=Izq | D=Der | W=Rotar | S=Caer | Q=Salir\n");

        java.util.Scanner sc = new java.util.Scanner(System.in);

        // Bucle principal
        while (true) {
            mostrarTablero(actual.getForma(), filaPieza, colPieza);
            System.out.print("\nMover pieza: ");
            String entrada = sc.nextLine().trim().toUpperCase();

            if (entrada.equals("Q")) {
                System.out.println("Juego terminado.");
                break;
            }

            if (entrada.length() == 1) {
                char tecla = entrada.charAt(0);

                if (tecla == 'S') {
                    caerPieza(); // caída instantánea
                } else {
                    moverPieza(tecla);
                }
            }
        }

        sc.close();
    }

    // Método para caída hasta el suelo o sobre otra pieza
    private void caerPieza() {
        String[][] forma = actual.getForma();

        // Mientras no haya colisión abajo, seguir bajando
        while (!colisiona(forma, filaPieza + 1, colPieza)) {
            filaPieza++;
        }

        fijarPieza();          // fija la pieza en el tablero
        generarNuevaPieza();   // crea una nueva pieza arriba
    }

    // Método para generar una nueva pieza
    private void generarNuevaPieza() {
        actual = siguiente;
        siguiente = new Pieza();
        filaPieza = 0;
        colPieza = tablero[0].length / 2 - 1;

        // Si la nueva pieza colisiona al aparecer, termina el juego
        if (colisiona(actual.getForma(), filaPieza, colPieza)) {
            mostrarTablero(actual.getForma(), filaPieza, colPieza);
            System.out.println("FIN DEL JUEGO (tablero lleno)");
            System.exit(0);
        }
    }

    public void mostrarTablero(String[][] pieza, int filaPieza, int colPieza) {
        /*
         * Este método imprime el tablero completo en consola,
         * mostrando tanto las piezas ya fijadas en el tablero
         * como la pieza actual "flotante".
         */

        // Limpia pantalla
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // Imprimir borde superior del tablero
        System.out.println("┌" + "──".repeat(tablero[0].length) + "┐");

        // Recorremos todo el tablero (20x10)
        for (int i = 0; i < tablero.length; i++) {
            System.out.print("│"); // borde izquierdo

            for (int j = 0; j < tablero[0].length; j++) {
                String color = null;

                // 1️. Verificar si la pieza actual ocupa esta posición
                if (i >= filaPieza && i < filaPieza + pieza.length &&
                    j >= colPieza && j < colPieza + pieza[0].length) {
                    if (pieza[i - filaPieza][j - colPieza] != null) {
                        color = pieza[i - filaPieza][j - colPieza];
                    }
                }

                // 2️. Si no hay pieza actual, usar el bloque fijo del tablero
                if (color == null) {
                    color = tablero[i][j];
                }

                // 3️. Dibujar celda (vacía o con color)
                if (color == null) {
                    System.out.print("  ");
                } else {
                    switch (color) {
                        case "RED":    System.out.print(Color.RED + "██" + Color.RESET); break;
                        case "GREEN":  System.out.print(Color.GREEN + "██" + Color.RESET); break;
                        case "YELLOW": System.out.print(Color.YELLOW + "██" + Color.RESET); break;
                        case "BLUE":   System.out.print(Color.BLUE + "██" + Color.RESET); break;
                        case "CYAN":   System.out.print(Color.CYAN + "██" + Color.RESET); break;
                        default:       System.out.print("??");
                    }
                }
            }

            System.out.println("│"); // borde derecho
        }

        // Borde inferior
        System.out.println("└" + "──".repeat(tablero[0].length) + "┘");
    }

    public boolean colisiona(String[][] forma, int filaP, int colP) {
        /*
         * Comprueba colisión de "forma" situada en (filaP, colP) con:
         * - límites del tablero
         * - bloques ya fijados en tablero
         *
         * Las celdas null de "forma" se ignoran.
         */
        int h = forma.length;
        int w = forma[0].length;
        int filasTab = tablero.length;
        int colsTab = tablero[0].length;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (forma[i][j] == null) continue;

                int fi = filaP + i;
                int cj = colP + j;

                // Fuera por izquierda/derecha
                if (cj < 0 || cj >= colsTab) return true;

                // Si está por encima del tablero (inicio), no considerar colisión vertical
                if (fi < 0) continue;

                // Fuera por abajo
                if (fi >= filasTab) return true;

                // Colisión con bloque fijado
                if (tablero[fi][cj] != null) return true;
            }
        }
        return false;
    }

    public void moverPieza(char tecla) {
        /*
         * Mueve o rota la pieza actual.
         * Teclas: A=izq, D=der, S=bajar, W=rotar horario.
         */
        int filaPrev = filaPieza;
        int colPrev = colPieza;

        char t = Character.toUpperCase(tecla);
        if (t == 'A') {
            colPieza--;
        } else if (t == 'D') {
            colPieza++;
        } else if (t == 'W') {
            // Intentar rotar: obtener forma rotada y aplicar si no colisiona
            String[][] formaRot = actual.rotarHorario();
            if (!colisiona(formaRot, filaPieza, colPieza)) {
                actual = new Pieza(formaRot);
            }
            mostrarTablero(actual.getForma(), filaPieza, colPieza);
            return;
        } else {
            // tecla no reconocida; no pasa nada
            return;
        }

        // Validar colisión tras el movimiento
        if (colisiona(actual.getForma(), filaPieza, colPieza)) {
            filaPieza = filaPrev;
            colPieza = colPrev;
        }

        mostrarTablero(actual.getForma(), filaPieza, colPieza);
    }

    private void fijarPieza() {
        String[][] forma = actual.getForma(); // obtenemos la forma de la pieza actual

        // Recorremos la matriz de la pieza
        for (int i = 0; i < forma.length; i++) {
            for (int j = 0; j < forma[i].length; j++) {
                if (forma[i][j] != null && !forma[i][j].isEmpty()) {
                    int filaTablero = filaPieza + i;
                    int colTablero = colPieza + j;

                    // Verificamos que esté dentro de los límites del tablero
                    if (filaTablero >= 0 && filaTablero < tablero.length &&
                        colTablero >= 0 && colTablero < tablero[0].length) {
                        tablero[filaTablero][colTablero] = forma[i][j];
                    }
                }
            }
        }
    }
}