import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      String s = in.next();
      StringBuilder sb = new StringBuilder(s.length());
      int depth = 0;
      for (char c1 : s.toCharArray()) {
        int c = c1 - '0';
        if (depth > c) {
          for (int j = 0; j < depth - c; j++) {
            sb.append(')');
          }
          depth = c;
        }
        if (depth < c) {
          for (int j = 0; j < c - depth; j++) {
            sb.append('(');
          }
          depth = c;
        }
        sb.append(c1);
      }
      while (depth > 0) {
        sb.append(')');
        depth--;
      }
      System.out.println("Case #" + i + ": " + sb);
    }
  }
}
