import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NestingDepth {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < testCaseCount; i++) {
            String input = reader.readLine();
            String result = processInput(input);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static String processInput(String input) {
        StringBuilder output = new StringBuilder();
        int previousDepth = 0;

        for (char ch : input.toCharArray()) {
            int currentDepth = Character.getNumericValue(ch);
            int difference = currentDepth - previousDepth;

            if (difference > 0) {
                output.append("(".repeat(difference));
            } else if (difference < 0) {
                output.append(")".repeat(-difference));
            }

            output.append(currentDepth);
            previousDepth = currentDepth;
        }

        output.append(")".repeat(previousDepth));
        return output.toString();
    }
}