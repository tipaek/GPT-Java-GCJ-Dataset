import java.util.Scanner;

public class CodeJam2020_NestingDepth {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        for (int i = 1; i <= testCases; i++) {
            String s = sc.nextLine();
            System.out.println("Case #" + i + ": " + getBalancedParentheses(s));
        }
    }

    private static String getBalancedParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (char ch : s.toCharArray()) {
            int digit = ch - '0';

            // Add opening parentheses if needed
            while (currentDepth < digit) {
                result.append('(');
                currentDepth++;
            }

            // Add closing parentheses if needed
            while (currentDepth > digit) {
                result.append(')');
                currentDepth--;
            }

            // Append the current digit
            result.append(digit);
        }

        // Close any remaining open parentheses
        while (currentDepth > 0) {
            result.append(')');
            currentDepth--;
        }

        return result.toString();
    }
}