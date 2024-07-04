import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String temp = in.nextLine();
        int T = Character.getNumericValue(temp.charAt(0)); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= T; i++) {
            temp = in.nextLine();
            System.out.println("Case #" + i + ": " + addPar(temp));
        }
    }
    public static String addPar(String S)
    {
        int p = 0, i = 0, len = S.length();
        String sub1 = "", sub2 = "";
        while (i < len)
        {
            int value = Character.getNumericValue(S.charAt(i));
            for (int close = 0, lim = p - value; close < lim; close++)
            {
                //System.out.print(")");
                sub1 = S.substring(0, i);
                sub2 = S.substring(i);
                S = sub1 + ')' + sub2;
                p--;
                len++;
                i++;
            }
            for (int j = p; j < value; j++)
            {
                sub1 = S.substring(0, i);
                sub2 = S.substring(i);
                S = sub1 + '(' + sub2;
                p++;
                len++;
                i++;
                //System.out.print("(");
            }
            i++;
            System.out.print(value);
        }
        for(int last = 0; last < p; last++)
        {
            S = S + ')';
            //System.out.print(')');
        }
        //System.out.println("");
        return S;
    }
}