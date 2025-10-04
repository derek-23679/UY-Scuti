public class Gimnasio {
    private String nombre;
    private Entrenador[] entrenadores;
    private String dificultad;

    public Gimnasio(String nombre, String dificultad, Entrenador[] entrenadores) {
        this.nombre = nombre;
        this.entrenadores = entrenadores;
        this.dificultad = dificultad;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }
    public String getDificultad() {
        return dificultad;
    }
    public Entrenador[] getEntrenadores() {
        return entrenadores;
    }
}