import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintStream out = System.out;
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int c = 1; c <= t; ++c) {
            String S = in.nextLine();
            int currentlyOpen = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < S.length(); i++) {
                int num = (S.charAt(i) - '0');
                appendTimes(sb, num - currentlyOpen, '(');
                appendTimes(sb, currentlyOpen - num, ')');
                sb.append(S.charAt(i));
                currentlyOpen = num;
            }
            appendTimes(sb, currentlyOpen, ')');

            out.println(String.format("Case #%d: %s", c, sb.toString()));
        }
    }

    static void appendTimes(StringBuilder sb, int times, char c) {
        for (int i = 0; i < times; i++)
            sb.append(c);
    }

}
