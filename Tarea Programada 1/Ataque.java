public class Ataque {
    private String nombre;
    private Elemento elemento;
    private int potencia;
    private int PPmax;
    private int PPactual;
    private int precision;

    public Ataque(String nombre, Elemento elemento, int potencia, int PPmax, int precision) {
        this.nombre = nombre;
        this.elemento = elemento;
        this.potencia = potencia;
        this.PPmax = PPmax;
        this.PPactual = PPmax;
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
        return PPmax;
    }
    public int getPPactual() {
        return PPactual;
    }
    public int getPrecision() {
        return precision;
    }
}
