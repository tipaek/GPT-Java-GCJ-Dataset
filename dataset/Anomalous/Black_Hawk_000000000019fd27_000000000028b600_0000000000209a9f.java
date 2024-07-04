import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {

    static void add(String s) {
        Stack<Character> stack = new Stack<>();
        int digit, j;

        for (int i = s.length() - 1; i >= 0; i--) {
            digit = s.charAt(i) - '0';

            // Add closing parentheses
            for (j = 0; j < digit; j++) {
                if (!stack.empty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(')');
                }
            }

            stack.push(s.charAt(i));

            if (i > 0) {
                j = i - 1;
                int nextDigit = s.charAt(j) - '0';
                while (nextDigit == digit && j > 0) {
                    stack.push(s.charAt(j));
                    nextDigit = s.charAt(--j) - '0';
                }
                if (j == 0 && nextDigit == digit) {
                    stack.push(s.charAt(j));
                    i = -1;
                } else {
                    i = j + 1;
                }
            }

            // Add opening parentheses
            for (j = 0; j < digit; j++) {
                if (!stack.empty() && stack.peek() == ')') {
                    stack.pop();
                } else {
                    stack.push('(');
                }
            }
        }

        // Print the result
        while (!stack.empty()) {
            System.out.print(stack.pop());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(in.readLine().trim());
        String[] inputs = new String[t];

        for (int i = 0; i < t; i++) {
            inputs[i] = in.readLine().trim();
        }

        for (int i = 0; i < t; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            add(inputs[i]);
            System.out.println();
        }
    }
}