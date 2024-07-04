import java.util.Scanner;

public class Solution {
    private static Scanner scanner;
    private static int testCaseNumber = 1;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();
        while (testCases-- > 0) {
            solve();
        }
    }

    private static void solve() {
        String input = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        char[] digits = input.toCharArray();

        int currentNumber = Character.getNumericValue(digits[0]);
        appendBrackets(result, currentNumber, '(');
        result.append(currentNumber);

        for (int i = 1; i < digits.length; i++) {
            int nextNumber = Character.getNumericValue(digits[i]);

            if (nextNumber > currentNumber) {
                appendBrackets(result, nextNumber - currentNumber, '(');
            } else if (nextNumber < currentNumber) {
                appendBrackets(result, currentNumber - nextNumber, ')');
            }

            result.append(nextNumber);
            currentNumber = nextNumber;
        }

        appendBrackets(result, currentNumber, ')');
        System.out.println("Case #" + (testCaseNumber++) + ": " + result.toString());
    }

    private static void appendBrackets(StringBuilder result, int count, char bracket) {
        for (int i = 0; i < count; i++) {
            result.append(bracket);
        }
    }
}