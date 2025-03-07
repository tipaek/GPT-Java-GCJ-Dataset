import java.util.*;
import java.io.*;

class Solution {
    public static String maxDepth(String S) {
        int n = S.length();
        int openCount = 0;
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int val = S.charAt(i) - '0';

            if (stack.isEmpty()) {
                for (int k = 0; k < val; k++) {
                    stack.push("(");
                    openCount++;
                }
                stack.push(String.valueOf(val));
                for (int k = val; k > 0; k--) {
                    stack.push(")");
                    openCount--;
                }
                continue;
            }

            while (!stack.isEmpty() && stack.peek().equals(")") && val > 0) {
                stack.pop();
                openCount++;
                val--;
            }

            if (val >= openCount) {
                for (int k = 0; k < val; k++) {
                    stack.push("(");
                    openCount++;
                }
            }

            stack.push(String.valueOf(S.charAt(i) - '0'));

            while (openCount > 0) {
                stack.push(")");
                openCount--;
            }
        }

        return stringify(stack);
    }

    private static String stringify(Stack<String> stack) {
        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            String S = scanner.next();
            System.out.println("Case #" + i + ": " + maxDepth(S));
        }
    }
}