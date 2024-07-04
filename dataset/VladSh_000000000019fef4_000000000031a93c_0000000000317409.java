
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;

public class Solution {
  public static InputStream in = System.in;
  public static PrintStream out = System.out;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(in)));
    int t = scanner.nextInt();

    for (int k = 1; k <= t; ++k) {
      int x = scanner.nextInt();
      int y = scanner.nextInt();
      String s = scanner.next();
      out.println("Case #" + k + ": " + solve(x, y, s));
    }
  }

  public static String solve(int x, int y, String s) {
    Integer i = solve2(x, y, s);
    return i == null ? "IMPOSSIBLE" : i.toString();
  }

  static Integer solve2(int x, int y, String s) {
    int i = 0;
    int d = Math.abs(x) + Math.abs(y);
    char[] chs = s.toCharArray();
    if (d <= i) {
      return i;
    }

    while (i < s.length()) {
      char ch = chs[i];
      if (ch == 'S') {
        y--;
      } else if (ch == 'N') {
        y++;
      }
      d = Math.abs(x) + Math.abs(y);
      i++;
      if (d <= i) {
        return i;
      }
    }
    return null;
  }

  static class S {
    S() {}

    private String solve() {
      return "";
    }
  }
}
