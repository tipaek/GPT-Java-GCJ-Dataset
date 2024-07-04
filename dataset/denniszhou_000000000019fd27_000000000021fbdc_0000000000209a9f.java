import java.util.*;
import java.io.*;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = Integer.parseInt(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      StringBuilder sb = new StringBuilder();
      String s = in.nextLine();
      int open = 0;
      for (char c : s.toCharArray()) {
        int num = c - '0';
        if (num == open) {
          sb.append(c);
        } else if (num < open) {
          for (int j = open - num; j > 0; j--) {
            sb.append(')');
          }
          sb.append(c);
          open = num;
        } else {
          for (int j = num - open; j > 0; j--) {
            sb.append('(');
          }
          sb.append(c);
          open = num;
        }
      }

      for (int j = open; j > 0; j--) {
        sb.append(')');
      }

      System.out.println("Case #" + i + ": " + sb.toString());
    }
  }
}