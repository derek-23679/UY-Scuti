/**
 * Objeto ataque: recopila los parámetros que forman un ataque.
 * @author UY Scuti
 * @version 1.0
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
     * @param PPmax El número de usos máximos en un ciclo del ataque
     * @param precision La probabilidad de acertar el ataque
     */
    public Ataque(String nombre, Elemento elemento, int potencia, int PPmax, int precision) {
        this.nombre = nombre;
        this.elemento = elemento;
        this.potencia = potencia;
        this.PPmax = PPmax;
        this.PPactual = PPmax;
        this.precision = precision;
    }

    /**
     * Getter
     * @return Nombre del ataque
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Getter
     * @return Tipo elemental del ataque
     */
    public Elemento getElemento() {
        return elemento;
    }

    /**
     * Getter
     * @return Potencia del ataque
     */
    public int getPotencia() {
        return potencia;
    }

    /**
     * Getter
     * @return Usos máximos del ataque
     */
    public int getPPMax() {
        return PPmax;
    }

    /**
     * Getter
     * @return Usos restantes del ataque
     */
    public int getPPactual() {
        return PPactual;
    }

    /**
     * Getter
     * @return La probabilidad de acertar el ataque
     */
    public int getPrecision() {
        return precision;
    }
}
