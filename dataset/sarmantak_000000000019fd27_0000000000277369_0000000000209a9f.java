import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int l = 1; l <= t; l++) {
            String line = in.next();
            solve(l, line);
        }
    }

    public static void solve(int t, String str) {
        char[] c = str.toCharArray();
        int o = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < c.length; i++) {
            if (i > 0 && c[i] == c[i - 1]) {
                res.append(c[i]);
                continue;
            }
            int d = c[i] - '0';
            char p = d > o ? '(' : ')';
            for (int j = 0; j < Math.abs(d - o); j++) {
                res.append(p);
            }
            res.append(c[i]);
            o += d - o;
        }
        for (int j = 0; j < o; j++) {
            res.append(')');
        }
        System.out.println(String.format("Case #%d: %s", t, res.toString()));
    }
}