import java.util.Scanner;

public class GameCore {

    Player player;
    Monster zombie;
    Monster slime;
    Monster wither;
    Shop shop;

    boolean playerIsDead = false;

    Scanner sc = new Scanner(System.in);


    public GameCore() {
        player = new Player("Marco");
        zombie = new Monster("Zombie", 1200);
        slime = new Monster("Slime", 2100);
        wither = new Monster("Wither", 4900);
        shop = new Shop();

    }

    public void start() {
        while(!playerIsDead) {
            System.out.println(" ");
            System.out.println("1 - Atacar Zombie [Fácil]");
            System.out.println("2 - Atacar Slime [Mediano]");
            System.out.println("3 - Atacar Wither [Dificíl]");
            System.out.println("4 - Consultar XP");
            System.out.println("5 - Consultar Moedas");
            System.out.println("6 - Consultar vida");
            System.out.println("7 - Loja");
            System.out.println("8 - Sair do Jogo");
            System.out.println(" ");
            System.out.print("Selecione o que fazer: ");


                switch (sc.nextInt()) {
                    case 1:
                        player.attack(zombie);
                        zombie.autoAttack(player);
                        break;
                    case 2:
                        player.attack(slime);
                        slime.autoAttack(player);
                        break;
                    case 3:
                        player.attack(wither);
                        wither.autoAttack(player);
                        break;
                    case 4:
                        System.out.println("O teu xp é: " + player.getXp());
                        break;
                    case 5:
                        System.out.println("Tens " + player.coins + " moedas.");
                        break;
                    case 6:
                        System.out.println("Sua vida: " + player.hp);
                        break;
                    case 7:
                        System.out.println("Bem-vindo à Loja!" + " (Seu XP: " + player.getXp()+")" + " - (Suas moedas: " + player.coins + ")");
                        System.out.println("1 - Comprar XP Multiplier (100 XP)");
                        System.out.println("2 - Comprar VIDA (50 XP)");
                        System.out.println("3 - Converter XP em Moedas (2 XP cada)");
                        System.out.println("4 - Comprar Espada de Esmeralda (75 Moedas)");
                        System.out.println("5 - Vender Espada de Esmeralda (60 Moedas)");
                        System.out.println("6 - Sair da Loja");
                        System.out.print("Resposta: ");
                        menuShop();
                    case 8:
                        playerIsDead = true;
                        break;
                    case 0:
                        player.xp = 10000;
                        player.coins = 1000;
                }

            checkIfPlayerIsDead(player);
            }
        }

    public void menuShop() {
        switch (sc.nextInt()) {
            case 1:
                shop.buyXPMultiplier(player, 100);
                start();
            case 2:
                shop.buyLife(player, 50);
                start();
            case 3:
                shop.buyCoins(player);
                start();
            case 4:
                shop.buySword(player, 75);
                start();
            case 5:
                shop.sellSword(player);
                start();
            case 6:
                start();
            default:
                System.out.println("Número inválido.");
                start();
        }
    }

    public void checkIfPlayerIsDead(Player player) {
        if (player.hp <= 0) {
            playerIsDead = true;
        }
    }
}
