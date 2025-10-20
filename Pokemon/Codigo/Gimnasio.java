/**
 * Objeto gimnasio: recopila los parámetros que forman un gimnasio
 * @author UY Scuti
 * @version 1.0
 */
public class Gimnasio {
    private String nombre;
    private Entrenador[] entrenadores;
    private String dificultad;

    /**
     * Constructor del objeto gimnasio
     * @param nombre Nombre del gimnasio
     * @param dificultad Dificultad del gimnasio
     * @param entrenadores Lista de entrenadores del gimnasio
     */
    public Gimnasio(String nombre, String dificultad, Entrenador[] entrenadores) {
        this.nombre = nombre;
        this.entrenadores = entrenadores;
        this.dificultad = dificultad;
    }

    /**
     * Getter
     * @return Nombre del gimnasio
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Getter
     * @return Dificultad del gimnasio
     */
    public String getDificultad() {
        return dificultad;
    }

    /**
     * Getter
     * @return Lista de entrenadores del gimnasio
     */
    public Entrenador[] getEntrenadores() {
        return entrenadores;
    }
}