import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      String s = in.next();
      StringBuilder res = new StringBuilder();
      
      int depth = 0;
      for(int j=0; j<s.length(); j++) {
          int digit = Character.getNumericValue(s.charAt(j));
          while(depth > digit) {
              res.append(")");
              depth --;
          }
          while(depth < digit) {
              res.append("(");
              depth ++;
          }
          res.append(s.charAt(j));
      }
      
          while(depth > 0) {
              res.append(")");
              depth --;
          }
      
      
      System.out.println("Case #" + i + ": " + res.toString());
    }
  }
}