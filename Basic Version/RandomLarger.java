import java.util.Random;

public class RandomLarger extends NumberGenerator {
    public RandomLarger() {
        super("RandomLarger");
    }

    @Override
    public int generate(int a, int b) {
        Random rand = new Random();
        int limit = Math.max(a, b);
        int result = rand.nextInt(100 - limit) + limit; // Random from limit to 99
        System.out.printf("RandomLarger: Random[%d to 99] = %d%n", limit, result);
        return result;
    }
}