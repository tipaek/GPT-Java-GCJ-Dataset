import java.io.*;
import java.util.*;

public class Solution {

    private static final boolean DEBUG = false;

    public static String solve(String input) {
        int depth = 0;
        StringBuilder result = new StringBuilder();

        for (char ch : input.toCharArray()) {
            int current = Character.getNumericValue(ch);
            while (depth > current) {
                result.append(")");
                depth--;
            }
            while (depth < current) {
                result.append("(");
                depth++;
            }
            result.append(ch);
        }
        while (depth > 0) {
            result.append(")");
            depth--;
        }

        return result.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.nanoTime();
        InputStream inputStream = DEBUG ? new FileInputStream("src/main/resources/codejam/y2020/qualification/nestingdepth-1.in") : System.in;

        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(inputStream)))) {
            int numberOfTests = scanner.nextInt();
            for (int testIndex = 1; testIndex <= numberOfTests; testIndex++) {
                String inputString = scanner.next();
                System.out.println("Case #" + testIndex + ": " + solve(inputString));
            }
        }
        System.err.println("Done in " + ((System.nanoTime() - startTime) / 1e9) + " seconds.");
    }
}