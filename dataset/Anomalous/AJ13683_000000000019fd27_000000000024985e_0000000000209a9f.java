import java.util.Scanner;

public class Solution {
    private static Scanner scanner;
    private static int testCaseNumber = 1;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        scanner.nextLine();

        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() {
        String input = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        char[] characters = input.toCharArray();
        int currentNumber = Character.getNumericValue(characters[0]);
        int openBrackets = currentNumber;

        // Append initial open brackets
        for (int i = 0; i < currentNumber; i++) {
            result.append('(');
        }
        result.append(currentNumber);

        for (int i = 1; i < characters.length; i++) {
            int nextNumber = Character.getNumericValue(characters[i]);

            if (nextNumber > currentNumber) {
                // Append open brackets
                for (int j = 0; j < nextNumber - currentNumber; j++) {
                    result.append('(');
                }
                openBrackets += nextNumber - currentNumber;
            } else if (nextNumber < currentNumber) {
                // Append close brackets
                for (int j = 0; j < currentNumber - nextNumber; j++) {
                    result.append(')');
                }
                openBrackets -= currentNumber - nextNumber;
            }

            result.append(nextNumber);
            currentNumber = nextNumber;
        }

        // Append remaining close brackets
        for (int i = 0; i < openBrackets; i++) {
            result.append(')');
        }

        System.out.println("Case #" + (testCaseNumber++) + ": " + result.toString());
    }
}