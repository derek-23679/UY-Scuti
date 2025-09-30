/**
 * Equivale a las estadisticas de un pokemon
 */
public class Stats {
    //inicializacion de variables
    private int hp;
    private int atk;
    private int def;
    private int spd;

    public Stats(int hp, int atk, int def, int spd) {
        this.hp = Math.max(1, hp);
        this.atk = Math.max(1, atk);
        this.def = Math.max(1, def);
        this.spd = Math.max(1, spd);
    }
    
    //Getter
    public int getHp() { 
        return hp; 
    }
    
    //Setter
    public void setHp(int hp) { this.hp = Math.max(0, hp); 
    }

    //Getters
    public int getAtk() { 
        return atk; 
    }
    public int getDef() { 
        return def; 
    }
    public int getSpd() { 
        return spd; 
    }
} // PRUEBA