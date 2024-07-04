import java.util.*;
import java.io.*;

public class Solution {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int T = s.nextInt();
    for (int t = 1; t <= T; t++) {
      int n = s.nextInt();
      int[][] e = new int[n][2];
      for (int i = 0; i < n; i++) {
        e[i][0] = s.nextInt();
        e[i][1] = s.nextInt();
      }
      int[] ans = new int[n];
      boolean success = true;
      for (int i = 0; i < n; i++) {
        if (ans[i] == 0 && !dfs(i, e, ans, 1)) {
          success = false;
          break;
        }
      }
      StringBuilder sb = new StringBuilder();
      if (success) {
        for (int flag : ans) {
          if (flag == 1) {
            sb.append('C');
          } else {
            sb.append('J');
          }
        }
      } else {
        sb.append("IMPOSSIBLE");
      }
      System.out.println(String.format("Case #%d: %s", t, sb.toString()));
    }
  }

  private static boolean dfs(int u, int[][] e, int[] ans, int flag) {
    ans[u] = flag;
    for (int v = 0; v < ans.length; v++) {
      if (v != u && intersect(e[u], e[v])) {
        if (ans[v] == flag) {
          return false;
        }
        if (ans[v] == 0 && !dfs(v, e, ans, -flag)) {
          return false;
        }
      }
    }
    return true;
  }

  private static boolean intersect(int[] a, int[] b) {
    return !(a[1] <= b[0] || b[1] <= a[0]);
  }
}
