import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String s = in.next();

            String result = build(s, 0, 0);

            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String build(String s, int min, int previousMin) {
        if (s.length() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        StringBuilder tmp = new StringBuilder();
        int nMin = 9;
        for (Character c : s.toCharArray()) {
            int currentNum = c - '0';
            if (nMin > currentNum && currentNum != min) {
                nMin = currentNum;
            }

            if (currentNum == min) {
                sb.append(build(tmp.toString(), nMin, min));
                sb.append(c);

                tmp = new StringBuilder();
                continue;
            }

            tmp.append(c);
        }

        if (tmp.toString().length() > 0) {
            sb.append(build(tmp.toString(), nMin, min));
        }

        for (int i = 0; i < min - previousMin; i++) {
            sb.insert(0, '(');
            sb.append(')');
        }

        return sb.toString();
    }
}