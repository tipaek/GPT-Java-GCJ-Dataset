import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static String solve(int n, String[] sa) {
        for (int i = 0; i < n; i++) {
            sa[i] = new StringBuilder(sa[i].substring(1)).reverse().toString();
        }
        Arrays.sort(sa);
        for (int i = 0; i < n - 1; i++) {
            if (!sa[i+1].startsWith(sa[i])) return "*";
        }
        return new StringBuilder(sa[n-1]).reverse().toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner((System.in));
        int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int ks = 1; ks <= T; ++ks) {
            int n = in.nextInt();
            String[] strs = new String[n];
            for (int i = 0; i < n; i++) {
                strs[i] = in.next();
            }
            String s = solve(n, strs);
            System.out.println("Case #" + ks + ": " + s);
        }
    }
}