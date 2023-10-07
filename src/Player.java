import java.util.ArrayList;

public class Player {

    String name;
    GameCore gameCore;
    boolean haveSword = false;
    int hp = 100;
    float xp;
    double xpMultiplier = 0;
    double coins;

    int random;

    public Player(String name, GameCore gameCore) {
        this.name = name;
        this.gameCore = gameCore;
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

    public void setCoins(double coins) {
        this.coins = coins;
    }

    public void setXp(float xp) {
        this.xp = xp;
    }

    public void random() {
        double randomNumber = Math.random() * 40;
        random = (int) randomNumber;
    }
}
