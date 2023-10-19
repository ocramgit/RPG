public class Player {

    private String name;
    private GameCore gameCore;
    boolean haveSword = false;
    private int hp = 100;
    private float xp;
    private double xpMultiplier = 0;
    private double coins;
    private int magicPowder = 0;
    double damageMultiplier = 2.30;
    private int armour = 0;

    int random;

    public Player(String name, GameCore gameCore) {
        this.name = name;
        this.gameCore = gameCore;
    }

    public void setDamageMultiplier(double damageMultiplier) {
        this.damageMultiplier = damageMultiplier;
    }

    public void setXpMultiplier(double xpMultiplier) {
        this.xpMultiplier = xpMultiplier;
    }

    public void setMagicPowder(int magicPowder) {
        this.magicPowder = magicPowder;
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

    public void setXp(float xp) {
        this.xp = xp;
    }

    public void setCoins(double coins) {
        this.coins = coins;
    }

    public void setArmour(int armour) {
        this.armour = armour;
    }

    public void random() {
        double randomNumber = Math.random() * 40;
        random = (int) randomNumber;
    }
}
