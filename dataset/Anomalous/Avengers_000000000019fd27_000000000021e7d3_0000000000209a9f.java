import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NestingDepth {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= testCases; i++) {
            String input = reader.readLine();
            String result = calculateNestingDepth(input);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static String calculateNestingDepth(String input) {
        StringBuilder result = new StringBuilder();
        int previousDepth = 0;

        for (char c : input.toCharArray()) {
            int currentDepth = Character.getNumericValue(c);
            int depthDifference = currentDepth - previousDepth;

            if (depthDifference > 0) {
                result.append("(".repeat(depthDifference));
            } else if (depthDifference < 0) {
                result.append(")".repeat(-depthDifference));
            }

            result.append(c);
            previousDepth = currentDepth;
        }

        if (previousDepth > 0) {
            result.append(")".repeat(previousDepth));
        }

        return result.toString();
    }
}