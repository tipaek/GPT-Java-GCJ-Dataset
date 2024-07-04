import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void solve(Scanner input, int ks, int n) {
//        System.err.println("size: " + n);
        Queue<char[]> patterns = new LinkedList<>();
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            String p = input.next();
            if (p.length() > maxLength) {
                maxLength = p.length();
            }
            patterns.add(p.toCharArray());
        }

        boolean success = true;
        Stack<Character> result = new Stack<>();
        for (int i = 1; i < maxLength; i++) {
            char c = reduce(patterns, i);
            if (c == '-') {
                success = false;
                break;
            } else {
                result.push(c);
                // System.err.println("idx:" + i + ",char:" + c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!result.isEmpty()) {
            sb.append(result.pop());
        }

        if (success) {
            System.out.println("Case #" + ks + ": " + sb.toString());
        } else {
            System.out.println("Case #" + ks + ": " + "*");
        }
    }

    static char reduce(Queue<char[]> patterns, int index) {
        char common = '*';
        for (char[] pattern : patterns) {
            int length = pattern.length;
            if (length > index) {
                char ch = pattern[length - index];
                if (ch != '*') {
                    if (common == '*') {
                        common = ch;
                    } else {
                        if (ch != common) {
                            return '-';
                        }
                    }
                }
            }
        }

        return common;
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            int n = input.nextInt();
            solve(input, ks, n);
        }
    }
}
