abstract class NumberGenerator {
    protected String name;

    public NumberGenerator(String name) {
        this.name = name;
    }

    public abstract int generate(int a, int b);
}