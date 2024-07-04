import java.util.Scanner;
import java.util.Stack;

//Nesting Depth
public class Solution {
    public static String solve(String s) {
        Stack<Character> stack = new Stack<>();
        int numOfOpen = 0, numOfClose = 0;

        for (int i = s.length()-1; i >= 0; --i) {
            char c = s.charAt(i);
            int depth = c - '0';
            int diff = numOfClose - numOfOpen;

            if (depth > diff) {
                for (int j = 0; j < depth - diff; ++j) {
                    stack.push(')');
                }
                numOfClose += depth - diff;
            } else if (depth < diff) {
                for (int j = 0; j < diff - depth; ++j) {
                    stack.push('(');
                }
                numOfOpen += diff - depth;
            }

            stack.push(c);
        }

        for (int i = 0; i < numOfClose - numOfOpen; ++i) {
            stack.push('(');
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        // System.out.println("num of case: " + t);
        for (int i = 1; i <= t; ++i) {
            String s = in.nextLine();

            String ans = solve(s);
            System.out.print(String.format("Case #%d: %s\n", i, ans));
        }
    }
}