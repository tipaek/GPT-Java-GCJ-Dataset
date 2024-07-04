import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(
                new BufferedReader(
                        new InputStreamReader(System.in)));
//        Scanner in = new Scanner(new File("input2.txt"));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int i = 1; i <= t; ++i) {
            String input = in.next();
            System.out.println("Case #" + i + ": " + process(input));
        }
    }

    private static String process(String input) {
        Stack<Character> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();

        for (int i = 0 ; i < input .length(); i++) {
            int number = input.charAt(i) - '0';
            if ( i > 0) {
                if (input.charAt(i-1) < input.charAt(i)) {
                    insertOpenParentheses(insertCloseParenthesesByNumber(number, stack), builder);
                } else if (input.charAt(i-1) > input.charAt(i)) {
                    appendUntilStackSize(number, builder, stack);
                }
            } else {
                insertOpenParentheses(number, builder);
                insertCloseParentheses(number, stack);
            }
            builder.append(number);
        }
        appendStackValues(builder, stack);

        return builder.toString();
    }

    private static void insertOpenParentheses(int number, StringBuilder builder) {
        for (int i = 0 ; i < number ; i++) {
            builder.append("(");
        }
    }

    private static void insertCloseParentheses(int number, Stack<Character> stack) {
        for (int i = 0 ; i < number ; i++) {
            stack.push(')');
        }
    }

    private static int insertCloseParenthesesByNumber(int number, Stack<Character> stack) {
        int count = 0;
        while (stack.size() < number) {
            stack.push(')');
            count++;
        }
        return count;
    }

    private static void appendStackValues(StringBuilder builder, Stack<Character> stack) {
        while (!stack.empty()) {
            builder.append(stack.pop());
        }
    }

    private static void appendUntilStackSize(int number, StringBuilder builder, Stack<Character> stack) {
        while (stack.size() > number) {
            builder.append(stack.pop());
        }
    }
}
