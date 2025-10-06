public class Elemento {
    private String nombre;
    private String[] debilidades;
    private String[] fortalezas;

    public Elemento(String nombre, String[] debilidades, String[] fortalezas) {
        this.nombre = nombre;
        this.debilidades = debilidades;
        this.fortalezas = fortalezas;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }
    public String[] getDebilidades() {
        return debilidades;
    }
    public String[] getFortalezas() {
        return fortalezas;
    }
}
