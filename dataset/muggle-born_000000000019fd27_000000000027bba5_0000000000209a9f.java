import java.util.*;
import java.io.*;

public class Solution {

  private static String nestingDepth(String s) {
    StringBuilder sb = new StringBuilder();
    int prev = 0;
    for (int i = 0; i < s.length(); i++) {
        int curr = Integer.valueOf(s.substring(i,i+1));
        if (curr > prev) {
            int diff = curr-prev;
            for (int k = 0; k < diff; k++) {
                sb.append('(');
            }
        } else if (curr < prev) {
            int diff = prev-curr;
            for (int k = 0; k < diff; k++) {
                sb.append(')');  
            }
        }
        sb.append(s.charAt(i));
        prev = curr;
    }

    for (int i = 0; i < prev; i++) {
        sb.append(')');
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = Integer.valueOf(in.nextLine());  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      String s = in.nextLine();
      String result = nestingDepth(s);
      
      String output = String.format("Case #%d: %s", i, result);
    //   System.out.println(s);
      System.out.println(output);
    }
  }
} 