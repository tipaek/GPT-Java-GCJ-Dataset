import java.util.*;
import java.io.*;

public class Solution {

    private static String addLeftParen(String s, int numParen) {
        String addon = "";
        for (int i = 0; i < numParen; i++) {
            addon += "(";
        }
        return s + addon;
    }
    
    private static String addRightParen(String s, int numParen) {
        String addon = "";
        for (int i = 0; i < numParen; i++) {
            addon += ")";
        }
        return s + addon;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 1; i <= t; ++i) {
            String s = in.next();
            //System.out.println(s);
            int n = s.length();
            String res = "";
            
            int prev = 0;
            int cur = 0;
            int delta = 0;

            for (int j = 0; j < n; j++) {
                prev = cur;
                cur = Integer.parseInt("" + s.charAt(j));
                delta = cur - prev;
                
                if (delta > 0) {
                    res = addLeftParen(res, delta) + cur;
                }
                else if (delta == 0) {
                    res += cur;
                }
                else {
                    res = addRightParen(res, -delta) + cur;
                }
            }
            res = addRightParen(res, cur);

            System.out.println("Case #" + i + ": " + res);
        }

        in.close();
      }
    }