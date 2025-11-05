import java.util.Random;

public class RandomWithin extends NumberGenerator {
    public RandomWithin() {
        super("RandomWithin");
    }

    @Override
    public int generate(int a, int b) {
        Random rand = new Random();
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        int result = rand.nextInt(max - min + 1) + min;
        System.out.printf("RandomWithin: Random[%d to %d] = %d%n", min, max, result);
        return result;
    }
}