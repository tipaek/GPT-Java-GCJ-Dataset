import java.util.Scanner;

public class Solution {
    private static Scanner sc = new Scanner(System.in);
    private static int testCaseNumber = 1;

    public static void main(String[] args) {
        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() {
        String input = sc.nextLine();
        StringBuilder result = new StringBuilder();
        char[] digits = input.toCharArray();
        int currentDepth = 0;
        int targetDepth = Character.getNumericValue(digits[0]);

        for (int i = 0; i < targetDepth; i++) {
            result.append('(');
        }
        result.append(targetDepth);

        for (int i = 1; i < digits.length; i++) {
            int nextDigit = Character.getNumericValue(digits[i]);

            if (nextDigit > currentDepth) {
                for (int j = 0; j < nextDigit - currentDepth; j++) {
                    result.append('(');
                }
            } else if (nextDigit < currentDepth) {
                for (int j = 0; j < currentDepth - nextDigit; j++) {
                    result.append(')');
                }
            }

            result.append(nextDigit);
            currentDepth = nextDigit;
        }

        for (int i = 0; i < currentDepth; i++) {
            result.append(')');
        }

        System.out.println("Case #" + (testCaseNumber++) + ": " + result.toString());
    }
}