import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String s = in.next();
            StringBuilder sb = new StringBuilder(s);

            for (char d = '9'; d >= '1'; d--) {
                int start, end;
                for (int i1 = 0; i1 < sb.length(); i1++) {
                    if (isWithinRange(sb.charAt(i1), d)) {
                        start = i1;
                        end = i1;

                        while (end < sb.length() && isWithinRange(sb.charAt(end), d)) {
                            end++;
                        }

                        sb.insert(start, "(");
                        sb.insert(end + 1, ")");

                        i1 = end + 1;
                    }
                }
            }

            System.out.println(String.format("Case #%d: %s", i, sb.toString()));
        }
    }

    public static boolean isWithinRange(char c, char limit) {
        return (c == '(' || c == ')') || limit <= c;
    }
}