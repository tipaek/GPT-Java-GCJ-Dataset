import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            String input = scanner.next();
            String result = addParentheses(input);
            System.out.println("Case #" + caseNumber + ": " + result);
            caseNumber++;
        }
    }

    public static String addParentheses(String input) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (char digitChar : input.toCharArray()) {
            int digit = digitChar - '0';
            int depthChange = digit - currentDepth;

            if (depthChange > 0) {
                result.append("(".repeat(depthChange));
                currentDepth = digit;
            } else if (depthChange < 0) {
                result.append(")".repeat(-depthChange));
                currentDepth = digit;
            }

            result.append(digitChar);
        }

        result.append(")".repeat(currentDepth));
        return result.toString();
    }
}