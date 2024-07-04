import java.util.Scanner;

public class Solution {

    private final Scanner scanner = new Scanner(System.in);

    private void solve() {
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int openParentheses = 0;

            for (int i = 0; i < input.length(); i++) {
                int currentDigit = input.charAt(i) - '0';
                while (openParentheses < currentDigit) {
                    result.append('(');
                    openParentheses++;
                }
                while (openParentheses > currentDigit) {
                    result.append(')');
                    openParentheses--;
                }
                result.append(input.charAt(i));
            }

            while (openParentheses > 0) {
                result.append(')');
                openParentheses--;
            }

            System.out.printf("Case #%d: %s%n", t, result.toString());
        }
    }

    public static void main(String[] args) {
        new Solution().solve();
    }
}