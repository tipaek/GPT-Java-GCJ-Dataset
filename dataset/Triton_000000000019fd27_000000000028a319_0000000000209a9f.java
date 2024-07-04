import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String s = in.next();
            String result = String.format("Case #%d: %s", i, sol.wrap(s));
            System.out.println(result);
        }
    }

    private String wrap(String s) {
        if (s.isEmpty()) {
            return "";
        }

        int n = s.length();
        String[] strs = new String[n];
        for (int i = 0; i < n; ++i) {
            strs[i] = wrap(s.charAt(i) - '0');
        }

        int step = 1;
        while (step < n) {
           for (int i = 0; i + step < n; i += step + 1) {
               strs[i] = merge(strs[i], strs[i + step]);
           }

           step <<= 1;
        }

        return strs[0];
    }

    private String wrap(int n) {
        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            left.append('(');
            right.append(')');
        }

        return left.toString() + n + right.toString();
    }

    private String merge(String left, String right) {
        int i = left.length() - 1, j = 0;
        while (i >= 0 && j < right.length()) {
            if (left.charAt(i) != ')' || right.charAt(j) != '(') {
                break;
            }

            --i;
            ++j;
        }

        return left.substring(0, i + 1) + right.substring(j);
    }
}