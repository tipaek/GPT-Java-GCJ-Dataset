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

        int currentDigit = Character.getNumericValue(digits[0]);
        int openBrackets = currentDigit;

        result.append("(".repeat(currentDigit)).append(currentDigit);

        for (int i = 1; i < digits.length; i++) {
            int nextDigit = Character.getNumericValue(digits[i]);

            if (nextDigit > currentDigit) {
                result.append("(".repeat(nextDigit - currentDigit));
                openBrackets += nextDigit - currentDigit;
            } else if (nextDigit < currentDigit) {
                result.append(")".repeat(currentDigit - nextDigit));
                openBrackets -= currentDigit - nextDigit;
            }

            result.append(nextDigit);
            currentDigit = nextDigit;
        }

        result.append(")".repeat(openBrackets));
        System.out.println("Case #" + (caseNumber++) + ": " + result);
    }
}