import java.util.*;
import java.io.*;

public class Solution {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int T = s.nextInt();
    s.nextLine();
    for (int t = 1; t <= T; t++) {
      String line = s.nextLine();
      StringBuilder sb = new StringBuilder();
      int prev = 0;
      for (char ch : line.toCharArray()) {
        int cur = ch - '0';
        while (prev < cur) {
          sb.append('(');
          prev++;
        }
        while (prev > cur) {
          sb.append(')');
          prev--;
        }
        sb.append(ch);
      }
      while (prev > 0) {
        sb.append(')');
        prev--;
      }
      System.out.println(String.format("Case #%d: %s", t, sb.toString()));
    }
  }
}
