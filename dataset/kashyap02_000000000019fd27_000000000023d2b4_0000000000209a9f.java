import java.util.Scanner;
import java.util.Stack;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            String s = sc.next();
            Stack<Character> stack = new Stack<>();
            String st = "";
            if (s.charAt(0) == '1') {
                stack.push('(');
                stack.push('1');
                for (int j = 1; j < s.length(); j++) {
                    if (s.charAt(j) == '0') {
                        if (s.charAt(j - 1) == '1')
                            stack.push(')');
                        stack.push('0');
                    } else {
                        if (s.charAt(j - 1) == '0') {
                            stack.push('(');
                            stack.push('1');
                        }
                        else
                            stack.push('1');
                    }
                }
                if (s.charAt(s.length() - 1) == '1')
                    stack.push(')');
            } else {
                stack.push('0');
                for (int j = 1; j < s.length(); j++) {
                    if (s.charAt(j) == '0') {
                        if (s.charAt(j - 1) == '1')
                            stack.push(')');
                        stack.push('0');
                    } else {
                        if (s.charAt(j - 1) == '0') {
                            stack.push('(');
                            stack.push('1');
                        }
                        else
                            stack.push('1');
                    }
                }
                if (s.charAt(s.length() - 1) == '1')
                    stack.push(')');
            }

            while (stack.empty() == false)
                st = stack.pop() + st;
            System.out.print("Case #" + i + ": " + st);
            System.out.println();
        }

    }
}

