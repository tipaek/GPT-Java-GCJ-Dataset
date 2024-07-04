import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static String compute(String input) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (int i = 0; i < input.length(); i++) {
            int currentDigit = Character.getNumericValue(input.charAt(i));
            int openBrackets = currentDigit - currentDepth;

            if (openBrackets > 0) {
                result.append("(".repeat(openBrackets));
                currentDepth += openBrackets;
            }

            result.append(currentDigit);

            if (i + 1 < input.length()) {
                int nextDigit = Character.getNumericValue(input.charAt(i + 1));
                int closeBrackets = currentDepth - nextDigit;
                if (closeBrackets > 0) {
                    result.append(")".repeat(closeBrackets));
                    currentDepth -= closeBrackets;
                }
            } else {
                result.append(")".repeat(currentDepth));
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 0; i < testCases; i++) {
            String input = scanner.nextLine();
            String output = compute(input);
            System.out.printf("Case #%d: %s%n", i + 1, output);
        }

        scanner.close();
    }
}