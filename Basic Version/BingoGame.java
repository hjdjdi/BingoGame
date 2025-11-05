import java.util.Random;
import java.util.Scanner;

public class BingoGame {
    private BingoCard player1Card;
    private BingoCard player2Card;
    private NumberGenerator[] generators;

    public BingoGame() {
        this.player1Card = new BingoCard();
        this.player2Card = new BingoCard();
        this.generators = new NumberGenerator[]{
            new Addition(),
            new Subtraction(),
            new RandomWithin(),
            new RandomSmaller(),
            new RandomLarger()
        };
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        int round = 1;

        while (true) {
            System.out.println("Round " + round + ":");
            System.out.println("---------------------------------");
            displayCards();

            int player1Input = getPlayerInput(scanner, 1);
            int player2Input = getPlayerInput(scanner, 2);

            int generatedNumber = generateNumber(player1Input, player2Input);
            System.out.println("Generated number: " + generatedNumber);

            player1Card.markNumber(generatedNumber);
            player2Card.markNumber(generatedNumber);

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

    private int getPlayerInput(Scanner scanner, int player) {
        int input = -1;
        while (true) {
            System.out.print("Player " + player + " input (1 - 99): ");
            try {
                input = Integer.parseInt(scanner.nextLine());
                if (input < 1 || input > 99) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Please input an integer between 1 and 99.");
            }
        }
        return input;
    }

    private int generateNumber(int player1Input, int player2Input) {
        int generatorIndex = new Random().nextInt(generators.length);
        NumberGenerator generator = generators[generatorIndex];
        return generator.generate(player1Input, player2Input);
    }

    private boolean checkWinners() {
        boolean player1Wins = player1Card.checkWinner();
        boolean player2Wins = player2Card.checkWinner();

        if (player1Wins && player2Wins) {
            System.out.println("Both players achieved BINGO! It's a draw!");
            return true;
        } else if (player1Wins) {
            System.out.println("Player 1 BINGO! Player 1 Wins!");
            return true;
        } else if (player2Wins) {
            System.out.println("Player 2 BINGO! Player 2 Wins!");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        BingoGame game = new BingoGame();
        game.startGame();
    }
}