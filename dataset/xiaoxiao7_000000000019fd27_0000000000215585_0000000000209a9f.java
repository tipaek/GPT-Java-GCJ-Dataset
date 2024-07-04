import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int i = 1; i <= T; ++i) {
            String s = input.next();
            System.out.println("Case #" + i + ": " + solve(s));
        }
    }

    public static String solve(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int openPathCnt = 0;
        for (char ch : s.toCharArray()) {
            if (stack.isEmpty()) {
                for (int j = 0; j < ch - '0'; ++j) {
                    sb.append('(');
                }
                sb.append(ch);
                openPathCnt += ch - '0';
                stack.push(ch);
            } else {
                if (stack.peek() <= ch) {
                    int cnt = ch - stack.peek();
                    for (int j = 0; j < cnt; ++j) {
                        sb.append('(');
                    }
                    sb.append(ch);
                    openPathCnt += cnt;
                    stack.push(ch);
                } else {
                    int cnt = stack.peek() - ch;
                    for (int j = 0; j < cnt; ++j) {
                        sb.append(')');
                    }
                    sb.append(ch);
                    openPathCnt -= cnt;
                    stack.push(ch);
                }
            }
        }
        for (int j = 0; j < openPathCnt; ++j) {
            sb.append(')');
        }
        return sb.toString();
    }
}