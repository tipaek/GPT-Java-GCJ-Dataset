import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            String digits = scanner.next();
            System.out.println("Case #" + i + ": " + solve(digits));
        }
    }

    public static String solve(String digits) {
        Stack<Character> stack = new Stack<>();
        stack.push(' ');

        for (char ch : digits.toCharArray()) {
            int num = ch - '0';
            int removedCount = 0;

            while (removedCount < num) {
                if (stack.peek() == ')') {
                    stack.pop();
                    removedCount++;
                } else {
                    break;
                }
            }

            for (int i = 0; i < num - removedCount; i++) {
                stack.push('(');
            }

            stack.push(ch);

            for (int i = 0; i < num; i++) {
                stack.push(')');
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 1; i < stack.size(); i++) {
            result.append(stack.get(i));
        }

        return result.toString();
    }
}