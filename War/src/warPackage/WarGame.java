package warPackage;
import java.util.Scanner;

public class WarGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();

        while (!game.isGameOver()) {
            System.out.print("Press Enter to play a round.");
            scanner.nextLine();
            game.playRound();
        }

        game.displayWinner();
        scanner.close();
    }
}