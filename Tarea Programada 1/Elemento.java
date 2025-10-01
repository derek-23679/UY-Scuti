import java.util.List;

/**
 * Representa un tipo elemental (Fuego, Agua, Planta, etc)
 * Cada elemento tiene fortalezas y debilidades contra otros (como en pokemon, pues de eso va el codigo xd)
 */
public class Elemento {
    private String nombre;
    private List<String> fortalezas;
    private List<String> debilidades;

    public Elemento(String nombre, List<String> fortalezas, List<String> debilidades) {
        this.nombre = nombre;
        this.fortalezas = fortalezas;
        this.debilidades = debilidades;
    }

    public String getNombre() { 
        return nombre; 
    }
    
    public List<String> getFortalezas() { 
        return fortalezas; 
    }
    
    public List<String> getDebilidades() { 
        return debilidades; 
    }
}