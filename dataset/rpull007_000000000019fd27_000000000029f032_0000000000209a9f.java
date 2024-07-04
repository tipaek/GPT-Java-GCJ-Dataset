import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author RP
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        // For each test case
        for (int i = 1; i <= t; ++i) {
            String s = in.next();
            System.out.println("Case #" + i + ": " + solve(s));
        }

    }

    public static String solve(String s) {
        String result = "";
        int nestLevel = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer digit = Integer.parseInt(String.valueOf(s.charAt(i)));

            if (digit == nestLevel) {
                result = result.concat(digit.toString());
            } else if (digit < nestLevel) {
                result = result.concat(insertParens(digit, nestLevel, ")"));
                result = result.concat(digit.toString());
                nestLevel = digit;
            } else if (digit > nestLevel) {
                result = result.concat(insertParens(digit, nestLevel, "("));
                result = result.concat(digit.toString());
                nestLevel = digit;
            }

            if (i == (s.length() - 1) && nestLevel > 0) {
                result = result.concat(insertParens(0, nestLevel, ")"));
                nestLevel = 0;
            }

        }
        return result;
    }

    public static String insertParens(int digit, int nestLevel, String paren) {
        String result = new String();
        String parens = paren;
        int num = Math.abs(nestLevel - digit);
        for (int i = 0; i < num; i++) {
            result = result.concat(parens);
        }
        return result;
    }

}