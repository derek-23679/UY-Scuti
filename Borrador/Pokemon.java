public class Pokemon {
    private String nombre;
    private int nivel;
    private Stats stats;
    private Elemento[] elementos;
    private Ataque[] ataques;
    private boolean debilitado;

    public Pokemon() {
        nombre = null;
        nivel = 0;
        stats = new Stats();
        elementos = new Elemento[2];
        ataques = new Ataque[4];
        debilitado = false;
    }
}
