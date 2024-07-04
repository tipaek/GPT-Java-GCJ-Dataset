import java.util.*;
import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
          String s = in.nextLine();
          String re = compute(s);
          System.out.println("Case #" + i + ": " + re);
        }
      }
      
      public static String compute(String s) {
          int open = 0;
          StringBuilder builder = new StringBuilder();
          for (int i = 0; i < s.length(); i++) {
              int val = s.charAt(i) - '0';
              for (;open > val; open--)
                builder.append(")");
              for (;open < val; open++)
                builder.append("(");
              builder.append(val);
          }
          for (;open > 0; open--)
                builder.append(")");
          return builder.toString();
      }
    }