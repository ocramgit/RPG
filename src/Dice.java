import java.util.Scanner;

public class Dice {

    Scanner sc = new Scanner(System.in);
    int montanteApostado;
    Player player;

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
        switch (sc.nextInt()) {
            case 1:
                System.out.print("Montante a apostar: ");
                montanteApostado = sc.nextInt();
                if(player.xp >= montanteApostado) {
                    System.out.println("Acha que a banca vai gerar um número PAR ou ÍMPAR?");
                    System.out.println("1 - PAR");
                    System.out.println("2 - ÍMPAR");
                    System.out.println("3 - Desistir");

                    int userChoice = sc.nextInt();

                    if(userChoice == 1) {
                        checkIfIsOddOrEven(userChoice, 1);
                    }

                    if(userChoice == 2) {
                        checkIfIsOddOrEven(2, 2);
                    }

                } else {
                    System.out.println("Você não tem XP suficiente.");
                }
                break;
            default:
                System.out.println("Número inválido");
                break;
        }
    }

    public void checkIfIsOddOrEven(int choice, int evenOrOdd) {
        int random = generateNumber();
        if(choice % 2 == evenOrOdd) {
            System.out.println("Você acertou! O número gerado foi " + random + ".");
            System.out.println("Ganhou: "+montanteApostado+" de XP.");
            player.xp+=montanteApostado;
        } else {
            System.out.println("Errado! O número gerado foi "+random+".");
            System.out.println("Perdeste: "+montanteApostado+" de XP.");
            player.xp+=montanteApostado;
        }

    }

    public int generateNumber() {
        double randomNumber = Math.random() * 20 + 1;
        return (int) randomNumber;
    }

}
