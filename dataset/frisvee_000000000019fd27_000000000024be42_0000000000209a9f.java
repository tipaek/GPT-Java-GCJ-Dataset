import java.util.*;
import java.io.*;

public class Solution {
    private static String solve(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (Character c : s.toCharArray()) {
            int v = c - '0';

            for (int i = 0; i < v; i++) {
                Character last = stack.peekLast();
                if (Objects.equals(')', last)) {
                    stack.removeLast();
                } else {
                    stack.addLast('(');
                }
            }
            stack.addLast(c);
            for (int i = 0; i < v; i++) {
                stack.addLast(')');
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.parseInt(in.nextLine());

        for (int t = 1; t <= T; t++) {
            String s = in.nextLine();
            System.out.println("Case #" + t + ": " + solve(s));
        }

        in.close();
    }
}