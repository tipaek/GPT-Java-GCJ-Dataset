import java.util.*;
import java.io.*;

// Qualification Round 2020: Problem B - Nesting Depth
//
public class Solution {
    public static String solve(String digits) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0, len = digits.length(); i <= len; i++) {
            int top = stack.peek();
            int cur = (i < len) ? (digits.charAt(i) - '0') : 0;
            if (cur == top) {
                sb.append(cur);
            } else if (cur > top) {
                for (int j = cur - top; j > 0; j--) {
                    sb.append('(');
                }
                sb.append(cur);
                stack.push(cur);
            } else {
                int count = stack.pop();
                int top2 = stack.peek();
                for (; ; ) {
                    sb.append(')');
                    if (--top == top2) {
                        i--;
                        break;
                    }
                    if (top == cur) {
                        stack.push(top);
                        sb.append(cur);
                        break;
                    }
                }
            }
        }
        return sb.substring(0, sb.length() - 1);
    }

    public static void main(String[] args) {
        Scanner in =
            new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintStream out = System.out;
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            out.format("Case #%d: ", i);
            printResult(in, out);
        }
    }

    private static void printResult(Scanner in, PrintStream out) {
        String res = solve(in.next());
        out.println(res);
    }
}