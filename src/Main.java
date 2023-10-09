import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao RPG!");
        System.out.println("O objetivo do jogo é completar todos os objetivos na aba STATUS do menu.");
        System.out.println("Se morrer, terá que recomeçar do zero.");
        System.out.println("");
        System.out.println("Como é que quer chamar o seu personagem?");

        String playerName = scanner.nextLine();

        GameCore game = new GameCore(playerName);

        System.out.println("É um prazer, "+playerName+". Boa sorte!");
        System.out.println("A carregar jogo...");
        pause();
        game.start();
    }

    public static void pause() throws InterruptedException {
        Thread.sleep(3000);
    }

}