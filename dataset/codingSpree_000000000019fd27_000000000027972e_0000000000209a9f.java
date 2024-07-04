import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
        String input = in.next();
        String s = getMimimumNestingDepthString(input);
        System.out.println("Case #" + i + ": " + s);
    }
  }
  
  public static String getMimimumNestingDepthString(String input) {
      StringBuilder sb = new StringBuilder();
      int prev = 0;
      for (int i = 0; i < input.length(); i++) {
          int curr = (int)(input.charAt(i) - '0');
          if (curr < prev) {
              //Add closing brackets till the diff
              for (int k = curr; k < prev; k++) {
                  sb.append(")");
              }
            //   sb.append(curr);
          } else if (curr > prev) {
              //Add opening brackets till the diff
              for (int k = prev; k < curr; k++) {
                  sb.append("(");
              }
            //   sb.append(curr);
          }
          sb.append(curr);
          prev = curr;
      }
      for (int i = 0; i < prev; i++) {
          sb.append(")");
      }
      return sb.toString();
  }
}