import java.util.Scanner;

public class Shop {

    Scanner sc = new Scanner(System.in);

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
        if(player.xp >= price) {
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
        if(!player.haveSword) {
            if (player.coins >= price) {
                System.out.println("Você comprou com sucesso a espada!");
                player.coins -= price;
                player.haveSword = true;
            } else {
                System.out.println("Você não tem moedas suficientes.");
            }
        } else {
            System.out.println("Você já tem uma espada.");
        }
    }

    public void sellSword(Player player) {
        if(player.haveSword == true) {
            player.haveSword = false;
            player.coins += 60;
            System.out.println("Você vendeu a sua espada por 60 moedas.");
        }
    }

    public void buyMagicPowder(Player player, int price) {
        System.out.print("Digite quantos deseja comprar: ");
        int quantity = sc.nextInt();
        if(player.coins >= price*quantity) {
            player.magicPowder += quantity;
            player.coins -= price*quantity;
            System.out.println("Comprou "+ quantity+ " de pó mágico por "+price*quantity+ " moedas.");
        } else {
            System.out.println("Sem moedas suficientes.");
        }
    }

    public void enchantSword(Player player) {

        if(player.haveSword) {
            if(player.magicPowder >= 15) {
                player.damageMultiplier *= 1.20;
                player.magicPowder -= 15;
                System.out.printf("Você encantou a sua espada! Você agora tem um multiplicador de %.2f", player.damageMultiplier);
            } else {
                System.out.println("Você não tem pó suficiente!");
            }
        } else {
            System.out.println("Você não tem uma espada!");
        }
    }

    public void buyArmour(Player player, int price) {
            if (player.xp >= 200) {
                if (player.armour < 100) {
                player.armour = 100;
                System.out.println("Você comprou uma armadura.");
            } else {
                    System.out.println("A sua armadura já está completa.");
                }
        } else {
                System.out.println("Você não tem dinheiro suficiente!");
            }
    }

 }
