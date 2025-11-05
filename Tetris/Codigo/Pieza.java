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
*/

public class Pieza {
    private int[][] forma;
    private String[] colores;

    public Pieza() {
        definirForma();
        asignarColores();
    }

    // Genera la forma de la pieza
    // 1: bloque
    // 0: vacío
    private void definirForma() {
        switch (numeroAleatorio(5)) { // 5 formas
            // Forma línea
            case 1:
                forma = new int[][] {
                    {1},
                    {1},
                    {1},
                    {1}
                };
                break;
            
            // Forma cuadrado
            case 2:
                forma = new int[][] {
                    {1, 1},
                    {1, 1}
                };
                break;

            // Forma L
            case 3:
                forma = new int[][] {
                    {1, 0},
                    {1, 0},
                    {1, 1}
                };
                break;

            // Forma T
            case 4:
                forma = new int[][] {
                    {0, 1, 0},
                    {1, 1, 1}
                };
                break;
            
            // Forma zigzag
            case 5:
                forma = new int[][] {
                    {1, 1, 0},
                    {0, 1, 1}
                };
                break;
        }
    }

    // Genera una lista de colores para emparejar con la forma
    private void asignarColores() {
        colores = new String[4]; // Ya que todas las piezas están compuestas de 4 bloques
        for (int i = 0; i < colores.length; i++) {
            colores[i] = colorAleatorio();
        }
    }

    // Genera un número aleatorio hasta el límite (incluyendo al límite)
    private int numeroAleatorio(int limite) {
        return (int) (Math.random() * limite) + 1;
    }

    // Genera un color aleatorio para identificar luego
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

    // Getters

    public int[][] getForma() {
        return forma;
    }
    public String[] getColores() {
        return colores;
    }
}
