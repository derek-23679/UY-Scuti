/**
 * Objeto elemento: recopila los parámetros que forman un elemento
 * @author UY Scuti
 * @version 1.0
 */
public class Elemento {
    private String nombre;
    private String[] debilidades;
    private String[] fortalezas;

    /**
     * Constructor del objeto elemento
     * @param nombre Nombre del elemento
     * @param debilidades Lista de nombres de elementos contra los que es debil
     * @param fortalezas Lista de nombres de elementos contra los que es fuerte
     */
    public Elemento(String nombre, String[] debilidades, String[] fortalezas) {
        this.nombre = nombre;
        this.debilidades = debilidades;
        this.fortalezas = fortalezas;
    }

    /**
     * Getter
     * @return Nombre del elemento
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Getter
     * @return Lista de debilidades
     */
    public String[] getDebilidades() {
        return debilidades;
    }

    /**
     * Getter
     * @return Lista de fortalezas
     */
    public String[] getFortalezas() {
        return fortalezas;
    }
}
