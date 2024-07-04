import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {

    private static void add(String s) {
        Stack<Character> stack = new Stack<>();
        int digit, j;

        for (int i = s.length() - 1; i >= 0; i--) {
            digit = s.charAt(i) - '0';

            if (digit != 0) {
                for (j = 0; j < digit; j++) {
                    stack.push(')');
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

                for (j = 0; j < digit; j++) {
                    stack.push('(');
                }
            } else {
                stack.push('0');
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine().trim());
        String[] inputs = new String[t];

        for (int i = 0; i < t; i++) {
            inputs[i] = reader.readLine().trim();
        }

        for (int i = 0; i < t; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            add(inputs[i]);
            System.out.println();
        }
    }
}