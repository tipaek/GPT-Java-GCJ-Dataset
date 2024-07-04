import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = Integer.parseInt(scanner.nextLine().trim());

            for (int i = 1; i <= testCases; i++) {
                String digitString = scanner.nextLine();
                String nestedString = createNestedString(digitString);
                System.out.println("Case #" + i + ": " + nestedString);
            }
        }
    }

    private static String createNestedString(String digitString) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (char digitChar : digitString.toCharArray()) {
            int digit = Character.getNumericValue(digitChar);
            int difference = digit - currentDepth;

            appendParentheses(result, difference);
            result.append(digitChar);

            currentDepth = digit;
        }

        appendParentheses(result, -currentDepth);

        return result.toString();
    }

    private static void appendParentheses(StringBuilder result, int count) {
        if (count > 0) {
            result.append("(".repeat(count));
        } else if (count < 0) {
            result.append(")".repeat(-count));
        }
    }
}