import java.util.List;

/**
 * Objeto gimnasio: nombre y lista de entrenadores.
 */

public class Gimnasio {
    private String nombre;
    private List<Entrenador> entrenadores;

    public Gimnasio(String nombre, List<Entrenador> entrenadores) {
        this.nombre = nombre;
        this.entrenadores = entrenadores;
    }

    //Getters
    public String getNombre() { 
        return nombre; 
    }

    public List<Entrenador> getEntrenadores() { 
        return entrenadores; 
    }
}