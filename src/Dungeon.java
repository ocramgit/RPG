import java.util.Scanner;

public class Dungeon {

    Monster flying_Tiger, enderman, baby_Dragon, giant, dragon;
    GameCore gameCore;
    Player player;
    Shop shop;
    boolean flyingisDead = false;
    boolean endermanisDead = false;
    boolean babyDragonisDead = false;
    boolean giantisDead = false;
    boolean dragonisDead = false;
    Scanner sc = new Scanner(System.in);

    public Dungeon(Player player, GameCore gameCore, Shop shop) {
        flying_Tiger = new Monster("Flying Tiger", 2300);
        enderman = new Monster("Enderman", 3400);
        baby_Dragon = new Monster("Baby Dragon", 4000);
        giant = new Monster("Giant", 4500);
        dragon = new Monster("Dragon", 5500);

        this.gameCore = gameCore;
        this.player = player;
        this.shop = shop;
    }

    public void startDungeon() {
        System.out.println("Dungeon é um modo de jogo de risco. Sair a meio fará com que recomece.");
        System.out.println("A cada nível o preço da cura aumenta em 2x e o dano sofrido é aumentado gradualmente.");
        System.out.println("1 - Iniciar Dungeon");
        System.out.println("2 - Voltar para o menu");
        System.out.println();
        System.out.print("Escolha o item do menu: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                levelOne();
                break;
            case 2:
                gameCore.start();
            default:
                System.out.println("Número inválido.");
                startDungeon();
                break;
        }
    }

    public void levelOne() {

        while(!flyingisDead) {

            if(player.getHp() <= 0){
                System.out.println("Você morreu e perdeu 50% das suas moedas.");
                player.setCoins(player.getCoins() - player.getCoins()/2);
                player.setHp(100);

                flying_Tiger.setHp(2300);
                enderman.setHp(3400);
                baby_Dragon.setHp(4000);
                giant.setHp(4500);
                dragon.setHp(5500);

                gameCore.start();
                break;
            }

            isPlayerDead(player);


            System.out.println("1 - Atacar " + "- ("+ flying_Tiger.getName()+") - ("+flying_Tiger.getHp()+" de Vida)");
            System.out.println("2 - Recuperar vida (50 XP)");
            System.out.println("3 - Comprar Armadura (200 XP)");
            System.out.println("4 - Desistir");
            System.out.println();
            System.out.print("Escolha a opção: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    player.attack(flying_Tiger);
                    flying_Tiger.autoAttack(player);
                    break;
                case 2:
                    shop.buyLife(player, 50);
                    break;
                case 3:
                    shop.buyArmour(player, 250);
                    break;
                case 4:
                    System.out.println("Você desistiu da dungeon.");
                    flying_Tiger.setHp(2300);
                    enderman.setHp(3400);
                    baby_Dragon.setHp(4000);
                    giant.setHp(4500);
                    dragon.setHp(5500);
                    gameCore.start();
                default:
                    System.out.println("Número inválido.");
                    levelOne();
                    break;
            }

            if (flying_Tiger.getHp() <= 0) {
                System.out.println("Você matou o " + flying_Tiger.getName());
                System.out.println("Nível 2...");
                flyingisDead = true;
                levelTwo();
            }
        }

    }

    public void levelTwo() {
        while (!endermanisDead) {

            isPlayerDead(player);

                System.out.println("1 - Atacar " + "- (" + enderman.getName() + ") - (" + enderman.getHp() + " de Vida)");
                System.out.println("2 - Recuperar vida (100 XP)");
                System.out.println("3 - Comprar Armadura (250 XP)");
                System.out.println("4 - Desistir");
                System.out.println();
                System.out.print("Escolha a opção: ");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        enderman.damageMultiplier = 2;
                        player.attack(enderman);
                        enderman.autoAttack(player);
                        break;
                    case 2:
                        shop.buyLife(player, 100);
                        break;
                    case 3:
                        shop.buyArmour(player, 250);
                        break;
                    case 4:
                        System.out.println("Você desistiu da dungeon.");
                        flying_Tiger.setHp(2300);
                        enderman.setHp(3400);
                        baby_Dragon.setHp(4000);
                        giant.setHp(4500);
                        dragon.setHp(5500);
                        gameCore.start();
                    default:
                        System.out.println("Número inválido.");
                        levelTwo();
                        break;
                }

                if (flying_Tiger.getHp() <= 0) {
                    System.out.println("Você matou o " + enderman.getName());
                    System.out.println("Nível 3...");
                    endermanisDead = true;
                    levelThree();
                }
            }
    }

    public void levelThree() {
        while(!babyDragonisDead) {

            isPlayerDead(player);

                System.out.println("1 - Atacar " + "- (" + baby_Dragon.getName() + ") - (" + baby_Dragon.getHp() + " de Vida)");
                System.out.println("2 - Recuperar vida (200 XP)");
                System.out.println("3 - Comprar Armadura (300 XP)");
                System.out.println("4 - Desistir");
                System.out.println();
                System.out.print("Escolha a opção: ");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        baby_Dragon.damageMultiplier = 3;
                        player.attack(baby_Dragon);
                        baby_Dragon.autoAttack(player);
                        break;
                    case 2:
                        shop.buyLife(player, 200);
                        break;
                    case 3:
                        shop.buyArmour(player, 300);
                        break;
                    case 4:
                        System.out.println("Você desistiu da dungeon.");
                        flying_Tiger.setHp(2300);
                        enderman.setHp(3400);
                        baby_Dragon.setHp(4000);
                        giant.setHp(4500);
                        dragon.setHp(5500);
                        gameCore.start();
                    default:
                        System.out.println("Número inválido.");
                        levelThree();
                        break;
                }

                if (baby_Dragon.getHp() <= 0) {
                    System.out.println("Você matou o " + baby_Dragon.getName());
                    babyDragonisDead = true;
                    levelFour();
                }
            }
        }

    public void levelFour() {
            while (!giantisDead) {

                isPlayerDead(player);

                    System.out.println("1 - Atacar " + "- (" + giant.getName() + ") - (" + giant.getHp() + " de Vida)");
                    System.out.println("2 - Recuperar vida (400 XP)");
                    System.out.println("3 - Comprar Armadura (350 XP)");
                    System.out.println("4 - Desistir");
                    System.out.println();
                    System.out.print("Escolha a opção: ");

                    int choice = sc.nextInt();

                    switch (choice) {
                        case 1:
                            giant.damageMultiplier = 4;
                            player.attack(giant);
                            giant.autoAttack(player);
                            break;
                        case 2:
                            shop.buyLife(player, 400);
                            break;
                        case 3:
                            shop.buyArmour(player, 350);
                            break;
                        case 4:
                            System.out.println("Você desistiu da dungeon.");
                            flying_Tiger.setHp(2300);
                            enderman.setHp(3400);
                            baby_Dragon.setHp(4000);
                            giant.setHp(4500);
                            dragon.setHp(5500);
                            gameCore.start();
                        default:
                            System.out.println("Número inválido.");
                            levelFour();
                            break;
                    }

                    if (giant.getHp() <= 0) {
                        System.out.println("Você matou o " + giant.getName());
                        giantisDead = true;
                        levelFive();
                    }
            }
    }

    public void levelFive() {
        while(!dragonisDead) {

            isPlayerDead(player);

                System.out.println("1 - Atacar " + "- (" + dragon.getName() + ") - (" + dragon.getHp() + " de Vida)");
                System.out.println("2 - Recuperar vida (800 XP)");
                System.out.println("3 - Comprar Armadura (400 XP)");
                System.out.println("4 - Desistir");
                System.out.println();
                System.out.print("Escolha a opção: ");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        dragon.damageMultiplier = 5;
                        player.attack(dragon);
                        dragon.autoAttack(player);
                        break;
                    case 2:
                        shop.buyLife(player, 800);
                        break;
                    case 3:
                        shop.buyArmour(player, 400);
                        break;
                    case 4:
                        System.out.println("Você desistiu da dungeon.");
                        flying_Tiger.setHp(2300);
                        enderman.setHp(3400);
                        baby_Dragon.setHp(4000);
                        giant.setHp(4500);
                        dragon.setHp(5500);
                        gameCore.start();
                    default:
                        System.out.println("Número inválido.");
                        levelFive();
                        break;
                }

                if (dragon.getHp() <= 0) {
                    System.out.println("Você matou o " + dragon.getName());
                    dragonisDead = true;
                    finishDungeon();
                }
            }
    }

    public void finishDungeon() {
        if(flyingisDead && endermanisDead && babyDragonisDead && giantisDead && dragonisDead) {
            System.out.println("Parabéns, você concluiu a masmorra!");
            System.out.println("Você ganhou 3000 XP e 2000 Moedas.");
            player.setXp(player.getXp() + 3000);
            player.setCoins(player.getCoins() + 2000);
            gameCore.dungeonConcluded = true;
            gameCore.start();
        }
    }

    public void isPlayerDead(Player player) {
        if(player.getHp() <= 0){
            System.out.println("Você morreu e perdeu 50% das suas moedas.");
            player.setCoins(player.getCoins() - player.getCoins()/2);
            player.setHp(100);

            flying_Tiger.setHp(2300);
            enderman.setHp(3400);
            baby_Dragon.setHp(4000);
            giant.setHp(4500);
            dragon.setHp(5500);

            gameCore.start();
        }
    }
}
