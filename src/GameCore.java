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
        player = new Player("Marco", this);
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
            System.out.println("4 - Inventário");
            System.out.println("5 - Consultar XP");
            System.out.println("6 - Consultar Moedas");
            System.out.println("7 - Consultar vida");
            System.out.println("8 - Loja");
            System.out.println("9 - Sair do Jogo");
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
                        player.inventory.check();
                        break;
                    case 5:
                        System.out.println("O teu xp é: " + player.getXp());
                        break;
                    case 6:
                        System.out.println("Tens " + player.coins + " moedas.");
                        break;
                    case 7:
                        System.out.println("Sua vida: " + player.hp);
                        break;
                    case 8:
                        System.out.println("Bem-vindo à Loja!" + " (Seu XP: " + player.getXp()+")" + " - (Suas moedas: " + player.coins + ")");
                        System.out.println("1 - Comprar XP Multiplier (100 XP)");
                        System.out.println("2 - Comprar VIDA (50 XP)");
                        System.out.println("3 - Converter XP em Moedas (2 XP cada)");
                        System.out.println("4 - Comprar Espada de Esmeralda (75 Moedas)");
                        System.out.println("5 - Vender Espada de Esmeralda (60 Moedas)");
                        System.out.println("6 - Sair da Loja");
                        System.out.print("Resposta: ");
                        menuShop();
                    case 9:
                        playerIsDead = true;
                        break;
                    case 0:
                        player.xp = 1000;
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
                break;
            case 2:
                shop.buyLife(player, 50);
                start();
                break;
            case 3:
                shop.buyCoins(player);
                start();
                break;
            case 4:
                shop.buySword(player, 75);
                start();
                break;
            case 5:
                shop.sellSword(player);
                start();
                break;
            case 6:
                start();
                break;
            default:
                System.out.println("Número inválido.");
                start();
                break;
        }
    }

    public void checkIfPlayerIsDead(Player player) {
        if (player.hp <= 0) {
            playerIsDead = true;
        }
    }

    public void checkAttack(Monster monster) {
        System.out.println("Você atacou a " + monster.getName());
        if(monster.hp <= 0) {
            System.out.println("======================");
            System.out.println("Este monstro já está morto.");
            System.out.println("======================");
        } else {
            player.random();
            if(monster.hp <= 80) {
                System.out.println("======================");
                if(player.haveSword == true) {
                    System.out.println("Você usou a sua espada de esmeralda.");
                    System.out.println("Tirou: " + monster.hp*2.30);
                    monster.setHp((int) (monster.hp-monster.hp*2.30));
                } else {
                    System.out.println("Tirou: " + monster.hp);
                }
                monster.setHp(monster.hp-monster.hp);
                System.out.println("Você matou o " + monster.name);
                if(monster.name == "Zombie") {
                    player.xp += 250;
                    player.coins += 125;
                    System.out.println("Você recebeu 250 de XP e 125 moedas por derrotar o Zombie.");
                } else if(monster.name == "Slime") {
                    player.xp += 500;
                    player.coins += 250;
                    System.out.println("Você recebeu 500 de XP e 250 moedas por derrotar a Slime.");
                } else if(monster.name == "Wither") {
                    player.xp += 700;
                    player.coins += 350;
                    System.out.println("Você recebeu 700 de XP e 350 moedas por derrotar o Wither.");
                }
                if(player.xpMultiplier > 2) {
                    player.xp += (float) (5 + player.xpMultiplier);
                    System.out.println("Ganhou: " + (5 * player.xpMultiplier) + " de xp.");
                    System.out.println("BUFF de XP: ATIVADO");
                } else {
                    System.out.println("Ganhou: " + 5 + " de xp.");
                    System.out.println("BUFF de XP: DESATIVADO");
                }
                System.out.println("======================");
            } else {
                player.xp += 5;
                System.out.println("======================");
                if(player.haveSword == true) {
                    System.out.println("Você usou a sua espada de esmeralda.");
                    System.out.println("Tirou: " + player.random*2.30);
                    monster.setHp((int) (monster.hp-player.random*2.30));
                } else {
                    System.out.println("Tirou: " + player.random);
                    monster.setHp(monster.hp-player.random);
                }
                if(player.xpMultiplier > 2) {
                    player.xp += (float) (5 + player.xpMultiplier);
                    System.out.println("Ganhou: " + 5*player.xpMultiplier + " de xp.");
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
}
