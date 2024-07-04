import java.util.Scanner;

public class Solution {
    private static Scanner scanner;
    private static int testCaseNumber = 1;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
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

        int currentNumber = Character.getNumericValue(digits[0]);
        int openBrackets = currentNumber;

        appendBrackets(result, '(', currentNumber);
        result.append(currentNumber);

        for (int i = 1; i < digits.length; i++) {
            int nextNumber = Character.getNumericValue(digits[i]);

            if (nextNumber > currentNumber) {
                appendBrackets(result, '(', nextNumber - currentNumber);
            } else if (nextNumber < currentNumber) {
                appendBrackets(result, ')', currentNumber - nextNumber);
            }

            result.append(nextNumber);
            currentNumber = nextNumber;
        }

        appendBrackets(result, ')', openBrackets);
        System.out.println("Case #" + (testCaseNumber++) + ": " + result.toString());
    }

    private static void appendBrackets(StringBuilder builder, char bracket, int count) {
        for (int i = 0; i < count; i++) {
            builder.append(bracket);
        }
    }
}