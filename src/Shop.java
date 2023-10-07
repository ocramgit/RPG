import java.util.Scanner;

public class Shop {

    public void buyLife(Player player, int price) {
        if(player.hp > 0 && player.xp >= 50) {
            System.out.println("Você foi curado com sucesso!");
            player.xp -= price;
            player.setHp(100);
        } else {
            System.out.println("Você não tem XP suficiente!");
        }
    }

    public void buyXPMultiplier(Player player, int price) {
        if(player.xp >= 100) {
            System.out.println("Você comprou XP Multiplier com sucesso!");
            if (player.xpMultiplier != 2.30) {
                player.xpMultiplier = 2.30;
                player.xp -= price;
            } else if (player.xpMultiplier == 2.30) {
                System.out.println("Você não tem XP suficiente ou já tem esse produto.");
            }
        } else {
            System.out.println("Você não tem XP suficiente!");
        }
    }

    public void buyCoins(Player player) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Quantas moedas deseja comprar? ");
        int quantity = sc.nextInt();
        if(player.xp > quantity*2) {
            player.coins += quantity;
            player.xp -= quantity * 2;
            System.out.println("Converteu com sucesso. Foi-lhe cobrado " + quantity * 2 + " por " + quantity + " moedas.");
        } else {
            System.out.println("Você não tem XP suficiente.");
        }
    }

    public void buySword(Player player, int price) {
        if(player.coins >= 75) {
            System.out.println("Você comprou com sucesso a espada!");
            player.coins -= price;
            player.haveSword = true;
        } else {
            System.out.println("Você não tem moedas suficientes.");
        }
    }

    public void sellSword(Player player) {
        if(player.haveSword == true) {
            player.haveSword = false;
            player.coins += 60;
            System.out.println("Você vendeu a sua espada por 60 moedas.");
        }
    }

 }
