import java.util.Scanner;

public class Solution {

    public static String solve(String s) {
        s = "0" + s + "0";
        StringBuilder sb = new StringBuilder();
        int prev = 0;
        for (char ch : s.toCharArray()) {
            int digit = ch - '0';
            if (digit > prev) {
                for (int j = 0; j < digit - prev; j++) sb.append('(');
            } else if (digit < prev) {
                for (int j = 0; j < prev - digit; j++) sb.append(')');

            }
            sb.append(digit);
            prev = digit;
        }
        return sb.toString().substring(1, sb.length() - 1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner((System.in));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String s = in.next();
            System.out.println("Case #" + i + ": " + solve(s));
        }
    }
}