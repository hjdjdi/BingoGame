public class Subtraction extends NumberGenerator {
    public Subtraction() {
        super();
    }

    @Override
    public int generate(int a, int b) {
        return Math.abs(a - b);
    }
}