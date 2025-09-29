/**
 * Objeto entrador: nombre, si es jugador y sus pokemon.
 */

public class Entrenador {
    private String nombre;
    private boolean esJugador;
    private Pokemon[] pokemones;

    public Entrenador(String nombre, boolean esJugador, Pokemon[] pokemones) {
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
    
    public Pokemon[] getPokemones() { 
        return pokemones; 
    }
}