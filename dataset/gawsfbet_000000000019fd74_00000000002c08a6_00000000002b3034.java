package gcj;

import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t0 = 1; t0 <= t; ++t0) {
            int n = in.nextInt();
            String[] patterns = new String[n];

            for (int i = 0; i < n; i++) {
                patterns[i] = in.next().replaceAll("\\*+", "\\*");
            }

            Arrays.sort(patterns, (String first, String second) -> {
                int i = first.length() - first.replace("*", "").length(), j = second.length() - second.replace("*", "").length();

                if (i == j) {
                    return second.length() - first.length();
                } else {
                    return i - j;
                }
            });

            String ans = patterns[0];
            for (int i = 1; i < patterns.length; i++) {
                ans = match(ans, patterns[i]);
            }

            if (ans.contains("-")) {
                System.out.println(String.format("Case #%d: *", t0));
            } else {
                System.out.println(String.format("Case #%d: %s", t0, ans.replace("*", "")));
            }
        }
    }

    public static String match(String pattern1, String pattern2) {
        if (pattern1.equals("") && pattern2.equals("")) {
            return "";
        } else {
            if (pattern1.equals("")) {
                return pattern2.equals("*") ? "*" : "-";
            } else if (pattern2.equals("")) {
                return pattern1.equals("*") ? "*" : "-";
            } else if (pattern1.equals("*")) {
                return pattern2;
            } else if (pattern2.equals("*")) {
                return pattern1;
            } else {
                char c1 = pattern1.charAt(pattern1.length() - 1), c2 = pattern2.charAt(pattern2.length() - 1);
                if (c1 != '*' && c2 != '*') {
                    if (c1 == c2) {
                        return match(pattern1.substring(0, pattern1.length() - 1), pattern2.substring(0, pattern2.length() - 1)) + pattern1.charAt(pattern1.length() - 1);
                    } else {
                        return "-";
                    }
                } else if (c1 == '*' && c2 != '*') {
                    String m = match(pattern1.substring(0, pattern1.length() - 1), pattern2.substring(0, pattern2.length() - 1));
                    return m.charAt(m.length() - 1) == '*' ? m + ("" + c2) + "*" : "*" + m + ("" + c2) + "*";
                } else if (c1 != '*' && c2 == '*') {
                    String m = match(pattern1.substring(0, pattern1.length() - 1), pattern2.substring(0, pattern2.length() - 1));
                    return m.charAt(m.length() - 1) == '*' ? m + ("" + c1) + "*" : "*" + m + ("" + c1) + "*";
                } else {
                    return match(pattern1.substring(0, pattern1.length() - 1), pattern2.substring(0, pattern2.length() - 1)) + "*";
                }
            }
        }
    }
}
