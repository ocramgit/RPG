import java.util.Scanner;

public class GameCore {

    private Player player;
    private Monster zombie, slime, wither;
    private Shop shop;
    private Inventory inventory;
    boolean dungeonConcluded = false;
    boolean playerIsDead = false;
    private Dungeon dungeon;
    private Dice dice;
    private Profile profile;

    Scanner sc = new Scanner(System.in);

    public GameCore(String playerName) {
        player = new Player(playerName, this);
        zombie = new Monster("Zombie", 1200);
        slime = new Monster("Slime", 2100);
        wither = new Monster("Wither", 4900);
        dice = new Dice(player);
        shop = new Shop(getPlayer(), this);
        inventory = new Inventory(player);
        dungeon = new Dungeon(player, this, shop);
        profile = new Profile(player, this);
    }

    public void start() {
        while(!playerIsDead) {
            System.out.println(" ");
            System.out.println("1 - Atacar Zombie [Fácil]");
            System.out.println("2 - Atacar Slime [Mediano]");
            System.out.println("3 - Atacar Wither [Dificíl]");
            System.out.println("4 - Modo Dungeon [Hardcore]");
            System.out.println("5 - Apostar (Par ou Ímpar)");
            System.out.println("6 - Status");
            System.out.println("7 - Inventário");
            System.out.println("8 - Loja");
            System.out.println("9 - Sair do Jogo");
            System.out.println(" ");
            System.out.print("Selecione o que fazer: ");

            startMenu();

            checkIfPlayerIsDead(player);
            }
        }

        public void startMenu() {
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
                    if(!dungeonConcluded) {
                        dungeon.flyingisDead = false;
                        dungeon.endermanisDead = false;
                        dungeon.babyDragonisDead = false;
                        dungeon.giantisDead = false;
                        dungeon.dragonisDead = false;
                        dungeon.startDungeon();
                        break;
                    } else {
                        System.out.println("Dungeon já concluída.");
                        break;
                    }
                case 5:
                    dice.playDice(player);
                    break;
                case 6:
                    profile.getProfile(player);
                    break;
                case 7:
                    inventory.check(player);
                    break;
                case 8:
                    shop.getShopMessage();
                    menuShop();
                case 9:
                    System.out.println("Você decidiu sair do jogo. O seu progresso não ficará guardado.");
                    playerIsDead = true;
                    dungeon.flyingisDead = true;
                    break;
                case 111:
                    player.setXp(player.getXp() + 1000);
                    player.setCoins(getPlayer().getCoins() - 1000);
                    player.setMagicPowder(getPlayer().getMagicPowder() + 1000);
                    System.out.println("Cheat usado!");
                    break;
                default:
                    System.out.println("Número inválido.");
                    start();
                    break;
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
                shop.buyArmour(player, 200);
                start();
                break;
            case 4:
                shop.buyCoins(player);
                start();
                break;
            case 5:
                shop.buySword(player, 75);
                start();
                break;
            case 6:
                shop.sellSword(player);
                start();
                break;
            case 7:
                shop.buyMagicPowder(player, 17);
                start();
                break;
            case 8:
                shop.enchantSword(player);
                start();
                break;
            case 9:
                start();
                break;
            default:
                System.out.println("Número inválido.");
                start();
                break;
        }
    }

    public Monster getZombie() {
        return zombie;
    }

    public Monster getSlime() {
        return slime;
    }

    public Monster getWither() {
        return wither;
    }

    public Player getPlayer() {
        return player;
    }

    public void checkIfPlayerIsDead(Player player) {
        if (player.getHp() <= 0) {
            playerIsDead = true;
        }
    }

    public void checkAttack(Monster monster) {
        System.out.println("Você atacou a " + monster.getName());
        if(monster.getHp() <= 0) {
            System.out.println("======================");
            System.out.println("Este monstro já está morto.");
            System.out.println("======================");
        } else {
            player.random();
            if(monster.getHp() <= 80) {
                System.out.println("======================");
                if(getPlayer().haveSword) {
                    System.out.println("Você usou a sua espada de esmeralda.");
                    System.out.printf("Tirou: %.2f", monster.getHp()*getPlayer().getDamageMultiplier());
                    System.out.println();
                    monster.setHp((int) (monster.getHp()-monster.getHp()*getPlayer().getDamageMultiplier()));
                } else {
                    System.out.println("Tirou: " + monster.getHp());
                }
                monster.setHp(0);
                System.out.println("Você matou o " + monster.getName());
                if(monster.getName() == "Zombie") {
                    getPlayer().setXp(player.getXp() + 250);
                    getPlayer().setCoins(getPlayer().getCoins() - 125);
                    System.out.println("Você recebeu 250 de XP e 125 moedas por derrotar o Zombie.");
                } else if(monster.getName() == "Slime") {
                    getPlayer().setXp(player.getXp() + 5000);
                    getPlayer().setCoins(getPlayer().getCoins() + 250);
                    System.out.println("Você recebeu 500 de XP e 250 moedas por derrotar a Slime.");
                } else if(monster.getName() == "Wither") {
                    getPlayer().setXp(player.getXp() + 700);
                    getPlayer().setCoins(getPlayer().getCoins() + 350);
                    System.out.println("Você recebeu 700 de XP e 350 moedas por derrotar o Wither.");
                }
                if(getPlayer().getXpMultiplier() > 2) {
                    getPlayer().setXp((float) (5 + getPlayer().getXpMultiplier()));
                    System.out.println("Ganhou: " + (5 * getPlayer().getXpMultiplier()) + " de XP.");
                    System.out.println("BUFF de XP: ATIVADO");
                } else {
                    System.out.println("Ganhou: " + 5 + " de xp.");
                    System.out.println("BUFF de XP: DESATIVADO");
                }
                System.out.println("======================");
            } else {
                player.setXp(getPlayer().getXp() + 5);
                System.out.println("======================");
                if(getPlayer().haveSword) {
                    System.out.println("Você usou a sua espada de esmeralda.");
                    System.out.printf("Tirou: %.2f", getPlayer().getRandom()*getPlayer().getDamageMultiplier());
                    System.out.println();
                    monster.setHp((int) (monster.getHp()-getPlayer().getRandom()*getPlayer().getDamageMultiplier()));
                } else {
                    System.out.println("Tirou: " + getPlayer().getRandom());
                    monster.setHp(monster.getHp()-getPlayer().getRandom());
                }
                if(getPlayer().getXpMultiplier() > 2) {
                    player.setXp((float) (5 + getPlayer().getXpMultiplier()));
                    System.out.println("Ganhou: " + 5*getPlayer().getXpMultiplier() + " de XP.");
                    System.out.println("BUFF de XP: ATIVADO");
                } else {
                    System.out.println("Ganhou: " + 5 + " de xp.");
                    System.out.println("BUFF de XP: DESATIVADO");
                }
                System.out.println("Vida do " + monster.getName() + ": " + monster.getHp());
                System.out.println("======================");
            }
        }
    }
}
