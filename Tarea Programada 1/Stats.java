/**
 * Objeto stats: recopila los parámetros que forman los stats de un pokemon
 * @author UY Scuti
 * @version 1.1
 */
public class Stats {
    private int hp;
    private int atk;
    private int def;
    private int spd;

    /**
     * Constructor del objeto stats
     * @param hp Vida del pokemon
     * @param atk Estadstica de ataque del pokemon
     * @param def Defensa del pokemon
     * @param spd Velocidad del pokemon
     */
    public Stats(int hp, int atk, int def, int spd) {
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.spd = spd;
    }

    // --- Getters ---
    public int getHp() { 
        return hp; 
    }
    public int getAtk() { 
        return atk; 
    }
    public int getDef() { 
        return def; 
    }
    public int getSpd() { 
        return spd; 
    }

    // --- Setters ---
    public void setHp(int hp) { 
        this.hp = hp; 
    }
    public void setAtk(int atk) { 
        this.atk = atk; 
    }
    public void setDef(int def) { 
        this.def = def; 
    }
    public void setSpd(int spd) { 
        this.spd = spd; 
    }
}
