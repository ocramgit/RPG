import java.util.Scanner;

public class Shop {

    Scanner sc = new Scanner(System.in);

    private final Player player;
    private final GameCore gameCore;

    public Shop(Player player, GameCore gameCore) {
        this.player = player;
        this.gameCore = gameCore;
    }

    public void getShopMessage() {
        System.out.println("Bem-vindo à Loja!" + " (Seu XP: " + gameCore.getPlayer().getXp()+")" + " - (Suas moedas: " + gameCore.getPlayer().getCoins() + ")" + " - (Seu pó mágico: "+ player.getMagicPowder()+")");
        System.out.println("1 - Comprar XP Multiplier (100 XP)");
        System.out.println("2 - Comprar VIDA (50 XP)");
        System.out.println("3 - Comprar Armadura (150 XP)");
        System.out.println("4 - Converter XP em Moedas (2 XP cada)");
        System.out.println("5 - Comprar Espada de Esmeralda (75 Moedas)");
        System.out.println("6 - Vender Espada de Esmeralda (60 Moedas)");
        System.out.println("7 - Comprar pó mágico (17 Moedas cada)");
        System.out.println("8 - Encantar espada (15 de pó mágico)");
        System.out.println("9 - Sair da Loja");
        System.out.print("Resposta: ");
    }
    public void buyLife(Player player, int price) {
        if(player.getHp() > 0 && player.getXp() >= 50) {
            System.out.println("Você foi curado com sucesso!");
            player.setXp(player.getXp() - price);
            player.setHp(100);
        } else {
            System.out.println("Você não tem XP suficiente!");
        }
    }

    public void buyXPMultiplier(Player player, int price) {
        if(player.getXp() >= price) {
            System.out.println("Você comprou XP Multiplier com sucesso!");
            if (player.getXpMultiplier() != 2.30) {
                player.setXpMultiplier(2.30);
                player.setXp(player.getXp() - price);
            } else if (player.getXpMultiplier() == 2.30) {
                System.out.println("Você não tem XP suficiente ou já tem esse produto.");
            }
        } else {
            System.out.println("Você não tem XP suficiente!");
        }
    }

    public void buyCoins(Player player) {
        System.out.println("Quantas moedas deseja comprar? ");
        int quantity = sc.nextInt();
        if(player.getXp() > quantity*2) {
            player.setCoins(player.getCoins() + quantity);
            player.setXp(player.getXp() - (quantity*2));
            System.out.println("Converteu com sucesso. Foi-lhe cobrado " + quantity * 2 + " por " + quantity + " moedas.");
        } else {
            System.out.println("Você não tem XP suficiente.");
        }
    }

    public void buySword(Player player, int price) {
        if(!player.haveSword) {
            if (player.getCoins() >= price) {
                System.out.println("Você comprou com sucesso a espada!");
                player.setCoins(player.getCoins() - price);
                player.haveSword = true;
            } else {
                System.out.println("Você não tem moedas suficientes.");
            }
        } else {
            System.out.println("Você já tem uma espada.");
        }
    }

    public void sellSword(Player player) {
        if(player.haveSword) {
            player.haveSword = false;
            player.setCoins(player.getCoins() + 60);
            System.out.println("Você vendeu a sua espada por 60 moedas.");
        }
    }

    public void buyMagicPowder(Player player, int price) {
        System.out.print("Digite quantos deseja comprar: ");
        int quantity = sc.nextInt();
        if(player.getCoins() >= price*quantity) {
            player.setMagicPowder(player.getMagicPowder() + quantity);
            player.setCoins(player.getCoins() - (price*quantity));
            System.out.println("Comprou "+ quantity+ " de pó mágico por "+price*quantity+ " moedas.");
        } else {
            System.out.println("Sem moedas suficientes.");
        }
    }

    public void enchantSword(Player player) {

        if(player.haveSword) {
            if(player.getMagicPowder() >= 15) {
                player.damageMultiplier *= 1.20;
                player.setMagicPowder(player.getMagicPowder() - 15);
                System.out.printf("Você encantou a sua espada! Você agora tem um multiplicador de %.2f", player.damageMultiplier);
            } else {
                System.out.println("Você não tem pó suficiente!");
            }
        } else {
            System.out.println("Você não tem uma espada!");
        }
    }

    public void buyArmour(Player player, int price) {
            if (player.getXp() >= 200) {
                if (player.getArmour() < 100) {
                player.setArmour(100);
                System.out.println("Você comprou ou reparou a armadura.");
            } else {
                    System.out.println("A sua armadura já está completa.");
                }
        } else {
                System.out.println("Você não tem dinheiro suficiente!");
            }
    }

 }
