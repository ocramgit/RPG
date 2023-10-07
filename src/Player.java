import java.util.ArrayList;

public class Player {

    String name;
    boolean haveSword = false;
    int hp = 100;
    float xp;
    double xpMultiplier = 0;
    double coins;

    int random;

    public Player(String name) {
        this.name = name;
    }

    public void attack(Monster monster) {
        System.out.println("Você atacou a " + monster.getName());
        if(monster.hp <= 0) {
            System.out.println("======================");
            System.out.println("Este monstro já está morto.");
            System.out.println("======================");
        } else {
            random();
            if(monster.hp <= 30) {
                System.out.println("======================");
                if(haveSword == true) {
                    System.out.println("Você usou a sua espada de esmeralda.");
                    System.out.println("Tirou: " + monster.hp*2.30);
                    monster.setHp((int) (monster.hp-monster.hp*2.30));
                } else {
                    System.out.println("Tirou: " + monster.hp);
                    monster.setHp(monster.hp-monster.hp);
                }
                System.out.println("Você matou o " + monster.getName());
                if(xpMultiplier > 2) {
                    xp += (float) (5 + xpMultiplier);
                    System.out.println("Ganhou: " + (5 * xpMultiplier) + " de xp.");
                    System.out.println("BUFF de XP: ATIVADO");
                } else {
                    System.out.println("Ganhou: " + 5 + " de xp.");
                    System.out.println("BUFF de XP: DESATIVADO");
                }
                System.out.println("======================");
            } else {
                System.out.println("======================");
                if(haveSword == true) {
                    System.out.println("Você usou a sua espada de esmeralda.");
                    System.out.println("Tirou: " + random*2.30);
                    monster.setHp((int) (monster.hp-random*2.30));
                } else {
                    System.out.println("Tirou: " + random);
                    monster.setHp(monster.hp-random);
                }
                xp += 5;
                if(xpMultiplier > 2) {
                    xp += (float) (5 + xpMultiplier);
                    System.out.println("Ganhou: " + 5*xpMultiplier + " de xp.");
                    System.out.println("BUFF de XP: ATIVADO");
                } else {
                    System.out.println("Ganhou: " + 5 + " de xp.");
                    System.out.println("BUFF de XP: DESATIVADO");
                }
                System.out.println("Vida do " + monster.getName() + ": " + monster.hp);
                System.out.println("======================");
            }
        }
    }

    public float getXp() {
        return xp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void random() {
        double randomNumber = Math.random() * 40;
        random = (int) randomNumber;
    }
}
