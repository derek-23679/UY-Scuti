import java.util.List;

/**
 * Objeto entrador: nombre, si es jugador y sus pokemon.
 */

public class Entrenador {
    private String nombre;
    private boolean esJugador;
    private List<Pokemon> pokemones;

    public Entrenador(String nombre, boolean esJugador, List<Pokemon> pokemones) {
        this.nombre = nombre;
        this.esJugador = esJugador;
        this.pokemones = pokemones;
    }

    // Getters
    public String getNombre() { 
        return nombre; 
    }

    public boolean isJugador() { 
        return esJugador; 
    }
    
    public List<Pokemon> getPokemones() { 
        return pokemones; 
    }
}