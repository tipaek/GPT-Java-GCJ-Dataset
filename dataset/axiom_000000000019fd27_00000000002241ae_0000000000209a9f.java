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
                sb.append(res).append('0');
                i = k + 1;
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
//        int bigIdx = 0;
//        int big = 0;
//        for (int i = 0; i < str.length(); i++) {
//            int x = str.charAt(i) - '0';
//            if (x > big) {
//                big = x;
//                bigIdx = i;
//            }
//        }
//        StringBuilder sb = new StringBuilder();
//        sb.append((big + addon + '0'));
//        // left
//        for (int i = bigIdx - 1; i > 0; i--) {
//            char now = str.charAt(i);
//            char next = str.charAt(i - 1);
//            if (now >= next) {
//                int j = 0;
//                while (j < big - now) {
//
//                }
//            }
//        }
//        // right
//        for (int j = bigIdx + 1; j < str.length(); j++) {
//
//        }
//
//        return sb.toString();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append("(");
        }
        sb.append(str);
        for (int i = 0; i < str.length(); i++) {
            sb.append(")");
        }
        return sb.toString();
    }
}