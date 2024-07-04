import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    final Scanner scanner = new Scanner(System.in);
    final int T = scanner.nextInt();

    for (int t = 1; t <= T; t++) {
      final String s = scanner.next();
      final StringBuilder result = new StringBuilder();

      int depth = 0;
      for (int i = 0; i < s.length(); i++) {
        int next = s.charAt(i) - '0';
        while (next > depth) {
          result.append('(');
          depth++;
        }
        while (next < depth) {
          result.append(')');
          depth--;
        }
        result.append(next);
      }

      while(depth > 0) {
        result.append(')');
        depth--;
      }

      System.out.println(String.format("Case #%d: %s", t, result));
    }
  }
}
