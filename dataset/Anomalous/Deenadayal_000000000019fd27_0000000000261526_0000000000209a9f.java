import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);
    private static int caseNumber = 1;

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < testCases; i++) {
            solve();
        }
    }

    private static void solve() {
        String input = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        char[] digits = input.toCharArray();

        int currentDigit = Character.getNumericValue(digits[0]);
        int openBrackets = currentDigit;

        appendBrackets(result, openBrackets, '(');
        result.append(currentDigit);

        for (int i = 1; i < digits.length; i++) {
            int nextDigit = Character.getNumericValue(digits[i]);

            if (nextDigit > currentDigit) {
                appendBrackets(result, nextDigit - currentDigit, '(');
            } else if (nextDigit < currentDigit) {
                appendBrackets(result, currentDigit - nextDigit, ')');
            }

            result.append(nextDigit);
            currentDigit = nextDigit;
        }

        appendBrackets(result, openBrackets, ')');
        System.out.println("Case #" + (caseNumber++) + ": " + result.toString());
    }

    private static void appendBrackets(StringBuilder builder, int count, char bracket) {
        for (int i = 0; i < count; i++) {
            builder.append(bracket);
        }
    }
}