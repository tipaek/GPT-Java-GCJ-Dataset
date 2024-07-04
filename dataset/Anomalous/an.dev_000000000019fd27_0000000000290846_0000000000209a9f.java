import java.io.*;
import java.util.*;

public class Solution {

    private static final boolean DEBUG = false;

    public static String solve(String s) {
        int depth = 0;
        StringBuilder result = new StringBuilder();

        for (char ch : s.toCharArray()) {
            int currentDigit = Character.getNumericValue(ch);
            while (depth > currentDigit) {
                result.append(")");
                depth--;
            }
            while (depth < currentDigit) {
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
        InputStream input = DEBUG ? new FileInputStream("src/main/resources/codejam/y2020/qualification/nestingdepth-1.in") : System.in;
        
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(input)))) {
            int numberOfTests = scanner.nextInt();
            for (int testCase = 1; testCase <= numberOfTests; testCase++) {
                String inputString = scanner.next();
                System.out.println("Case #" + testCase + ": " + solve(inputString));
            }
        }
        
        System.err.println("Execution completed in " + ((System.nanoTime() - startTime) / 1e9) + " seconds.");
    }
}