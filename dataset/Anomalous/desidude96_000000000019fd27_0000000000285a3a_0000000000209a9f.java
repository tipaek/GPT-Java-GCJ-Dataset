import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();
        for (int i = 0; i < numberOfCases; i++) {
            String input = scanner.next();
            String result = formatWithParentheses(input);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static String formatWithParentheses(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        int currentOpenParens = 0;

        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            
            // Add opening parentheses if needed
            while (currentOpenParens < digit) {
                result.append("(");
                currentOpenParens++;
            }
            
            // Add closing parentheses if needed
            while (currentOpenParens > digit) {
                result.append(")");
                currentOpenParens--;
            }

            // Add the current digit
            result.append(digit);
        }

        // Close any remaining open parentheses
        while (currentOpenParens > 0) {
            result.append(")");
            currentOpenParens--;
        }

        return result.toString();
    }
}