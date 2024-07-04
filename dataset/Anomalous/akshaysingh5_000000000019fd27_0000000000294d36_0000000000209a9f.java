import java.util.Scanner;

public class Solution {
    private static Scanner scanner;
    private static int caseNumber = 1;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < testCases; i++) {
            solve();
        }
    }

    public static void solve() {
        String input = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        char[] digits = input.toCharArray();

        int previousDigit = Character.getNumericValue(digits[0]);
        int openBrackets = previousDigit;

        // Append initial open brackets and the first digit
        appendBrackets(result, openBrackets, '(');
        result.append(previousDigit);

        for (int i = 1; i < digits.length; i++) {
            int currentDigit = Character.getNumericValue(digits[i]);
            if (currentDigit > previousDigit) {
                appendBrackets(result, currentDigit - previousDigit, '(');
            } else if (currentDigit < previousDigit) {
                appendBrackets(result, previousDigit - currentDigit, ')');
            }
            result.append(currentDigit);
            previousDigit = currentDigit;
        }

        // Close any remaining open brackets
        appendBrackets(result, openBrackets, ')');

        System.out.println("Case #" + (caseNumber++) + ": " + result.toString());
    }

    private static void appendBrackets(StringBuilder sb, int count, char bracket) {
        for (int i = 0; i < count; i++) {
            sb.append(bracket);
        }
    }
}