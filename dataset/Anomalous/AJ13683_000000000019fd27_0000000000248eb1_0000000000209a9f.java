import java.util.Scanner;

public class Solution {
    private static Scanner sc;
    private static int testCaseNumber = 1;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (testCases-- > 0) {
            solve();
        }
    }

    private static void solve() {
        String inputString = sc.nextLine();
        StringBuilder result = new StringBuilder();
        char[] characters = inputString.toCharArray();
        int currentNum = Character.getNumericValue(characters[0]);
        int openBrackets = currentNum;

        // Append initial open brackets
        for (int i = 0; i < currentNum; i++) {
            result.append('(');
        }

        result.append(currentNum);

        for (int i = 1; i < characters.length; i++) {
            int nextNum = Character.getNumericValue(characters[i]);
            if (nextNum > currentNum) {
                // Add open brackets
                for (int j = 0; j < (nextNum - currentNum); j++) {
                    result.append('(');
                }
                openBrackets += (nextNum - currentNum);
            } else if (nextNum < currentNum) {
                // Add close brackets
                for (int j = 0; j < (currentNum - nextNum); j++) {
                    result.append(')');
                }
                openBrackets -= (currentNum - nextNum);
            }
            result.append(nextNum);
            currentNum = nextNum;
        }

        // Close remaining open brackets
        while (openBrackets-- > 0) {
            result.append(')');
        }

        System.out.println("Case #" + (testCaseNumber++) + ": " + result.toString());
    }
}