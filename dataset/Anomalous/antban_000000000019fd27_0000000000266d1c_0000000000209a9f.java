import java.util.Scanner;

public class Solution {

    public static String generateNestedParentheses(String input) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (char ch : input.toCharArray()) {
            int digit = ch - '0';

            while (currentDepth < digit) {
                result.append('(');
                currentDepth++;
            }
            while (currentDepth > digit) {
                result.append(')');
                currentDepth--;
            }
            result.append(ch);
        }

        while (currentDepth > 0) {
            result.append(')');
            currentDepth--;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int numberOfTests = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            for (int testCase = 1; testCase <= numberOfTests; testCase++) {
                String input = scanner.nextLine();
                String solution = generateNestedParentheses(input);
                System.out.println("Case #" + testCase + ": " + solution);
            }
        }
    }
}