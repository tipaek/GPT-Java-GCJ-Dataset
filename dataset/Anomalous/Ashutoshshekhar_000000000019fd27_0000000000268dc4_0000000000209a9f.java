import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfTestCases = scanner.nextInt();
        scanner.nextLine();

        for (int testCaseNumber = 1; testCaseNumber <= numberOfTestCases; testCaseNumber++) {
            String input = scanner.nextLine();
            String result = processInput(input);
            System.out.printf("Case #%d: %s\n", testCaseNumber, result);
        }
    }

    public static String processInput(String input) {
        StringBuilder resultBuilder = new StringBuilder();

        for (int index = 0; index < input.length(); index++) {
            int currentDigit = Character.getNumericValue(input.charAt(index));
            appendParentheses(resultBuilder, calculateOpeningParentheses(input, index, currentDigit), "(");
            resultBuilder.append(currentDigit);
            appendParentheses(resultBuilder, calculateClosingParentheses(input, index, currentDigit), ")");
        }

        return resultBuilder.toString();
    }

    private static int calculateOpeningParentheses(String input, int index, int currentDigit) {
        if (index == 0) {
            return currentDigit;
        } else {
            int previousDigit = Character.getNumericValue(input.charAt(index - 1));
            return currentDigit - previousDigit;
        }
    }

    private static int calculateClosingParentheses(String input, int index, int currentDigit) {
        if (index == input.length() - 1) {
            return currentDigit;
        } else {
            int nextDigit = Character.getNumericValue(input.charAt(index + 1));
            return currentDigit - nextDigit;
        }
    }

    private static void appendParentheses(StringBuilder builder, int count, String parenthesis) {
        for (int i = 0; i < count; i++) {
            builder.append(parenthesis);
        }
    }
}