import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        scanner.nextLine(); // consume the remaining newline

        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            String input = scanner.nextLine();
            char[] digits = input.toCharArray();
            processInput(digits, caseIndex + 1);
        }
    }

    private static void processInput(char[] digits, int caseNumber) {
        Stack<Character> bracketStack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < digits.length; i++) {
            int currentDigit = Character.getNumericValue(digits[i]);
            if (i == 0) {
                appendBrackets(result, bracketStack, currentDigit);
                result.append(currentDigit);
            } else {
                int previousDigit = Character.getNumericValue(digits[i - 1]);
                if (currentDigit > previousDigit) {
                    appendBrackets(result, bracketStack, currentDigit - previousDigit);
                } else if (currentDigit < previousDigit) {
                    removeBrackets(result, bracketStack, previousDigit - currentDigit);
                }
                result.append(currentDigit);
            }
        }

        // Close any remaining open brackets
        while (!bracketStack.isEmpty()) {
            result.append(bracketStack.pop());
        }

        System.out.println("Case #" + caseNumber + ": " + result);
    }

    private static void appendBrackets(StringBuilder result, Stack<Character> bracketStack, int count) {
        for (int j = 0; j < count; j++) {
            result.append('(');
            bracketStack.push(')');
        }
    }

    private static void removeBrackets(StringBuilder result, Stack<Character> bracketStack, int count) {
        for (int j = 0; j < count; j++) {
            if (!bracketStack.isEmpty()) {
                result.append(bracketStack.pop());
            }
        }
    }
}