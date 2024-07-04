import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String temp = in.nextLine();
        int T = Character.getNumericValue(temp.charAt(0)); // Scanner has functions to read ints, longs, strings, chars, etc.
        System.out.println(T);
        for (int i = 1; i <= T; i++) {
            temp = in.nextLine();
            System.out.print("Case #" + i + ": ");
            addPar(temp);
            System.out.println("");
        }
    }
    public static void addPar(String S)
    {
        int p = 0, i = 0;
        String sub1 = "", sub2 = "";
        while (i < S.length())
        {
            int value = Character.getNumericValue(S.charAt(i));
            for (int close = 0, lim = p - value; close < lim; close++)
            {
                sub1 = S.substring(0, i);
                sub2 = S.substring(i);
                S = sub1 + ')' + sub2;
                System.out.print(")");
                p--;
                i++;
            }
            for (int j = p; j < value; j++)
            {
                sub1 = S.substring(0, i);
                sub2 = S.substring(i);
                S = sub1 + '(' + sub2;
                p++;
                i++;
                System.out.print("(");
            }
            i++;
            System.out.print(value);
        }
        for(int last = 0; last < p; last++)
        {
            S = S + ')';
            System.out.print(')');
        }
    }
}