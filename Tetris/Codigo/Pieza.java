/**
 * Representa una pieza del juego Tetris con forma y color aleatorios
 *
 * Reglas de implementación:
 * - Mínimo 4 formas del tetris clásico
 * - Cada pieza tiene diferentes colores
 * - Los colores son aleatorios
 * - El puntaje se determina en base a los colores y su frecuencia en el árbol autobalanceado
 * - La pieza puede rotar: A (contra reloj), D (sentido reloj)
 * - Otros controles: S (bajar la pieza), ENTER (colocar la pieza)
 * - La pieza no cae automáticamente
 */
public class Pieza {
    private String[][] forma;

    /**
     * Constructor que crea una pieza con forma y color aleatorios
     */
    public Pieza() {
        definirForma();
    }

    /**
     * Define la forma de la pieza aleatoriamente entre 5 tipos diferentes
     */
    private void definirForma() {
        switch (numeroAleatorio(5)) {
            // Forma línea
            case 1:
                forma = new String[][] {
                    {colorAleatorio()},
                    {colorAleatorio()},
                    {colorAleatorio()},
                    {colorAleatorio()}
                };
                break;
           
            // Forma cuadrado
            case 2:
                forma = new String[][] {
                    {colorAleatorio(), colorAleatorio()},
                    {colorAleatorio(), colorAleatorio()}
                };
                break;

            // Forma L
            case 3:
                forma = new String[][] {
                    {colorAleatorio(), null},
                    {colorAleatorio(), null},
                    {colorAleatorio(), colorAleatorio()}
                };
                break;

            // Forma T
            case 4:
                forma = new String[][] {
                    {null, colorAleatorio(), null},
                    {colorAleatorio(), colorAleatorio(), colorAleatorio()}
                };
                break;
           
            // Forma zigzag
            case 5:
                forma = new String[][] {
                    {colorAleatorio(), colorAleatorio(), null},
                    {null, colorAleatorio(), colorAleatorio()}
                };
                break;
        }
    }

    /**
     * Constructor que crea una Pieza a partir de una forma ya existente
     * @param forma Matriz que define la forma de la pieza
     */
    public Pieza(String[][] forma) {
        this.forma = forma;
    }

    /**
     * Devuelve una nueva matriz con la rotación horaria de la forma actual
     * @return Matriz rotada 90 grados en sentido horario
     */
    public String[][] rotarHorario() {
        String[][] original = this.forma;
        int h = original.length;
        int w = original[0].length;
        String[][] rotada = new String[w][h];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                rotada[j][h - 1 - i] = original[i][j];
            }
        }
        return rotada;
    }

    /**
     * Genera un número aleatorio dentro del límite especificado
     * @param limite Límite superior
     * @return Número aleatorio entre 1 y límite
     */
    private int numeroAleatorio(int limite) {
        return (int) (Math.random() * limite) + 1;
    }

    /**
     * Selecciona un color aleatorio de la paleta disponible
     * @return Nombre del color aleatorio (RED, GREEN, YELLOW, BLUE, CYAN)
     */
    private String colorAleatorio() {
        switch (numeroAleatorio(5)) {
            case 1: return "RED";
            case 2: return "GREEN";
            case 3: return "YELLOW";
            case 4: return "BLUE";
            case 5: return "CYAN";
            default: return "ERROR";
        }
    }

    /**
     * Obtiene la forma actual de la pieza
     * @return Matriz que representa la forma de la pieza
     */
    public String[][] getForma() {
        return forma;
    }
}