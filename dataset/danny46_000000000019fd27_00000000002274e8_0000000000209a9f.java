import java.io.*;
import java.util.*;
import java.math.*;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int x = 1; x <= t; ++x) {
            String S = in.next().trim();
            String res = solve(S);
            System.out.println("Case #" + x + ": " + res);
        }
    }

    public static String solve(String S) {
        int counter = 0;
        StringBuilder sb = new StringBuilder();

        int prev = 0;
        for(int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            int val = ch - '0';

            int inc = val - prev;

            if(inc > 0) {
                for(int x = 0; x < inc; x++) {
                    sb.append('(');
                }
            }

            if (inc < 0) {
                for(int x = 0; x > inc; x--) {
                    sb.append(')');
                }
            }

            counter += inc;
            sb.append(ch);

            prev = val;
        }

        while(counter != 0) {
            sb.append(')');
            counter--;
        }

        return sb.toString();
    }
}