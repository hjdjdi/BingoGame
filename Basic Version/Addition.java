public class Addition extends NumberGenerator {
    public Addition() {
        super("Addition");
    }

    @Override
    public int generate(int a, int b) {
        int result = a + b;
        if (result >= 100) {
            result -= 99;
        }
        System.out.printf("Addition: %d + %d = %d%n", a, b, result);
        return result;
    }
}