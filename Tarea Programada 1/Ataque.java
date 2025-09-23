/**
 * Este es el equivalente a un ataque de un pokemon
 */
public class Ataque {
    //Inicializacion de variables
    private String nombre;
    private Elemento elemento;
    private int potencia;
    private int ppMax;
    private int ppActual;
    private int precision;

    public Ataque(String nombre, Elemento elemento, int potencia, int ppMax, int precision) {
        this.nombre = nombre;
        this.elemento = elemento;
        this.potencia = Math.max(0, potencia);
        this.ppMax = Math.max(1, ppMax);
        this.ppActual = this.ppMax;
        this.precision = Math.min(100, Math.max(1, precision));
    }
    
    // Getters
    public String getNombre() { 
        return nombre; 
    }
    public Elemento getElemento() { 
        return elemento; 
    }
    public int getPotencia() { 
        return potencia; 
    }
    public int getPpMax() { 
        return ppMax;
    }
    public int getPpActual() { 
        return ppActual; 
    }
    public int getPrecision() { 
        return precision; 
    }

    /**
     * Resta 1 PP al ataque
     */
    public void usar() {
        if (ppActual > 0) {
            ppActual--;
        }
    }

    /**
     * @return true si aun quedan PP
     */
    public boolean disponible() {
        return ppActual > 0;
    }
}
