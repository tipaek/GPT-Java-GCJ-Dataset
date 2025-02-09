import java.util.Scanner;

public class Solution {
    private static Scanner scanner;
    private static int testCaseNumber = 1;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() {
        String input = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        char[] characters = input.toCharArray();

        int currentDigit = Character.getNumericValue(characters[0]);
        int openBrackets = currentDigit;

        for (int i = 0; i < currentDigit; i++) {
            result.append('(');
        }
        result.append(currentDigit);

        for (int i = 1; i < characters.length; i++) {
            int nextDigit = Character.getNumericValue(characters[i]);

            if (nextDigit > currentDigit) {
                for (int j = 0; j < (nextDigit - currentDigit); j++) {
                    result.append('(');
                }
            } else if (nextDigit < currentDigit) {
                for (int j = 0; j < (currentDigit - nextDigit); j++) {
                    result.append(')');
                }
            }
            result.append(nextDigit);
            currentDigit = nextDigit;
        }

        for (int i = 0; i < currentDigit; i++) {
            result.append(')');
        }

        System.out.println("Case #" + (testCaseNumber++) + ": " + result.toString());
    }
}