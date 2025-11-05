import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NumbersFileReader {
    public static int[] readNumbers(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            return reader.lines().mapToInt(Integer::parseInt).toArray();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return new int[0];
        }
    }
}