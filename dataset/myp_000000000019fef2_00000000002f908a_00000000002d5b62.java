import java.util.*;
import java.io.*;

public class Solution {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int T = s.nextInt();
    s.nextLine();
    for (int t = 1; t <= T; t++) {
      int x = s.nextInt(), y = s.nextInt();
      ans = null;
      dfs(0, 0, 0, x, y, new StringBuilder());
      if (ans == null) ans = "IMPOSSIBLE";
      System.out.println(String.format("Case #%d: %s", t, ans));
    }
  }

  private static String ans;

  private static void dfs(int curX, int curY, int step, int x, int y, StringBuilder sb) {
    if (curX == x && curY == y) {
      if (ans == null || ans.length() > sb.length()) {
        ans = sb.toString();
      }
    } else if (step <= 10) {
      sb.append('E');
      dfs(curX + (1 << step), curY, step + 1, x, y, sb);
      sb.setLength(sb.length() - 1);

      sb.append('W');
      dfs(curX - (1 << step), curY, step + 1, x, y, sb);
      sb.setLength(sb.length() - 1);

      sb.append('N');
      dfs(curX, curY + (1 << step), step + 1, x, y, sb);
      sb.setLength(sb.length() - 1);

      sb.append('S');
      dfs(curX, curY - (1 << step), step + 1, x, y, sb);
      sb.setLength(sb.length() - 1);
    }
  }
}
