import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.next();
            StringBuilder output = new StringBuilder();
            int previousDigit = Character.getNumericValue(input.charAt(0));
            output.append(addParentheses(previousDigit, previousDigit));

            for (int index = 1; index < input.length(); index++) {
                int currentDigit = Character.getNumericValue(input.charAt(index));
                int balance = Math.max(currentDigit - previousDigit, 0);
                int nestingLevel = Math.min(previousDigit, currentDigit);
                output.setLength(output.length() - nestingLevel);
                output.append(addParentheses(currentDigit, balance));
                output.append(")".repeat(nestingLevel));
                previousDigit = currentDigit;
            }
            System.out.printf("Case #%d: %s%n", caseNumber, output);
        }
    }

    static String addParentheses(int num, int count) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append("(");
        }
        result.append(num);
        for (int i = 0; i < count; i++) {
            result.append(")");
        }
        return result.toString();
    }
}