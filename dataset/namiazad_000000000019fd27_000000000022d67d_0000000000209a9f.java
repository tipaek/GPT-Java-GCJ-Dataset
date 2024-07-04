import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    private static String nested(String s) {
        int p = 0;

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int digit = Character.getNumericValue(s.charAt(i));

            int toBeInserted = digit - p;
            if (toBeInserted > 0) {
                for (int t = 0; t < toBeInserted; t++) {
                    result.append('(');
                }
            }

            if (toBeInserted < 0) {
                for (int t = toBeInserted; t < 0; t++) {
                    result.append(')');
                }
            }

            result.append(digit);

            p += toBeInserted;
        }

        for (int i = 0; i < p; i++) {
            result.append(')');
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine().trim()); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int testCase = 1; testCase <= t; ++testCase) {
            String s = in.nextLine().trim();
            System.out.println(String.format("Case #%d: %s", testCase, nested(s)));
        }
    }
}
