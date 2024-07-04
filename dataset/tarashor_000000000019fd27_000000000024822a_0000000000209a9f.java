
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String S = in.nextLine();
            System.out.println("Case #" + i + ": " + solve(S));
        }
        // write your code here
    }

    private static String solve(String S) {
        StringBuilder res = new StringBuilder();

        int prevV = 0;
        for (int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            int v = Character.getNumericValue(c);
            int numberOfParenthesis = v - prevV;
            char p = '(';
            if (numberOfParenthesis < 0) {
                p = ')';
            }
            res.append(parenthesis(p, Math.abs(numberOfParenthesis)));
            res.append(c);
            prevV = v;
        }

        res.append(parenthesis(')', prevV));

        return  res.toString();
    }

    private static char[] parenthesis(char c, int numberOfParenthesis) {
        char[] parenthesis = new char[numberOfParenthesis];
        for (int i = 0; i < numberOfParenthesis; i++){
            parenthesis[i] = c;
        }
        return parenthesis;
    }
}
