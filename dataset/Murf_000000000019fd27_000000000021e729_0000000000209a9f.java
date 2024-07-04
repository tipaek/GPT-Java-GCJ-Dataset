 import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          String s = in.next();
          
          String out = "";
          int openCount = 0;
          for( int j=0; j<s.length(); j++ ) {
            int v = s.charAt(j)-'0';
            while( v > openCount ) {
              out += "(";
              openCount++;
            }
            while( v < openCount ) {
                out += ")";
                openCount--;
            }
            out += v;
          }
          while( openCount > 0 ) {
              out += ")";
              openCount--;
          }
          System.out.println("Case #" + i + ": " + out);
        }
      }
    }