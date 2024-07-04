import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String digits = scanner.next();
            System.out.println("Case #" + caseNumber + ": " + processDigits(digits));
        }
    }

    private static String processDigits(String digits) {
        Stack<Character> stack = new Stack<>();
        stack.push(' ');

        for (char digitChar : digits.toCharArray()) {
            int digit = digitChar - '0';
            int closeParenthesesCount = 0;

            while (closeParenthesesCount < digit) {
                if (stack.peek() == ')') {
                    stack.pop();
                    closeParenthesesCount++;
                } else {
                    break;
                }
            }

            for (int i = 0; i < digit - closeParenthesesCount; i++) {
                stack.push('(');
            }

            stack.push(digitChar);

            for (int i = 0; i < digit; i++) {
                stack.push(')');
            }
        }

        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            if (ch == '(') {
                result.append(')');
            } else if (ch == ')') {
                result.append('(');
            } else {
                result.append(ch);
            }
        }

        return result.reverse().toString().trim();
    }
}