import java.util.Scanner;

public class Solution {
    private static Scanner scanner;
    private static int testCaseNumber = 1;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        while (numberOfTestCases-- > 0) {
            solve();
        }
    }

    private static void solve() {
        String input = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        char[] characters = input.toCharArray();
        int currentDepth = 0;
        int requiredDepth = Character.getNumericValue(characters[0]);

        // Open initial brackets
        for (int i = 0; i < requiredDepth; i++) {
            result.append('(');
        }
        result.append(characters[0]);

        for (int i = 1; i < characters.length; i++) {
            int digit = Character.getNumericValue(characters[i]);
            if (digit > requiredDepth) {
                // Open brackets
                for (int j = 0; j < (digit - requiredDepth); j++) {
                    result.append('(');
                }
            } else if (digit < requiredDepth) {
                // Close brackets
                for (int j = 0; j < (requiredDepth - digit); j++) {
                    result.append(')');
                }
            }
            result.append(characters[i]);
            requiredDepth = digit;
        }

        // Close remaining open brackets
        for (int i = 0; i < requiredDepth; i++) {
            result.append(')');
        }

        System.out.println("Case #" + (testCaseNumber++) + ": " + result.toString());
    }
}