import java.util.Scanner;

public class Solution {

    private static String generateParentheses(int count, boolean isOpen) {
        StringBuilder parentheses = new StringBuilder();
        char parenthesis = isOpen ? '(' : ')';
        for (int i = 0; i < count; i++) {
            parentheses.append(parenthesis);
        }
        return parentheses.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        String[] results = new String[testCases];

        for (int i = 0; i < testCases; i++) {
            String inputLine = scanner.nextLine();
            StringBuilder output = new StringBuilder();
            int currentDepth = 0;

            for (char ch : inputLine.toCharArray()) {
                int digit = Character.getNumericValue(ch);
                if (currentDepth < digit) {
                    output.append(generateParentheses(digit - currentDepth, true));
                } else if (currentDepth > digit) {
                    output.append(generateParentheses(currentDepth - digit, false));
                }
                output.append(digit);
                currentDepth = digit;
            }

            output.append(generateParentheses(currentDepth, false));
            results[i] = output.toString();
        }

        for (int i = 0; i < testCases; i++) {
            System.out.printf("Case #%d: %s%n", i + 1, results[i]);
        }

        scanner.close();
    }
}