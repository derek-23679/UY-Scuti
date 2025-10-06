public class Ataque {
    private String nombre;
    private Elemento elemento;
    private int potencia;
    private int PPMax;
    private int PPactual;
    private int precision;

    public Ataque(String nombre, Elemento elemento, int potencia, int PPMax, int precision) {
        this.nombre = nombre;
        this.elemento = elemento;
        this.potencia = potencia;
        this.PPMax = PPMax;
        this.PPactual = PPMax;
        this.precision = precision;
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
    public int getPPMax() {
    return PPMax;
    }
    public int getPrecision() {
    return precision;
    }
}
