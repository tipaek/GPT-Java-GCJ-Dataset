import java.util.Scanner;

public class Solution {
    private static Scanner scanner;
    private static int testCases;
    private static String inputString;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            readInput();
            System.out.println("Case #" + caseNumber + ": " + solve());
        }

        scanner.close();
    }

    private static void readInput() {
        inputString = scanner.nextLine();
    }

    private static String solve() {
        StringBuilder result = new StringBuilder();
        int currentParentheses = 0;

        for (int i = 0; i < inputString.length(); i++) {
            int digit = inputString.charAt(i) - '0';

            if (digit > currentParentheses) {
                result.append("(".repeat(digit - currentParentheses));
                currentParentheses = digit;
            } else if (digit < currentParentheses) {
                result.append(")".repeat(currentParentheses - digit));
                currentParentheses = digit;
            }

            result.append(digit);
        }

        result.append(")".repeat(currentParentheses));
        return result.toString();
    }
}