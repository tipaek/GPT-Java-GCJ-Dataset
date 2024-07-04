import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int k = 1; k <= t; ++k) {
            String s = in.next();
            System.out.println( "Case #" + k + ": " + solve(in, s));
        }
    }

    private static String solve (Scanner in, String s) {

        String res = new String();
        int len = s.length();

        int toOpen = 0;
        int opened = 0;
        Integer current;


        for (int i=0; i<len; i++) {
            current = Integer.parseInt(String.valueOf(s.charAt(i)));
            toOpen = current - opened;

            if(toOpen > 0) {
                for (int j=0; j<toOpen; j++) {
                    res = res.concat("(");
                    opened++;
                }
                res = res.concat(current.toString());
            }  else if (toOpen < 0) {
                for (int j=0; j<(-toOpen); j++) {
                    res = res.concat(")");
                    opened--;
                }
                res = res.concat(current.toString());

            } else {
                res = res.concat(current.toString());
            }
        }

        for (int i=0; i<opened; i++) {
            res = res.concat(")");
        }

        return res;
    }


}

