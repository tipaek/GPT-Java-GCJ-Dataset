import java.util.*;
import java.io.*;

public class Solution {

  static Scanner s = new Scanner(System.in);
  static int max = 1000_000;

  public static void main(String[] args) {
    int T = s.nextInt();
    for (int t = 1; t <= T; t++) {
      int C = s.nextInt(), D = s.nextInt();
      int[] count = new int[C];
      for (int i = 1; i < C; i++) {
        count[i] = -s.nextInt() * 100;
      }
      int[][] grid = new int[C][C];


      List<List<Integer>> es = new ArrayList<List<Integer>>();
      for (int i = 0; i < D; i++) {
        int u = s.nextInt() - 1, v = s.nextInt() - 1;
        es.add(Arrays.asList(u, v));
        grid[u][v] = grid[v][u] = -1;
      }
      dfs(count, 0, grid, new boolean[C]);

      System.out.print(String.format("Case #%d:", t));
      for (List<Integer> e : es) {
        int ans = grid[e.get(0)][e.get(1)];
        if (ans == -1) {
          ans = max;
        }
        System.out.print(" " + ans);
      }
      System.out.println();
    }
  }

  private static void dfs(int[] count, int u, int[][] grid, boolean[] visited) {
    visited[u] = true;
    for (int v = 0; v < count.length; v++) {
      if (!visited[v] && grid[u][v] != 0 && count[u] < count[v]) {
        grid[u][v] = grid[v][u] = count[v] - count[u];
        dfs(count, v, grid, visited);
      }
    }
  }
}
