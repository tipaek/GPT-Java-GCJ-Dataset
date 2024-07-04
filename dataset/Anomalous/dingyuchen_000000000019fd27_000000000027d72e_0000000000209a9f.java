import java.util.Scanner;
import java.util.Stack;

public class Solution {
    private void solve(int testNo, String digits) {
        int length = digits.length();
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int currentDigit = Character.getNumericValue(digits.charAt(i));

            while (stack.size() < currentDigit) {
                stack.push('(');
                result.append('(');
            }

            while (stack.size() > currentDigit) {
                stack.pop();
                result.append(')');
            }

            result.append(currentDigit);
        }

        while (!stack.isEmpty()) {
            stack.pop();
            result.append(')');
        }

        System.out.printf("Case #%d: %s%n", testNo, result.toString());
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            String input = scanner.next();
            solve(i + 1, input);
        }

        scanner.close();
    }

    public static void main(String[] args) {
        new Solution().run();
    }
}