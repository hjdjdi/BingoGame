import java.util.HashSet;
import java.util.Random;

class BingoCard {
    private int[][] card;
    private boolean[][] marked;

    public BingoCard() {
        this.card = generateCard();
        this.marked = new boolean[5][5];
    }

    private int[][] generateCard() {
        HashSet<Integer> numbers = new HashSet<>();
        Random rand = new Random();
        while (numbers.size() < 25) {
            numbers.add(rand.nextInt(99) + 1);
        }

        int[][] newCard = new int[5][5];
        int index = 0;
        for (int number : numbers) {
            newCard[index / 5][index % 5] = number;
            index++;
        }
        return newCard;
    }

    public void markNumber(int number) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (card[i][j] == number) {
                    marked[i][j] = true;
                }
            }
        }
    }

    public boolean checkWinner() {
        for (int i = 0; i < 5; i++) {
            if (checkRow(i) || checkColumn(i)) {
                return true;
            }
        }
        return checkDiagonal();
    }

    private boolean checkRow(int row) {
        for (boolean mark : marked[row]) {
            if (!mark) return false;
        }
        return true;
    }

    private boolean checkColumn(int col) {
        for (int i = 0; i < 5; i++) {
            if (!marked[i][col]) return false;
        }
        return true;
    }

    private boolean checkDiagonal() {
        boolean diag1 = true, diag2 = true;
        for (int i = 0; i < 5; i++) {
            if (!marked[i][i]) diag1 = false;
            if (!marked[i][4 - i]) diag2 = false;
        }
        return diag1 || diag2;
    }

    public void printCard() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(card[i][j] + "  ");
            }
            System.out.print("    ");
            for (int j = 0; j < 5; j++) {
                System.out.print(marked[i][j] ? "X  " : "_  ");
            }
            System.out.println();
        }
        System.out.println();
    }
}