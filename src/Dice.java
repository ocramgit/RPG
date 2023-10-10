import java.util.Scanner;

public class Dice {

    Scanner sc = new Scanner(System.in);
    int montanteApostado;
    Player player;
    int typeUser;

    public Dice(Player player) {
        this.player = player;
    }

    public void playDice(Player player) {
        System.out.println("O que quer apostar?");
        System.out.println("1 - XP");
        System.out.println("2 - Moedas");
        System.out.println("3 - Pó Mágico");
        System.out.println("4 - Sair para o menu principal");
        System.out.print("Opção: ");

        typeUser = sc.nextInt();

                System.out.print("Montante a apostar: ");
                montanteApostado = sc.nextInt();
                if(player.xp >= montanteApostado) {
                    System.out.println("Acha que a banca vai gerar um número PAR ou ÍMPAR?");
                    System.out.println("1 - PAR");
                    System.out.println("2 - ÍMPAR");
                    System.out.println("3 - Desistir");
                    System.out.println("");
                    System.out.print("Opção: ");

                    switch (sc.nextInt()) {
                        case 1:
                            checkIfIsOddOrEven(1);
                            break;
                        case 2:
                            checkIfIsOddOrEven(2);
                            break;
                        case 3:
                            System.out.println("Você desistiu do jogo Par ou Ímpar!");
                            break;
                        default:
                            System.out.println("Número inválido");
                            playDice(player);
                            break;
                    }
                } else {
                    System.out.println("Você não tem XP suficiente.");
                }
    }

    public void checkIfIsOddOrEven(int choice) {
        int random = generateNumber();
        if(random % 2 == choice-1) {
            System.out.println("Você acertou! O número gerado foi " + random + ".");
            if(typeUser == 1) {
                System.out.println("Ganhou: "+montanteApostado+" de XP.");
                player.xp += montanteApostado;
            } else if (typeUser == 2) {
                System.out.println("Ganhou: "+montanteApostado+" de Coins.");
                player.coins += montanteApostado;
            } else {
                System.out.println("Ganhou: "+montanteApostado+" de Pó Mágico.");
                player.magicPowder += montanteApostado;
            }
        } else {
            System.out.println("Errado! O número gerado foi "+random+".");
            if(typeUser == 1) {
                System.out.println("Perdeste: "+montanteApostado+" de XP.");
                player.xp -= montanteApostado;
            } else if (typeUser == 2) {
                System.out.println("Perdeste: "+montanteApostado+" de Coins.");
                player.coins -= montanteApostado;
            } else {
                System.out.println("Perdeste: "+montanteApostado+" de Pó Mágico.");
                player.magicPowder -= montanteApostado;
            }
        }

    }

    public int generateNumber() {
        double randomNumber = Math.random() * 20 + 1;
        return (int) randomNumber;
    }

}
