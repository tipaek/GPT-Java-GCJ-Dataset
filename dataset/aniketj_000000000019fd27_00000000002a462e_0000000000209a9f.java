import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String s = in.nextLine();
            StringBuilder res = new StringBuilder();
            int open = 0;
            for (int j = 0; j < s.length(); ++j) {
               int digit = Integer.parseInt(String.valueOf(s.charAt(j)));
               if(open < digit) {
                   for(int k = 0; k < digit-open; ++k) {
                       res.append('(');
                       res.append(digit);
                       open++;
                   }
               } else if (open > digit) {
                   for(int k = 0; k < open-digit; ++k) {
                       res.append(')');
                       res.append(digit);
                       open--;
                   }
               } else {
                   res.append(digit);
               }
            }
            
            for(int k = 0; k < open; ++k) {
               res.append(')');
            }    
            
            System.out.println("Case #" + i + ": " + res.toString());
        }
      }
    }  