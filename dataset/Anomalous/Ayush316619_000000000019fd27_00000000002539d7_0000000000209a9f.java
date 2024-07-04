import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine().trim());

        for (int tc = 1; tc <= testCases; tc++) {
            String input = reader.readLine().trim();
            StringBuilder result = new StringBuilder();
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < input.length(); i++) {
                int currentDigit = input.charAt(i) - '0';

                if (stack.isEmpty() || stack.peek() != currentDigit) {
                    while (!stack.isEmpty() && stack.peek() > currentDigit) {
                        result.append(')');
                        stack.pop();
                    }
                    while (stack.isEmpty() || (!stack.isEmpty() && stack.peek() < currentDigit)) {
                        result.append('(');
                        stack.push(stack.isEmpty() ? 1 : stack.peek() + 1);
                    }
                }

                result.append(currentDigit);
            }

            while (!stack.isEmpty()) {
                result.append(')');
                stack.pop();
            }

            System.out.println("Case #" + tc + ": " + result.toString());
        }
    }
}