/**
 * Calculador de puntaje usando el árbol de frecuencias
 */
public class CalculadorPuntaje {
    private Arbol arbolFrecuencias;
    
    public CalculadorPuntaje() {
        this.arbolFrecuencias = new Arbol();
    }
    
    public void actualizarFrecuencias(String[][] tablero) {
        arbolFrecuencias.limpiar();
        
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[i][j] != null) {
                    arbolFrecuencias.insertar(tablero[i][j]);
                }
            }
        }
    }
    
    public int calcularPuntajePorColor(String color) {
        int puntajeBase = switch (color) {
            case "RED" -> 100;
            case "BLUE" -> 80;
            case "YELLOW" -> 70;
            case "GREEN" -> 60;
            case "CYAN" -> 50;
            default -> 40;
        };
        
        int frecuencia = arbolFrecuencias.obtenerFrecuencia(color);
        
        if (frecuencia == 0) {
            return puntajeBase * 2;
        } else if (frecuencia <= 5) {
            return (int)(puntajeBase * 1.5);
        } else if (frecuencia <= 10) {
            return puntajeBase;
        } else if (frecuencia <= 20) {
            return (int)(puntajeBase * 0.75);
        } else {
            return puntajeBase / 2;
        }
    }
}