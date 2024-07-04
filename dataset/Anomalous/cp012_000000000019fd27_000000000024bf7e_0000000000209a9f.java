import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);
    private static int testCaseNumber = 1;

    public static void main(String[] args) {
        int numberOfTests = scanner.nextInt();
        scanner.nextLine();

        while (numberOfTests-- > 0) {
            solve();
        }
    }

    public static void solve() {
        String input = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        char[] characters = input.toCharArray();
        int currentPairs = Character.getNumericValue(characters[0]);
        int openBrackets = currentPairs;

        // Append initial open brackets
        result.append("(".repeat(currentPairs));
        result.append(currentPairs);

        // Process the rest of the characters
        for (int i = 1; i < characters.length; i++) {
            int digit = Character.getNumericValue(characters[i]);

            if (digit > currentPairs) {
                result.append("(".repeat(digit - currentPairs));
                openBrackets += digit - currentPairs;
            } else if (digit < currentPairs) {
                result.append(")".repeat(currentPairs - digit));
                openBrackets -= currentPairs - digit;
            }

            result.append(digit);
            currentPairs = digit;
        }

        // Close any remaining open brackets
        result.append(")".repeat(openBrackets));

        System.out.println("Case #" + (testCaseNumber++) + ": " + result);
    }
}