import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    
    for (int i = 1; i <= t; ++i) {
      String input = in.next();
      String result = "";
      int brackets = 0;
      int latest = 0;
      
      for (char ch: input.toCharArray()) {
          int digit = (int)(ch-'0');
          int diff = digit - latest;
          latest = digit;
          
          String parenthesis = ")";
          if (diff > 0) parenthesis = "(";
          
          brackets += diff;
          int times_bracket = Math.abs(diff);
          for (int j=0; j<times_bracket; j++) {
            result += parenthesis;
          }
          
          result += ch;
      }
      
      for (int x=0; x<brackets; x++) {
          result += ")";
      }
      
      System.out.println("Case #" + i + ": " + result);
    }
  }
}