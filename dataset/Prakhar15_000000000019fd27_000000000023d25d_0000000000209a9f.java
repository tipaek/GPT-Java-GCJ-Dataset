// "static void main" must be defined in a public class.

    import java.util.*;
    import java.io.*;

    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          
            String input = in.next();
            StringBuffer out = new StringBuffer();
            int prevDigit = 0;
            
            for (int j = 0; j < input.length(); j++) {
                int d = Integer.parseInt(String.valueOf(input.charAt(j)));
                if (d > prevDigit) {
                    for (int k = 0; k < d-prevDigit; k++) {
                        out.append("(");
                    }
                } else if (d < prevDigit) {
                    for (int k = 0; k < prevDigit-d; k++) {
                        out.append(")");
                    }
                }
                
                out.append(d);
                prevDigit = d;
            }
            
            for (int k = 0; k < prevDigit; k++) {
                out.append(")");
            }
            
            System.out.println("Case #" + i + ": " + out.toString());
        }
      }
    }