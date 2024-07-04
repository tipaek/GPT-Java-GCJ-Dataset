import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= t; i++) {
            String input = reader.readLine();
            System.out.println("Case #" + i + ": " + solve(input));
        }
    }

    static String solve(String input) {
        StringBuilder result = new StringBuilder();
        char[] arr = input.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (char c : arr) {
            int current = Character.getNumericValue(c);
            if (stack.isEmpty()) {
                appendChars(result, '(', current);
            } else {
                int previous = stack.peek();
                if (current > previous) {
                    appendChars(result, '(', current - previous);
                } else if (current < previous) {
                    appendChars(result, ')', previous - current);
                }
            }
            result.append(current);
            stack.push(current);
        }
        if (!stack.isEmpty()) {
            appendChars(result, ')', stack.pop());
        }
        return result.toString();
    }

    static void appendChars(StringBuilder sb, char ch, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(ch);
        }
    }
}