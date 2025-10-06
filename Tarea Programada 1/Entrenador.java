public class Entrenador {
    private String nombre;
    private boolean esJugador;
    private boolean esLider;
    private Pokemon[] pokemones;
    private Pokemon pokemonActivo;

    public Entrenador(String nombre, boolean esJugador, Pokemon[] pokemones) {
        this.nombre = nombre;
        this.esJugador = esJugador;
        this.pokemones = pokemones;
        this.esLider = false;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public boolean isJugador() {
        return esJugador;
    }

    public Pokemon[] getPokemones() {
        return pokemones;
    }

    public Pokemon getPokemonActivo() {
        return pokemonActivo;
    }

    public void setPokemonActivo(Pokemon p) {
        this.pokemonActivo = p;
    }

    public void setLider() {
        if (!esJugador) {
            esLider = true;
        }
    }

    public boolean isLider() {
        return esLider;
    }
}
