import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = Integer.parseInt(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      String s = in.nextLine();
      System.out.println("Case #" + i + ": " + generate(s));
    }
  }
  
  private static String generate(String s) {
    char[] c = s.toCharArray();
    int openToLeft = 0;
    StringBuilder sb = new StringBuilder();
    int unmatched = 0;
    for ( int i = 0; i < c.length; i++ ) {
       int d = c[i] - '0';
       if ( d > openToLeft ) {
         for ( int j = 0; j < d - openToLeft; j++ ) {
           sb.append("(");
           unmatched++;
         }
         sb.append(c[i]);
         openToLeft = d - openToLeft;
       } else if ( openToLeft > d ) {
           for ( int j = 0; j < openToLeft - d; j++ ) {
             sb.append(")");
             unmatched--;
           }
         sb.append(c[i]);
         openToLeft = d;
       } else {
         sb.append(c[i]);
       }
    }

    for ( int j = 0; j < unmatched; j++ ) {
      sb.append(")");
    }

    return sb.toString();
  }
}