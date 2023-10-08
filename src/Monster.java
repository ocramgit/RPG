public class Monster {

    String name;
    int hp;
    int damageMultiplier = 1;

    public Monster(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void autoAttack(Player player) {
        if(hp > 0) {
            if (player.hp > 9) {
                int rd = randomNumber();
                player.hp -= rd*damageMultiplier;
                System.out.println("Sua vida: " + player.hp);
                System.out.println("Você sofreu um golpe de " + rd*damageMultiplier + " de vida!");
                System.out.println("======================");
            } else {
                player.hp = player.hp - 9;
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
