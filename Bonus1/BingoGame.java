import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BingoGame {
    private BingoCard player1Card;
    private BingoCard player2Card;
    private int[] numbers;
    private int numberIndex;

    public BingoGame(String filename) {
        this.player1Card = new BingoCard();
        this.player2Card = new BingoCard();
        this.numbers = loadNumbersFromFile(filename);
        this.numberIndex = 0;
    }

    private int[] loadNumbersFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            return reader.lines().mapToInt(Integer::parseInt).toArray();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return new int[0];
        }
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        int round = 1;

        while (true) {
            System.out.println("Round " + round + ":");
            displayCards();

            int number = numbers[numberIndex % numbers.length];
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
        if (args.length < 1) {
            System.out.println("Please provide the filename as a command line argument.");
            return;
        }
        BingoGame game = new BingoGame(args[0]);
        game.startGame();
    }
}