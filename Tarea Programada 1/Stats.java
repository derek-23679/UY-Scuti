/**
 * Objeto stats: recopila los parámetros que forman los stats de un pokemon.
 */
public class Stats {
    private int hp;
    private int atk;
    private int def;
    private int spd;

    /**
     * Constructor del objeto stats
     * @param hp Vida del pokemon
     * @param atk Estadística de ataque del pokemon
     * @param def Defensa del pokemon
     * @param spd Velocidad del pokemon
     */
    public Stats(int hp, int atk, int def, int spd) {
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.spd = spd;
    }

    /**
     * Getter
     * @return Vida del pokemon
     */
    public int getHp() {
        return hp;
    }

    /**
     * Getter
     * @return Estadística de ataque del pokemon
     */
    public int getAtk() {
        return atk;
    }

    /**
     * Getter
     * @return Defensa del pokemon
     */
    public int getDef() {
        return def;
    }

    /**
     * Getter
     * @return Velocidad del pokemon
     */
    public int getSpd() {
        return spd;
    }
}
