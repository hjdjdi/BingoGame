import java.util.Scanner;

public class BingoGame {
    private BingoCard player1Card;
    private BingoCard player2Card;
    private int[] hardcodedNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private int numberIndex;

    public BingoGame() {
        this.player1Card = new BingoCard();
        this.player2Card = new BingoCard();
        this.numberIndex = 0;
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        int round = 1;

        while (true) {
            System.out.println("Round " + round + ":");
            displayCards();

            int number = hardcodedNumbers[numberIndex % hardcodedNumbers.length];
            numberIndex++;
            player1Card.markNumber(number);
            player2Card.markNumber(number);
            System.out.println("Generated number: " + number);

            if (checkWinners()) {
                displayCards();
                break;
            }

            round++;
        }
        scanner.close();
    }

    private void displayCards() {
        System.out.println("Player 1");
        player1Card.printCard();
        System.out.println("Player 2");
        player2Card.printCard();
    }

    private boolean checkWinners() {
        boolean player1Wins = player1Card.checkWinner();
        boolean player2Wins = player2Card.checkWinner();

        if (player1Wins) {
            System.out.println("Player 1 Wins!");
            return true;
        } else if (player2Wins) {
            System.out.println("Player 2 Wins!");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        BingoGame game = new BingoGame();
        game.startGame();
    }
}