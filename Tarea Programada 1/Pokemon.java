import java.util.List;

/**
 * Esta clase representa un pokemon con nombre, nivel, stats, elementos y ataques
 */
public class Pokemon {
    // inicializacion de variables
    private String nombre;
    private int nivel;
    private Stats stats;
    private List<Elemento> elementos;
    private List<Ataque> ataques;
    private boolean vivo;

    public Pokemon(String nombre, int nivel, Stats stats, List<Elemento> elementos, List<Ataque> ataques) {
        this.nombre = nombre;
        this.nivel = Math.max(1, nivel);
        this.stats = stats;
        this.elementos = elementos;
        this.ataques = ataques;
        this.vivo = true;
    }

    //Getters
    public String getNombre() { 
        return nombre; 
    }
    public int getNivel() { 
        return nivel; 
    }
    public Stats getStats() { 
        return stats; 
    }
    public List<Elemento> getElementos() { 
        return elementos; 
    }
    public List<Ataque> getAtaques() { 
        return ataques; 
    }
    public boolean isVivo() { 
        return vivo; 
    }

    /**
     * Marca al pokemon como debilitado
     */
    public void debilitar() {
        this.vivo = false;
    }
}