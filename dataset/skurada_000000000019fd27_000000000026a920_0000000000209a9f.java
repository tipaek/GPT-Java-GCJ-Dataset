import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String n = in.next();

            String result = solve(n);
            System.out.println("Case #" + i + ": " + (result));
        }
    }

    private static String solve(String s) {
        StringBuilder sb = new StringBuilder();

        int curDepth = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            int num = Character.getNumericValue(c);

            if (num == curDepth) {
                sb.append(c);
            }

            else if (num > curDepth) {
                // we need to add the number of parenthesis that are missing
                int missingParens = num - curDepth;

                for (int j = 0; j < missingParens; j++) {
                    sb.append('(');
                }

                sb.append(c);

                curDepth=num;
            }

            else {
                // we need to remove the number of parenthesis that are extra
                int extraParens = curDepth - num;

                for (int j = 0; j < extraParens; j++) {
                    sb.append(')');
                }

                sb.append(c);

                curDepth=num;
            }
        }

        if (curDepth > 0) {
            for (int j = 0; j < curDepth; j++) {
                sb.append(')');
            }
        }

        return sb.toString();
    }
}