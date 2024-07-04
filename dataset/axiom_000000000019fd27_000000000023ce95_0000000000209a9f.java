import java.util.*;
import java.io.*;

// 2 Nesting Depth
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String s = in.next();
            String res = solve(s, 0);
            System.out.println("Case #" + i + ": " + res);
        }
    }

    private static String solve(String str, int addon) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (int k = 0; k < str.length(); k++) {
            char c = str.charAt(k);
            if (c == '0') {
                String sub = str.substring(i, k);
                String res = addParen(sub, addon);
                sb.append(res);
                while (k < str.length() && str.charAt(k) == '0') {
                    sb.append('0');
                    k++;
                }
                i = k;
            }
        }
        if (i != str.length()) {
            String sub = str.substring(i);
            String res = addParen(sub, addon);
            sb.append(res);
        }
        return sb.toString();
    }

    private static String addParen(String str, int addon) {
        if (str.length() == 0) {
            return "";
        }
        int bigIdx = 0;
        int big = 0;
        for (int i = 0; i < str.length(); i++) {
            int x = str.charAt(i) - '0';
            if (x > big) {
                big = x;
                bigIdx = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append((char) (big + addon + '0'));
        // left
        int left = big;
        for (int i = bigIdx - 1; i >= 0; i--) {
            char now = str.charAt(i);
            char prev = str.charAt(i + 1);
            if (now <= prev) {
                int j = 0;
                while (j < prev - now) {
                    sb.insert(0, '(');
                    j++;
                }
                sb.insert(0, (char) (now + addon));
                left = now - '0';
            } else {
                StringBuilder subSb = new StringBuilder();
                int j = i;
                while (j >= 0 && str.charAt(j) > prev) {
                    subSb.insert(0, (char) (str.charAt(j) - prev + '0'));
                    j--;
                }
                String sub = subSb.toString();
                String subRes = solve(sub, prev - '0');
                sb.insert(0, subRes);
                i = j;
            }
        }
        while (left > 0) {
            sb.insert(0, '(');
            left--;
        }

        // right
        int right = big;
        for (int i = bigIdx + 1; i < str.length(); i++) {
            char now = str.charAt(i);
            char prev = str.charAt(i - 1);
            if (now <= prev) {
                int j = 0;
                while (j < prev - now) {
                    sb.append(')');
                    j++;
                }
                sb.append((char) (now + addon));
                right = now - '0';
            } else {
                StringBuilder subSb = new StringBuilder();
                int j = i;
                while (j < str.length() && str.charAt(j) > prev) {
                    subSb.append((char) (str.charAt(j) - prev + '0'));
                    j++;
                }
                String sub = subSb.toString();
                String subRes = solve(sub, prev - '0');
                sb.append(subRes);
                i = j;
            }
        }
        while (right > 0) {
            sb.append(')');
            right--;
        }

        return sb.toString();
    }
}