import java.util.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();

    for (int t = 1; t < T; t++) {

      String s = in.next();
      StringBuilder sb = new StringBuilder();
      int depth = 0;

      for (int i = 0; i < s.length(); i++) {
        int v = s.charAt(i) - '0';

        if (v == depth)
          sb.append(v);
        else {
          // prepend opening braces
          while (depth < v) {
            sb.append("(");
            depth++;
          }
          while (depth > v) {
            sb.append(")");
            depth--;
          }
          sb.append(v);
        }
      }

      while (depth-- > 0)
        sb.append(")");
      System.out.printf("Case #%d: %s\n", t, sb.toString());
    }

    in.close();
  }
}