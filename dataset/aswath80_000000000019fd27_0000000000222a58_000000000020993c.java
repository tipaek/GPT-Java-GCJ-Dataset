import java.util.*;
import java.io.*;

class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int tc = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int t = 1; t <= tc; t++) {
      int n = in.nextInt();
      int[][] grid = new int[n][n];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          grid[i][j] = in.nextInt();
        }
      }
      solve(t, grid, n);
    }
  }

  private static void solve(int t, int[][] grid, int n) {
    int sum = 0;
    int rd = 0;
    int cd = 0;
    Set<Integer> visited = new HashSet<>();
    for (int d = 0; d < n; d++) {
      sum += grid[d][d];
      visited.clear();
      for (int i = 0; i < n; i++) {
        if (!visited.add(grid[d][i])) {
          rd++;
          break;
        }
      }
      visited.clear();
      for (int j = 0; j < n; j++) {
        if (!visited.add(grid[j][d])) {
          cd++;
          break;
        }
      }
    }
    System.out.println(String.format("Case #%s: %s %s %s", t, sum, rd, cd));
  }
}