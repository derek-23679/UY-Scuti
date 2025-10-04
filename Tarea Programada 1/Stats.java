public class Stats {
    private int hp;
    private int atk;
    private int def;
    private int spd;

    public Stats(int hp, int atk, int def, int spd) {
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.spd = spd;
    }

    // Getters
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
}
