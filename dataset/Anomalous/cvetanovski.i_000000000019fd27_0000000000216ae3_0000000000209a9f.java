import java.util.Scanner;

public class Solution {
    private static String generateParentheses(int count, char parenthesis) {
        StringBuilder parentheses = new StringBuilder();
        for (int i = 0; i < count; i++) {
            parentheses.append(parenthesis);
        }
        return parentheses.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        String[] results = new String[testCases];

        for (int i = 0; i < testCases; i++) {
            String inputString = scanner.nextLine();
            StringBuilder resultBuilder = new StringBuilder();
            int currentBalance = 0;

            for (char ch : inputString.toCharArray()) {
                int digit = Character.getNumericValue(ch);
                if (currentBalance < digit) {
                    resultBuilder.append(generateParentheses(digit - currentBalance, '('));
                } else if (currentBalance > digit) {
                    resultBuilder.append(generateParentheses(currentBalance - digit, ')'));
                }
                resultBuilder.append(digit);
                currentBalance = digit;
            }
            resultBuilder.append(generateParentheses(currentBalance, ')'));
            results[i] = resultBuilder.toString();
        }

        for (String result : results) {
            System.out.println(result);
        }
    }
}