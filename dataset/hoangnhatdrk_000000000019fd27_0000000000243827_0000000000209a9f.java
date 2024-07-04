import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String s = in.next();
            System.out.println("Case #"+i+": "+nestingDepth(s));
        }
    }

    private static String nestingDepth(String s) {
        StringBuilder sb = new StringBuilder();
        int curStack = 0;
        for (int i=1; i<=s.length(); i++) {
            int digit = Integer.parseInt(""+s.charAt(i-1));
            if (digit>=curStack) {
                for (int j=1; j<=(digit-curStack); j++) {
                    sb.append('(');
                }
            } else {
                for (int j=1; j<=(curStack-digit); j++) {
                    sb.append(')');
                }
            }
            curStack = digit;
            sb.append(digit);
        }
        for (int j=1; j<=curStack; j++) {
            sb.append(')');
        }
        return sb.toString();
    }
}