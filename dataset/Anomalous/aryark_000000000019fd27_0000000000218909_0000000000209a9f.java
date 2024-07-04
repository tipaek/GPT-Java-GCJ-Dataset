import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int t = 0; t < testCases; t++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int previousDigit = input.charAt(0) - '0';

            appendParentheses(result, previousDigit, true);
            result.append(previousDigit);

            int currentDepth = previousDigit;

            for (int i = 1; i < input.length(); i++) {
                int currentDigit = input.charAt(i) - '0';

                if (currentDigit > previousDigit) {
                    appendParentheses(result, currentDigit - currentDepth, true);
                    currentDepth = currentDigit;
                } else if (currentDigit < previousDigit) {
                    appendParentheses(result, currentDepth - currentDigit, false);
                    currentDepth = currentDigit;
                }

                result.append(currentDigit);
                previousDigit = currentDigit;
            }

            appendParentheses(result, currentDepth, false);
            System.out.println("Case #" + (t + 1) + ": " + result);
        }
    }

    private void appendParentheses(StringBuilder builder, int count, boolean open) {
        char parenthesis = open ? '(' : ')';
        for (int i = 0; i < count; i++) {
            builder.append(parenthesis);
        }
    }
}