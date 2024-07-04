import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String S = in.next();
            String res = solve(S);
            System.out.println("Case #" + i + ": " + res);
        }
    }

    private static String solve(String S) {
        StringBuilder sb = new StringBuilder();
        int prev = 0;
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            int cur = Integer.parseInt( ch + "");
            if (prev == cur) {
                add(sb, ch, 1);
            } else if (prev < cur) {
                add(sb, '(', cur - prev);
                add(sb, ch, 1);
            } else {
                add(sb, ')', prev - cur);
                add(sb, ch, 1);
            }
            prev = cur;
        }
        add(sb, ')', prev);

        return sb.toString();
    }

    private static void add(StringBuilder sb, char ch, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(ch);
        }
    }
}
