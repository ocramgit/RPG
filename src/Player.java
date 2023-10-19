public class Player {

    private String name;
    private GameCore gameCore;
    boolean haveSword = false;
    int hp = 100;
    float xp;
    double xpMultiplier = 0;
    double coins;
    int magicPowder = 0;
    double damageMultiplier = 2.30;
    int armour = 0;

    int random;

    public Player(String name, GameCore gameCore) {
        this.name = name;
        this.gameCore = gameCore;
    }

    public double getCoins() {
        return coins;
    }

    public int getRandom() {
        return random;
    }

    public void attack(Monster monster) {
        gameCore.checkAttack(monster);
    }

    public float getXp() {
        return xp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public double getDamageMultiplier() {
        return damageMultiplier;
    }

    public double getXpMultiplier() {
        return xpMultiplier;
    }

    public int getArmour() {
        return armour;
    }

    public int getHp() {
        return hp;
    }

    public int getMagicPowder() {
        return magicPowder;
    }

    public void random() {
        double randomNumber = Math.random() * 40;
        random = (int) randomNumber;
    }
}
