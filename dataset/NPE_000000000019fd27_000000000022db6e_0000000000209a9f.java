import java.util.Scanner;
import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        scanner.nextLine();
        for (int l = 0; l < t; l++) {
            String s = scanner.nextLine();
            int n = s.length();
            StringBuilder str = new StringBuilder();

            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < n ; i++) {
                int x = s.charAt(i) - '0';
                for (int j = 0; j < x; j++) {
                    if (!stack.isEmpty() && stack.peek() == ')'){
                        stack.pop();
                    }
                    else stack.push('(');
                }
                stack.push(Character.forDigit(x, 10));
                for (int j = 0; j < x; j++) {
                    stack.push(')');
                }
            }

            int m = stack.size();
            for (int i = 0; i < m ; i++) {
                str.append(stack.pop());
            }

            System.out.printf("Case #%d: %s\n", l + 1, str.reverse());
        }
    }
}