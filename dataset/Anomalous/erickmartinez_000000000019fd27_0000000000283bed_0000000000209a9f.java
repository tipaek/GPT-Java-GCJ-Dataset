import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        String[] matrix = new String[t];

        for (int i = 0; i < t; i++) {
            matrix[i] = scanner.next();
        }

        for (int i = 0; i < t; i++) {
            validateString(matrix[i], i);
        }
    }

    public static void validateString(String input, int testCase) {
        Stack<String> stack = new Stack<>();
        char currentChar = input.charAt(0);
        int currentNum = Character.getNumericValue(currentChar);
        insertParentheses("(", currentNum, stack);
        stack.push(String.valueOf(currentChar));

        for (int i = 1; i < input.length(); i++) {
            char nextChar = input.charAt(i);
            int nextNum = Character.getNumericValue(nextChar);
            int difference = nextNum - currentNum;

            if (difference > 0) {
                insertParentheses("(", difference, stack);
            } else if (difference < 0) {
                insertParentheses(")", -difference, stack);
            }

            stack.push(String.valueOf(nextChar));
            currentNum = nextNum;
        }

        insertParentheses(")", currentNum, stack);

        StringBuilder output = new StringBuilder();
        while (!stack.isEmpty()) {
            output.insert(0, stack.pop());
        }

        System.out.println("Case #" + (testCase + 1) + ": " + output);
    }

    private static void insertParentheses(String parenthesis, int count, Stack<String> stack) {
        for (int i = 0; i < count; i++) {
            stack.push(parenthesis);
        }
    }
}