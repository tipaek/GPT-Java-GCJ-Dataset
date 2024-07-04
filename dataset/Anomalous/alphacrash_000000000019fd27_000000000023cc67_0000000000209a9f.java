import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCaseCount = scanner.nextInt();
            for (int caseNumber = 1; caseNumber <= testCaseCount; caseNumber++) {
                String inputString = scanner.next();
                String balancedString = balanceParentheses(inputString);
                System.out.println("Case #" + caseNumber + ": " + balancedString);
            }
        }
    }

    private static String balanceParentheses(String input) {
        String initialBalanced = insertParentheses(input);
        return removeUnnecessaryParentheses(initialBalanced);
    }

    private static String insertParentheses(String input) {
        StringBuilder result = new StringBuilder();
        int length = input.length();
        int i = 0;

        while (i < length) {
            int currentDigit = Character.getNumericValue(input.charAt(i));
            for (int j = 0; j < currentDigit; j++) {
                result.append("(");
            }
            result.append(currentDigit);
            i++;

            while (i < length) {
                int nextDigit = Character.getNumericValue(input.charAt(i));
                if (nextDigit == currentDigit) {
                    result.append(nextDigit);
                    i++;
                } else {
                    i--;
                    break;
                }
            }

            for (int j = 0; j < currentDigit; j++) {
                result.append(")");
            }
            i++;
        }

        return result.toString();
    }

    private static String removeUnnecessaryParentheses(String input) {
        StringBuilder result = new StringBuilder();
        int length = input.length();
        int i = 0;

        while (i < length) {
            char currentChar = input.charAt(i);
            if (i == length - 1 || !(currentChar == ')' && input.charAt(i + 1) == '(')) {
                result.append(currentChar);
            } else {
                i++;
            }
            i++;
        }

        return result.toString();
    }
}