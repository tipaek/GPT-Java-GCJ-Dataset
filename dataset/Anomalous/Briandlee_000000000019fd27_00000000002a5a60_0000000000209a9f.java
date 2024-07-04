import java.util.Scanner;

public class Solution {
    private static final Scanner sc = new Scanner(System.in);
    private static int testCaseNumber = 1;

    public static void main(String[] args) {
        int testCases = sc.nextInt();
        sc.nextLine(); // Consume the newline

        while (testCases-- > 0) {
            solve();
        }
    }

    private static void solve() {
        String input = sc.nextLine();
        StringBuilder result = new StringBuilder();
        char[] digits = input.toCharArray();
        int currentNum = Character.getNumericValue(digits[0]);
        int openBrackets = currentNum;

        // Append initial opening brackets and the first digit
        result.append("(".repeat(currentNum)).append(currentNum);

        for (int i = 1; i < digits.length; i++) {
            int nextNum = Character.getNumericValue(digits[i]);

            if (nextNum > currentNum) {
                result.append("(".repeat(nextNum - currentNum));
            } else if (nextNum < currentNum) {
                result.append(")".repeat(currentNum - nextNum));
            }

            result.append(nextNum);
            currentNum = nextNum;
        }

        // Close any remaining open brackets
        result.append(")".repeat(currentNum));

        System.out.println("Case #" + (testCaseNumber++) + ": " + result);
    }
}