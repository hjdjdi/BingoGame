import java.util.Random;

public class RandomSmaller extends NumberGenerator {
    public RandomSmaller() {
        super("RandomSmaller");
    }

    @Override
    public int generate(int a, int b) {
        Random rand = new Random();
        int limit = Math.min(a, b);
        int result = rand.nextInt(limit) + 1; // Random from 1 to limit
        System.out.printf("RandomSmaller: Random[1 to %d] = %d%n", limit, result);
        return result;
    }
}