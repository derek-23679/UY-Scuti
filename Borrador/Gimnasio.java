public class Gimnasio {
    private String nombre;
    private Entrenador[] entrenadores;
    private Entrenador lider;

    public Gimnasio() {
        nombre = null;
        entrenadores = new Entrenador[1];
        lider = entrenadores[entrenadores.length - 1];
    }
}