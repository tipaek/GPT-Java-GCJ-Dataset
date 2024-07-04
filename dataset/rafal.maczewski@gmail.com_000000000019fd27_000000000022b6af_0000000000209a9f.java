import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            solve(i, in);
        }
    }

    private static void solve(int caseNr, Scanner in) {

        String s = in.next();
        s = s.trim();

        StringBuffer out = new StringBuffer();
        int prevValue = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int value = c - '0';
            if (value > prevValue) {
                int diff = value - prevValue;
                for (int j = 0; j < diff; j++) {
                    out.append('(');
                }
            } else if (value < prevValue) {
                int diff = prevValue - value;
                for (int j = 0; j < diff; j++) {
                    out.append(')');
                }
            }
            out.append(c);
            prevValue = value;
        }
        for (int j = 0; j < prevValue; j++) {
            out.append(')');
        }

        System.out.println("Case #" + caseNr + ": " + out);

    }
}