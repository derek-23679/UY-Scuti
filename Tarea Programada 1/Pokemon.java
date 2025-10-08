/**
 * Objeto pokemon: recopila los parámetros que forman un pokemon
 * @author UY Scuti
 * @version 1.1
 */
public class Pokemon {
    private String nombre;
    private int nivel;
    private Stats stats;
    private Elemento[] elementos;
    private Ataque[] ataques;
    private boolean debilitado;
    private Ataque ataqueActivo;

    /**
     * Constructor del objeto pokemon
     * @param nombre Nombre del pokemon
     * @param nivel Nivel del pokemon
     * @param stats Stats del pokemon
     * @param elementos Elementos del pokemon
     * @param ataques Ataques del pokemon
     */
    public Pokemon(String nombre, int nivel, Stats stats, Elemento[] elementos, Ataque[] ataques) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.stats = stats;
        this.elementos = elementos;
        this.ataques = ataques;
        this.debilitado = false;
    }

    // --- Getters ---
    public String getNombre() { 
        return nombre; 
    }
    public Stats getStats() { 
        return stats; 
    }
    public int getNivel() { 
        return nivel; 
    }
    public Elemento[] getElementos() { 
        return elementos; 
    }
    public Ataque[] getAtaques() { 
        return ataques; 
    }
    public Ataque getAtaqueActivo() { 
        return ataqueActivo; 
    }
    public boolean isDebilitado() { 
        return debilitado; 
    }

    // --- Setters ---
    public void setAtaqueActivo(Ataque ataqueActivo) { 
        this.ataqueActivo = ataqueActivo; 
    }
    public void setDebilitado(boolean debilitado) { 
        this.debilitado = debilitado; 
    }
}
