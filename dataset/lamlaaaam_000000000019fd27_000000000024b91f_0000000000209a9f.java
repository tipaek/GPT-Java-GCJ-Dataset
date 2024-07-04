import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      String s = in.nextLine();
      StringBuilder sb = new StringBuilder();
      int open = 0;
      for (int k = 0; k < s.length(); ++k) {
        char c = s.charAt(k);
        int n = c - 48;
        int diff = n - open;
        if (diff > 0) {
          for (int d = 0; d < diff; ++d) {
            sb.append('(');
          }
          sb.append(c);
          open += diff;
        } else if (diff < 0) {
          for (int d = 0; d > diff; --d) {
            sb.append(')');
          }
          sb.append(c);
          open += diff;
        } else {
          sb.append(c);
        }
      }
      for (int p = 0; p < open; ++p) {
        sb.append(')');
      }
      System.out.println("Case #" + i + ": " + sb.toString());
    }
  }
}