import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();
        List<String> responses = new ArrayList<>();

        for (int i = 0; i < testCases; i++) {
            String input = scanner.nextLine();
            responses.add(processInput(input));
        }

        for (int i = 0; i < testCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + responses.get(i));
        }
    }

    private static String processInput(String input) {
        StringBuilder result = new StringBuilder();
        char[] digits = input.toCharArray();
        int length = digits.length;

        if (length == 1) {
            appendParentheses(result, Character.getNumericValue(digits[0]));
            result.append(digits[0]);
            appendParentheses(result, Character.getNumericValue(digits[0]));
        } else {
            for (int j = 0; j < length - 1; j++) {
                int current = Character.getNumericValue(digits[j]);
                int next = Character.getNumericValue(digits[j + 1]);

                if (j == 0) {
                    appendParentheses(result, current);
                    result.append(current);
                }

                if (current > next) {
                    appendParentheses(result, current - next, ')');
                    result.append(next);
                } else if (current < next) {
                    appendParentheses(result, next - current, '(');
                    result.append(next);
                } else {
                    result.append(next);
                }
            }
            appendParentheses(result, Character.getNumericValue(digits[length - 1]), ')');
        }

        return result.toString();
    }

    private static void appendParentheses(StringBuilder result, int count) {
        appendParentheses(result, count, '(');
    }

    private static void appendParentheses(StringBuilder result, int count, char parenthesis) {
        for (int i = 0; i < count; i++) {
            result.append(parenthesis);
        }
    }
}