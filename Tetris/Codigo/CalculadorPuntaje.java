/**
 * Calculador de puntaje usando el árbol de frecuencias
 * 
 * - Cada color tiene un valor base fijo (RED=100, BLUE=80, etc.)
 * - El árbol cuenta cuántas veces aparece cada color en el tablero
 * - Colores más raros (poca frecuencia) dan multiplicadores altos
 * - Colores comunes (mucha frecuencia) dan multiplicadores bajos
 * - Esto premia la variedad de colores en el tablero
 */
public class CalculadorPuntaje {
    private Arbol arbolFrecuencias;
    
    public CalculadorPuntaje() {
        this.arbolFrecuencias = new Arbol();
    }
    
    /**
     * Actualiza el árbol con los colores actuales del tablero
     * Se llama cada vez que se coloca una nueva pieza
     */
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
    
    /**
     * Calcula el puntaje para un color basado en su rareza
     * - Frecuencia 0: x2 (super raro)
     * - Frecuencia 1-5: x1.5 (raro) 
     * - Frecuencia 6-10: x1 (normal)
     * - Frecuencia 11-20: x0.75 (común)
     * - Frecuencia 21+: x0.5 (muy común)
     */
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