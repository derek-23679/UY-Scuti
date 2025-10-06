public class Pokemon {
    private String nombre;
    private int nivel;
    private Stats stats;
    private Elemento[] elementos;
    private Ataque[] ataques;
    private boolean debilitado;
    private Ataque ataqueActivo;


    public Pokemon(String nombre, int nivel, Stats stats, Elemento[] elementos, Ataque[] ataques) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.stats = stats;
        this.elementos = elementos;
        this.ataques = ataques;
        debilitado = false;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public Stats getStats() {
        return stats;
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
    public void setAtaqueActivo(Ataque ataqueActivo) {
        this.ataqueActivo = ataqueActivo;
    }
}
