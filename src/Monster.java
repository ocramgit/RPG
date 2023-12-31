public class Monster {

    private String name;
    private int hp;
    int damageMultiplier = 1;

    public Monster(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public int getDamageMultiplier() {
        return damageMultiplier;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void autoAttack(Player player) {
        if(hp > 0) {
            if (player.getHp() > 9) {
                int rd = randomNumber();
                if(player.getArmour() > 1) {
                    player.setArmour(player.getArmour() - rd * damageMultiplier);
                    System.out.println("Sua vida: " + player.getHp());
                    System.out.println("Sua armadura: " + player.getArmour()+"%");
                    System.out.println("Você sofreu um golpe de " + rd * player.getDamageMultiplier() + " na armadura!");
                } else {
                    player.setHp(player.getHp() - rd * damageMultiplier);
                    System.out.println("Sua vida: " + player.getHp());
                    System.out.println("Você sofreu um golpe de " + rd * player.getDamageMultiplier() + " de vida!");
                    System.out.println("======================");
                }
            } else {
                player.setHp(player.getHp()-9);
                System.out.println("Você sofreu um golpe de " + 9 + " de vida!");
                System.out.println("Você morreu. Game over.");
                System.out.println("======================");
            }
        }
    }
    public int randomNumber() {
       return (int) (Math.random() * 9);
    }
}
