import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < testCases; i++) {
                String input = scanner.nextLine();
                processTestCase(i + 1, input);
            }
        }
    }

    private static void processTestCase(int testCaseNumber, String input) {
        int[] digits = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            digits[i] = Character.getNumericValue(input.charAt(i));
        }
        String result = generateParenthesesString(digits);
        System.out.printf("Case #%d: %s%n", testCaseNumber, result);
    }

    private static String generateParenthesesString(int[] digits) {
        StringBuilder result = new StringBuilder();
        Queue<String> parenthesesQueue = new ArrayDeque<>();
        String OPEN_PARENTHESIS = "(";
        String CLOSE_PARENTHESIS = ")";

        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == 0) {
                flushQueue(result, parenthesesQueue);
                result.append(0);
            } else {
                if (parenthesesQueue.isEmpty()) {
                    appendParentheses(result, parenthesesQueue, digits[i], OPEN_PARENTHESIS, CLOSE_PARENTHESIS);
                    result.append(digits[i]);
                } else if (digits[i] < digits[i - 1]) {
                    removeParentheses(result, parenthesesQueue, digits[i - 1] - digits[i]);
                    result.append(digits[i]);
                } else if (digits[i] > digits[i - 1]) {
                    appendParentheses(result, parenthesesQueue, digits[i] - digits[i - 1], OPEN_PARENTHESIS, CLOSE_PARENTHESIS);
                    result.append(digits[i]);
                } else {
                    result.append(digits[i]);
                }
            }
        }

        flushQueue(result, parenthesesQueue);
        return result.toString();
    }

    private static void appendParentheses(StringBuilder result, Queue<String> parenthesesQueue, int count, String open, String close) {
        for (int j = 0; j < count; j++) {
            result.append(open);
            parenthesesQueue.add(close);
        }
    }

    private static void removeParentheses(StringBuilder result, Queue<String> parenthesesQueue, int count) {
        for (int j = 0; j < count; j++) {
            result.append(parenthesesQueue.poll());
        }
    }

    private static void flushQueue(StringBuilder result, Queue<String> parenthesesQueue) {
        while (!parenthesesQueue.isEmpty()) {
            result.append(parenthesesQueue.poll());
        }
    }
}