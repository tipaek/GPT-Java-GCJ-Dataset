/**
 * Created by oana on 4/5/20.
 */

import java.util.*;
import java.io.*;


public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String l = in.next();
            if (!l.isEmpty()) {
                String r = "";
                char[] chars = l.toCharArray();

                char cs = chars[0];
                int s = 0;
                for (int j = 0; j < chars.length; j++) {
                    if (chars[j] == cs) {
                        s++;
                    } else {
                        int np = Character.getNumericValue(cs);
                        for (int k = 0; k < np; k++) {
                            r = r + "(";
                        }

                        for (int k = 0; k < s; k++) {
                            r = r + cs;
                        }

                        for (int k = 0; k < np; k++) {
                            r = r + ")";
                        }
                        cs = chars[j];
                        s = 1;
                    }
                }
                int np = Character.getNumericValue(cs);
                for (int k = 0; k < np; k++) {
                    r = r + "(";
                }

                for (int k = 0; k < s; k++) {
                    r = r + cs;
                }

                for (int k = 0; k < np; k++) {
                    r = r + ")";
                }



                System.out.println("Case #" + i + ": " + r);
            }
        }
    }
}
