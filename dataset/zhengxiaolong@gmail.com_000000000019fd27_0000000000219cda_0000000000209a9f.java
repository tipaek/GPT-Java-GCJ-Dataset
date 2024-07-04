import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            String next = in.next();
            StringBuilder sb = new StringBuilder();

            for (char c : next.toCharArray()) {
                int val = c - '0';
                for (int left = 0; left < val; ++left) {
                    sb.append("(");
                }
                sb.append(val);
                for (int right = 0; right < val; ++right) {
                    sb.append(")");
                }
            }


            Stack<Character> stack = new Stack<>();
            for (char c : sb.toString().toCharArray()) {
                if (!stack.isEmpty() && stack.peek() == ')' && c == '(') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }

            StringBuilder ans = new StringBuilder();
            while (!stack.isEmpty()) {
                ans.append(stack.pop());
            }

            String output = String.format("Case #%d: %s", i, ans.reverse().toString());
            System.out.println(output);
        }
    }
}