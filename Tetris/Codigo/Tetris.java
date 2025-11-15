import java.util.LinkedList;
import java.util.Queue;
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
    private int filaPieza;   
    private int colPieza;    
    private int puntaje;
    private String ultimoColorCombo;
    private int comboActual;
    private CalculadorPuntaje calculadorPuntaje; // Nuevo: para usar árbol de frecuencias

    public Tetris() {
        tablero = new String[20][10];
        actual = new Pieza();
        siguiente = new Pieza();
        filaPieza = 0;
        colPieza = tablero[0].length / 2 - 1;
        puntaje = 0;
        ultimoColorCombo = "";
        comboActual = 1;
        calculadorPuntaje = new CalculadorPuntaje(); // Inicializar calculador con árbol

        System.out.println("Controles: A=Izq | D=Der | W=Rotar | S=Caer | Q=Salir\n");

        java.util.Scanner sc = new java.util.Scanner(System.in);

        // Bucle principal con gravedad automatica
        while (true) {
            mostrarTablero(actual.getForma(), filaPieza, colPieza);
            System.out.print("\nMover pieza (A/D/W/S o Q para salir): ");

            long start = System.currentTimeMillis();
            String entrada = "";

            while ((System.currentTimeMillis() - start) < 800 && !sc.hasNextLine()) {
                // Espera 800ms antes de bajar automaticamente
            }

            if (sc.hasNextLine()) {
                entrada = sc.nextLine().trim().toUpperCase();
            } else {
                entrada = "S"; // caida automatica
            }

            if (entrada.equals("Q")) {
                System.out.println("Juego terminado.");
                break;
            }

    if (entrada.length() == 1) {
        char tecla = entrada.charAt(0);

        if (tecla == 'S') {
            caerPieza(); 
        } 
        else if (tecla == 'G') {
            aplicarGravedad();
        }
        else {
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
        // aplicarGravedad();
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
         * como la pieza actual "flotante"
         */

        // Limpia pantalla
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // Mostrar la siguiente pieza
        if (siguiente != null) {
            System.out.println("Siguiente pieza:");
            String[][] forma = siguiente.getForma();
            for (int i = 0; i < forma.length; i++) {
                System.out.print("  ");
                for (int j = 0; j < forma[i].length; j++) {
                    if (forma[i][j] != null) {
                        switch (forma[i][j]) {
                            case "RED":    System.out.print(Color.RED + "██" + Color.RESET); break;
                            case "GREEN":  System.out.print(Color.GREEN + "██" + Color.RESET); break;
                            case "YELLOW": System.out.print(Color.YELLOW + "██" + Color.RESET); break;
                            case "BLUE":   System.out.print(Color.BLUE + "██" + Color.RESET); break;
                            case "CYAN":   System.out.print(Color.CYAN + "██" + Color.RESET); break;
                            default:       System.out.print("??");
                        }
                    } else {
                        System.out.print("  ");
                    }
                }
                System.out.println();
            }
            System.out.println();
        }

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
        System.out.println("\nPUNTAJE ACTUAL: " + puntaje);
    }

    public boolean colisiona(String[][] forma, int filaP, int colP) {
        return colisionaRe(forma, filaP, colP, 0, 0);
    }

    private boolean colisionaRe(String[][] forma, int filaP, int colP, int i, int j) {
        int h = forma.length;
        int w = forma[0].length;
        int filasTab = tablero.length;
        int colsTab = tablero[0].length;

        if (i == h) return false;

        // Pasar a la siguiente fila
        if (j == w) return colisionaRe(forma, filaP, colP, i + 1, 0);

        if (forma[i][j] == null) return colisionaRe(forma, filaP, colP, i, j + 1);

        int fi = filaP + i;
        int cj = colP + j;

        // Verificación de límites y colisiones
        if (cj < 0 || cj >= colsTab) return true;
        if (fi >= filasTab) return true;
        if (fi >= 0 && tablero[fi][cj] != null) return true;

        // Continuar con la siguiente celda
        return colisionaRe(forma, filaP, colP, i, j + 1);
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

        // ACTUALIZACIÓN: Actualizar árbol de frecuencias después de fijar pieza
        calculadorPuntaje.actualizarFrecuencias(tablero);

        // Revisa las lineas y columnas despues de colocar una pieza 
        verificarFilas();
        verificarColumnas();
    }

    /**
     * 
     * Verifica si hay filas completas y las elimina, aplicando puntaje segun el color dominante y combos
     *
     */
    private void verificarFilas() {
        verificarFilasRe(tablero.length - 1);
    }

    private void verificarFilasRe(int fila) {
        if (fila < 0) return;

        boolean llena = true;
        java.util.HashMap<String, Integer> colores = new java.util.HashMap<>();

        for (int j = 0; j < tablero[0].length; j++) {
            if (tablero[fila][j] == null) {
                llena = false;
                break;
            }
            colores.put(tablero[fila][j], colores.getOrDefault(tablero[fila][j], 0) + 1);
        }

        if (llena) {
            String dominante = null;
            int max = 0;
            for (var entry : colores.entrySet()) {
                if (entry.getValue() > max) {
                    dominante = entry.getKey();
                    max = entry.getValue();
                }
            }

            eliminarFilaRe(fila);
            sumarPuntaje(dominante);

            // Después de eliminar, volver a revisar la misma fila
            verificarFilasRe(fila);
        } else {
            // Continuar con la fila superior
            verificarFilasRe(fila - 1);
        }
    }

    private void eliminarFilaRe(int fila) {
        if (fila <= 0) {
            tablero[0] = new String[tablero[0].length];
            return;
        }

        tablero[fila] = java.util.Arrays.copyOf(tablero[fila - 1], tablero[fila - 1].length);
        eliminarFilaRe(fila - 1); // 👈 llamada recursiva
    }

    /**
     *
     * Elimina una fila completa y baja todas las de arriba
     * 
     */
    private void eliminarFila(int fila) {
        for (int i = fila; i > 0; i--) {
            for (int j = 0; j < tablero[0].length; j++) {
                tablero[i][j] = tablero[i - 1][j];
            }
        }
        for (int j = 0; j < tablero[0].length; j++) {
            tablero[0][j] = null;
        }
    }

    /**
     *
     * Revisa si hay 4 bloques del mismo color en columna y los elimina
     *
     */
    private void verificarColumnas() {
        for (int j = 0; j < tablero[0].length; j++) {
            int contador = 1;
            for (int i = 1; i < tablero.length; i++) {
                if (tablero[i][j] != null && tablero[i][j].equals(tablero[i - 1][j])) {
                    contador++;
                    if (contador == 4) {
                        String color = tablero[i][j];
                        eliminarColumnaVertical(i, j);
                        sumarPuntaje(color);
                        break;
                    }
                } else {
                    contador = 1;
                }
            }
        }
    }

    private void eliminarColumnaVertical(int i, int j) {
        for (int k = i; k > i - 4; k--) {
            tablero[k][j] = null;
        }
    }

    /**
     *
     * Aumenta el puntaje segun el color dominante y combos consecutivos
     * MODIFICADO: Ahora usa árbol de frecuencias para calcular puntaje basado en rareza
     *
     */
    private void sumarPuntaje(String color) {
        // CAMBIO: Usar calculador con árbol en lugar de valores fijos
        int base = calculadorPuntaje.calcularPuntajePorColor(color);

        // Combo por color consecutivo
        if (color.equals(ultimoColorCombo)) {
            comboActual++;
            base *= comboActual;
            System.out.println("Combo x" + comboActual + " (" + color + ")");
        } else {
            comboActual = 1;
            ultimoColorCombo = color;
        }

        puntaje += base;
        System.out.println("+" + base + " puntos (color " + color + ")");
        System.out.println("Puntaje total: " + puntaje);
    }

    private void mostrarSiguiente() {
        System.out.println("\nSiguiente pieza:");
        String[][] forma = siguiente.getForma();
        for (int i = 0; i < forma.length; i++) {
            for (int j = 0; j < forma[i].length; j++) {
                if (forma[i][j] != null)
                    System.out.print("■ "); // o forma[i][j].charAt(0) para ver color inicial
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }

    /*
     * 
     * Método para aplicar gravedad a los bloques "flotantes" tras eliminar una columna o fila (bloques que no están conectados a ningún otro bloque ni el suelo)
     * 
     * 
    */
    private void aplicarGravedad() {

        int filas = tablero.length;
        int cols  = tablero[0].length;

        // Matriz para identificar bloques conectados al suelo
        boolean[][] conectados = new boolean[filas][cols];

        // BFS desde todos los bloques del suelo
        Queue<int[]> cola = new LinkedList<>();

        for (int j = 0; j < cols; j++) {
            if (tablero[filas - 1][j] != null) {
                conectados[filas - 1][j] = true;
                cola.add(new int[]{filas - 1, j});
            }
        }

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}}; // arriba, abajo, izquierda, derecha (direcciones en las que un bloque puede estar conectado a otro)

        while (!cola.isEmpty()) {
            int[] pos = cola.poll();
            int r = pos[0];
            int c = pos[1];

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < filas && nc >= 0 && nc < cols) {
                    if (tablero[nr][nc] != null && !conectados[nr][nc]) {
                        conectados[nr][nc] = true;
                        cola.add(new int[]{nr, nc});
                    }
                }
            }
        }

        String[][] nuevo = new String[filas][cols];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < cols; j++) {
                if (conectados[i][j]) {
                    nuevo[i][j] = tablero[i][j];
                }
            }
        }

        for (int i = filas - 1; i >= 0; i--) {
            for (int j = 0; j < cols; j++) {

                if (tablero[i][j] != null && !conectados[i][j]) {

                    int r = i;

                    // buscar hasta dónde puede caer
                    while (r + 1 < filas && nuevo[r + 1][j] == null) {
                        r++;
                    }

                    nuevo[r][j] = tablero[i][j];
                }
            }
        }

        tablero = nuevo;
    }
}