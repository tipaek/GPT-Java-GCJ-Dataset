import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        String[] results = new String[t];

        for (int i = 0; i < t; ++i) {
            String input = in.next();
            results[i] = processInput(input);
        }

        for (int i = 0; i < t; ++i) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }
    }

    private static String processInput(String input) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        int length = input.length();

        for (int j = 0; j < length; j++) {
            int currentDigit = Character.getNumericValue(input.charAt(j));

            if (currentDigit > 0) {
                if (stack.isEmpty()) {
                    stack.push(currentDigit);
                    appendCharacters(result, '(', currentDigit);
                    result.append(currentDigit);
                } else {
                    int top = stack.peek();
                    if (top > currentDigit) {
                        stack.pop();
                        stack.push(currentDigit);
                        appendCharacters(result, ')', top - currentDigit);
                        result.append(currentDigit);
                    } else if (currentDigit > top) {
                        stack.pop();
                        stack.push(currentDigit);
                        appendCharacters(result, '(', currentDigit - top);
                        result.append(currentDigit);
                    } else {
                        result.append(currentDigit);
                    }
                }
            } else {
                closeAllOpenParentheses(stack, result);
                result.append('0');
            }
        }

        closeAllOpenParentheses(stack, result);
        return result.toString();
    }

    private static void appendCharacters(StringBuilder sb, char ch, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(ch);
        }
    }

    private static void closeAllOpenParentheses(Stack<Integer> stack, StringBuilder sb) {
        while (!stack.isEmpty()) {
            int top = stack.pop();
            appendCharacters(sb, ')', top);
        }
    }
}