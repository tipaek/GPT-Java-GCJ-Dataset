import java.util.*;
import java.io.*;
public class Solution {
    
    private static final char OPEN_PARENTHESIS = '(';
    private static final char CLOSE_PARENTHESIS = ')';

    private static String soln(String S) {
        StringBuilder sb = new StringBuilder();
        int nL = 0;
        if (S.charAt(0) != '0') {
            sb.append(OPEN_PARENTHESIS);
            nL = 1;
        }

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            int cVal = c - '0';
            if (cVal > nL) {
                int diff = cVal - nL;
                addParenthesis(sb, diff, OPEN_PARENTHESIS);
                nL += diff; // increase nesting level
            } else if (cVal < nL) {
                int diff = nL - cVal;
                addParenthesis(sb, diff, CLOSE_PARENTHESIS);
                nL -= diff; // decrease nesting level
            }
            sb.append(c);
            //            assert nL >= 0;
        }

        // close all opened parenthesis
        for (; nL > 0; nL--) {
            sb.append(CLOSE_PARENTHESIS);
        }

        //        assert nL == 0;
        return sb.toString();
    }

    private static void addParenthesis(StringBuilder sb, int num, char p) {
        for (int i = 0; i < num; i++) {
            sb.append(p);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String test = in.nextLine();
            System.out.println("Case #" + i + ": " + soln(test));
        }
    }
}