import java.util.Scanner;

public class Solution {
    private static Scanner scanner;
    private static int testCaseNumber = 1;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        while (testCases-- > 0) {
            solve();
        }
    }

    private static void solve() {
        String input = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        char[] characters = input.toCharArray();
        int currentValue = Character.getNumericValue(characters[0]);
        int openBrackets = currentValue;

        // Append initial brackets
        result.append("(".repeat(currentValue));
        result.append(currentValue);

        for (int i = 1; i < characters.length; i++) {
            int nextValue = Character.getNumericValue(characters[i]);
            if (nextValue > currentValue) {
                result.append("(".repeat(nextValue - currentValue));
            } else if (nextValue < currentValue) {
                result.append(")".repeat(currentValue - nextValue));
            }
            result.append(nextValue);
            currentValue = nextValue;
        }

        // Close any remaining open brackets
        result.append(")".repeat(openBrackets));

        System.out.println("Case #" + (testCaseNumber++) + ": " + result.toString());
    }
}