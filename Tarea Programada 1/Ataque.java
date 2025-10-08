/**
 * Objeto ataque: recopila los parametros que forman un ataque
 * Incluye control de PP (puntos de poder) para limitar su uso
 * @author UY Scuti
 * @version 2.1
 */
public class Ataque {
    private String nombre;
    private Elemento elemento;
    private int potencia;
    private int PPmax;
    private int PPactual;
    private int precision;

    /**
     * Constructor del objeto ataque
     * @param nombre Nombre del ataque
     * @param elemento Tipo elemental del ataque
     * @param potencia Potencia del ataque
     * @param PPmax Nnmero de usos maximos del ataque
     * @param precision Probabilidad de acertar el ataque
     */
    public Ataque(String nombre, Elemento elemento, int potencia, int PPmax, int precision) {
        this.nombre = nombre;
        this.elemento = elemento;
        this.potencia = potencia;
        this.PPmax = PPmax;
        this.PPactual = PPmax;
        this.precision = precision;
    }

    public String getNombre() { 
        return nombre; 
    }
    public Elemento getElemento() { 
        return elemento; 
    }
    public int getPotencia() { 
        return potencia; 
    }
    public int getPPMax() { 
        return PPmax; 
    }
    public int getPPactual() { 
        return PPactual; 
    }
    public int getPrecision() { 
        return precision; 
    }

    /**
     * Usa un PP del ataque si hay disponible
     * @return true si el ataque puede usarse, false si no quedan PP
     */
    public boolean usarPP() {
        if (PPactual > 0) {
            PPactual--;
            return true;
        } else {
            System.out.println(nombre + " no tiene PP restantes! :c");
            return false;
        }
    }

    /** Restaura los PP al máximo (al final del combate o gimnasio). */
    public void restaurarPP() {
        this.PPactual = PPmax;
    }
}
