import java.util.Scanner;

public class Solution {
    public static String generateParentheses(int count, boolean isOpen) {
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
            String input = scanner.nextLine();
            StringBuilder resultBuilder = new StringBuilder();
            int currentDepth = 0;

            for (char ch : input.toCharArray()) {
                int digit = Character.getNumericValue(ch);

                if (currentDepth < digit) {
                    resultBuilder.append(generateParentheses(digit - currentDepth, true));
                } else if (currentDepth > digit) {
                    resultBuilder.append(generateParentheses(currentDepth - digit, false));
                }

                resultBuilder.append(digit);
                currentDepth = digit;
            }

            resultBuilder.append(generateParentheses(currentDepth, false));
            results[i] = resultBuilder.toString();
        }

        for (String result : results) {
            System.out.println(result);
        }

        scanner.close();
    }
}