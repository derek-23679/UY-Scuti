/**
 * Objeto entrenador: recopila los parámetros que forman un entrenador
 * 
 */
public class Entrenador {
    private String nombre;
    private boolean esJugador;
    private boolean esLider;
    private Pokemon[] pokemones;
    private Pokemon pokemonActivo;

    /**
     * Constructor del objeto entrenador
     * @param nombre Nombre del entrenador
     * @param esJugador Si, el entrenador, es jugador
     * @param pokemones Lista de pokemones del entrenador
     */
    public Entrenador(String nombre, boolean esJugador, Pokemon[] pokemones) {
        this.nombre = nombre;
        this.esJugador = esJugador;
        this.pokemones = pokemones;
        this.esLider = false;
    }

    /**
     * Getter
     * @return Nombre del entrenador
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Getter
     * @return Si, el entrenador, es jugador
     */
    public boolean isJugador() {
        return esJugador;
    }

    /**
     * Getter
     * @return Lista de pokemones del entrenador
     */
    public Pokemon[] getPokemones() {
        return pokemones;
    }

    /**
     * Getter
     * @return El pokemon en combate del entrenador
     */
    public Pokemon getPokemonActivo() {
        return pokemonActivo;
    }

    /**
     * Setter
     * @param p El pokemon en combate del entrenador
     */
    public void setPokemonActivo(Pokemon p) {
        this.pokemonActivo = p;
    }

    /**
     * Setter
     */
    public void setLider() {
        if (!esJugador) {
            esLider = true;
        }
    }

    /**
     * Getter
     * @return Si, el entrenador, es líder del gimnasio.
     */
    public boolean isLider() {
        return esLider;
    }
}
