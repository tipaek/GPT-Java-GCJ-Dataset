import java.util.*;
import java.io.*;

public class Solution {
    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        int testCase = Integer.parseInt (br.readLine());
        for (int t = 1; t <= testCase; t ++ ) {
            String line = br.readLine().trim();
            System.out.printf ("Case #%d: %s\n", t, evaluate (line));
        }
    }

    public static String evaluate (String str) {
        String ans = "0";
        int maxP = 0;
        int maxD = 0;

        for (int i = 0; i < str.length(); i ++) {
            if (str.charAt(i) == '0') {
                if (ans.charAt(maxP) == '0') {
                    //System.out.println ("unexpected");
                    ans += "0";
                    maxP += 1;
                    maxD = 0;
                } else {
                    //System.out.println (ans.charAt(maxP) + "--");
                    ans += "0";
                    maxP = maxP + Character.getNumericValue(ans.charAt(maxP)) + 1;
                    maxD = 0;
                    //System.out.println ("expected" + maxP);

                } 
            }

            else if (Character.getNumericValue(str.charAt(i)) > maxD) {
                int diff = Character.getNumericValue(str.charAt(i)) - maxD;
                ans = insertInto (ans, maxP, surround (str.charAt(i), diff));
                //System.out.println (ans + "--" + diff);
                maxP += diff + 1;
                maxD = Character.getNumericValue(str.charAt(i));
            }

            else if (Character.getNumericValue(str.charAt(i)) < maxD) {
                int right = countFromRight (ans, Character.getNumericValue(str.charAt(i)));
                if (right == 0) {
                    System.out.println ("Error, no closing parens");
                }
                ans = insertInto (ans, right - 1, String.valueOf (str.charAt(i)));
                maxD = Character.getNumericValue(str.charAt(i));
                maxP = right;
            } else {
                ans = insertInto (ans, maxP, String.valueOf(str.charAt(i)));
                maxP += 1;
            }
        }

        return ans.substring (1, ans.length());
    }
    public static int countFromRight (String str, int times) {
        int count = 0;
        for (int i = str.length()-1; i > 0; i --) {
            if (str.charAt(i) ==')') count ++;
            if (count == times) return i;
        }

        return 0;
    }
    public static String insertInto (String str, int pos, String ch) {
        String ans = str.substring (0, pos + 1) + ch + str.substring(pos + 1, str.length());
        return ans;
    }

    public static String surround (char c, int times) {
        String ans = "" + c;
        int n = times;
        while (n -- > 0) {
            ans = "(" + ans;
            ans = ans + ")"; 
        }

        return ans;
    }
}

/* 4
0000
101
111000
1 */