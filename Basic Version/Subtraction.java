public class Subtraction extends NumberGenerator {
    public Subtraction() {
        super("Subtraction");
    }

    @Override
    public int generate(int a, int b) {
        int result = a - b;
        if (result < 0) {
            result = -result;  // Make it positive
        } else if (result == 0) {
            result = a;
        }
        System.out.printf("Subtraction: %d - %d = %d%n", a, b, result);
        return result;
    }
}
