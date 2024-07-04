import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            final String s = in.next();
            solve(t, s);
        }
    }

    private static void solve(final int T, final String s) {
        final StringBuilder r = new StringBuilder();
        int d = 0;
        final StringBuilder pending = new StringBuilder();
        for (char c : s.toCharArray()) {
            final int cur = c - '0';
            if (cur == d) {
                pending.append(c);
            } else if (cur < d) {
                r.append(pending.toString());
                pending.setLength(0);
                pending.append(c);
                for (int i = 0; i < d - cur; i ++) {
                    r.append(')');
                }
            } else {
                for (int i = 0; i < cur - d; i ++) {
                    pending.append('(');
                }
                pending.append(c);
            }
            d = cur;
        }
        r.append(pending.toString());
        for (int i = 0; i < d; i ++) {
            r.append(')');
        }
        System.out.printf("Case #%d: %s\n", T, r.toString());
    }
}