/*
* Reglas:
* 
* - mínimo 4 formas del tetris clásico
* - cada pieza tiene diferentes colores
* - los colores son aleatorios
* - el puntaje recibido al romper una fila se determina en base a los colores y su frecuencia en el árbol autobalanceado
* - la pieza puede rotar: A (contra reloj), D (sentido reloj)
* - otros controles: S (bajar la pieza unas cuantas casillas), ENTER (colocar la pieza)
* - la pieza no cae automáticamente
*
*/

public class Pieza {
    private String[][] forma;

    public Pieza() {
        definirForma();
    }

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

    // Constructor que crea una Pieza a partir de una forma ya existente
    public Pieza(String[][] forma) {
        this.forma = forma;
    }

    // Devuelve una nueva matriz con la rotación horaria de la forma actual
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

    private int numeroAleatorio(int limite) {
        return (int) (Math.random() * limite) + 1;
    }

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

    public String[][] getForma() {
        return forma;
    }
}
