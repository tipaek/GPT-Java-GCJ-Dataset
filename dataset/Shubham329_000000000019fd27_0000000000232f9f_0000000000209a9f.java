import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            sb.append("Case #").append(i + 1).append(": ");

            String str = sc.next();
            Stack<Character> stack = new Stack<>();

            for (char c : str.toCharArray()) {
                int v = (int) c - '0';
                if (stack.isEmpty()) {
                    push(stack, addParan(v, v));
                } else {
                    int cnt = 0;
                    StringBuilder temp = new StringBuilder();
                    while (v != 0 && stack.peek() == ')' && cnt < v) {
                        temp.append(stack.pop());
                        cnt++;
                    }
                    push(stack, addParan(v, (v - cnt)));
                    push(stack, temp.toString());
                }
            }

            String ans = "";
            while (!stack.isEmpty()) {
                ans = stack.pop() + ans;
            }
            sb.append(ans + "\n");
        }

        System.out.println(sb.toString());
    }

    private static String addParan(int n, int t) {
        StringBuilder s = new StringBuilder();
        StringBuilder l = new StringBuilder();

        for (int i = 0; i < t; i++) {
            s.append('(');
            l.append(')');
        }
        s.append(n);
        s.append(l);
        return s.toString();
    }

    private static void push(Stack<Character> stack, String str) {
        for (char c : str.toCharArray())
            stack.push(c);
    }
}
