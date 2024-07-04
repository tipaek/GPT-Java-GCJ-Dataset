import java.io.*;
import java.util.*;

class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int tc = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int t = 1; t <= tc; t++) {
      int n = in.nextInt();
      int[][] grid = new int[n][2];
      for (int i = 0; i < n; i++) {
        grid[i][0] = in.nextInt();
        grid[i][1] = in.nextInt();
      }
      solve(t, grid);
    }
  }

  private static void solve(int t, int[][] grid) {
    Map<Integer, Character> assignMap = new HashMap<>();
    assign(grid, assignMap, 'C');
    assign(grid, assignMap, 'J');
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < grid.length; i++) {
      if(assignMap.containsKey(i)) {
        sb.append(assignMap.get(i));
      } else {
        System.out.println(String.format("Case #%s: %s", t, "IMPOSSIBLE"));
        return;
      }
    }
    System.out.println(String.format("Case #%s: %s", t, sb.toString()));
  }

  private static void assign(int[][] grid, Map<Integer, Character> assignMap, char c) {
    int max = 0, minDiff, minDiffIdx;
    boolean assigned = true;
    while (assigned) {
      minDiff = Integer.MAX_VALUE;
      minDiffIdx = -1;
      for (int i = 0; i < grid.length; i++) {
        if (!assignMap.containsKey(i)) {
          if (grid[i][0] >= max && grid[i][0] - max < minDiff) {
            minDiff = grid[i][0] - max;
            minDiffIdx = i;
          }
        }
      }
      if (minDiffIdx != -1) {
        assignMap.put(minDiffIdx, c);
        max = grid[minDiffIdx][1];
      } else {
        assigned = false;
      }
    }
  }
}