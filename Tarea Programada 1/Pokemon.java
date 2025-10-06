/**
 * Objeto pokemon: recopila los parámetros que forman un pokemon.
 * @author UY Scuti
 * @version 1.0
 */
public class Pokemon {
    private String nombre;
    private int nivel;
    private Stats stats;
    private Elemento[] elementos;
    private Ataque[] ataques;
    private boolean debilitado;
    private Ataque ataqueActivo;

    /**
     * Constructor del objeto pokemon
     * @param nombre Nombre del pokemon
     * @param nivel Nivel del pokemon
     * @param stats Stats del pokemon
     * @param elementos Elementos del pokemon
     * @param ataques Ataques del pokemon
     */
    public Pokemon(String nombre, int nivel, Stats stats, Elemento[] elementos, Ataque[] ataques) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.stats = stats;
        this.elementos = elementos;
        this.ataques = ataques;
        this.debilitado = false;
    }

    /**
     * Getter
     * @return Nombre del pokemon
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Getter
     * @return Stats del pokemon
     */
    public Stats getStats() {
        return stats;
    }

    /**
     * Getter
     * @return Nivel del pokemon
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * Getter
     * @return Elementos del pokemon
     */
    public Elemento[] getElementos() {
        return elementos;
    }

    /**
     * Getter
     * @return Ataques del pokemon
     */
    public Ataque[] getAtaques() {
        return ataques;
    }

    /**
     * Getter
     * @return Ataque en uso del pokemon
     */
    public Ataque getAtaqueActivo() {
        return ataqueActivo;
    }

    /**
     * Setter
     * @param ataqueActivo Ataque en uso del pokemon
     */
    public void setAtaqueActivo(Ataque ataqueActivo) {
        this.ataqueActivo = ataqueActivo;
    }

    /**
     * Getter
     * @return Si, el pokemon, está debilitado
     */
    public boolean isDebilitado() {
        return debilitado;
    }
}
