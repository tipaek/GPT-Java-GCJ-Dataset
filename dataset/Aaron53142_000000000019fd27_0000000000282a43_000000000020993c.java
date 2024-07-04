import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      int[][] grid = new int[n][n];
      setGrid(in, grid, n);
      int[] res = solve(grid, n);
      System.out.println("Case #" + i + ": " + res[0] + " " + res[1] + " " + res[2]);
    }
  }

  static void setGrid(Scanner in, int[][] grid, int n) {
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < n; j++) {
        grid[i][j] = in.nextInt();
      }
    }
  }

  static int[] solve(int[][] grid, int n) {
    int k = grid[0][0], r = 0, c = 0;
    // do row
    for(int i = 1; i < n; i++) {
      for(int j = 1; j < n; j++) {
        if(i == j) {
          k += grid[i][j];
        }
      }
    }
    Set<Integer> rowSet;
    for(int i = 0; i < n; i++) {
      rowSet = new HashSet<>();
      for (int j = 0; j < n; j++) {
        if (rowSet.contains(grid[i][j])) {
          r++;
          break;
        }
        rowSet.add(grid[i][j]);
      }
    }

    // do col
    Set<Integer> colSet;
    for(int i = 0; i < n; i++) {
      colSet = new HashSet<>();
      for(int j = 0; j < n; j++) {
        if(colSet.contains(grid[j][i])) {
          c++;
          break;
        }
        colSet.add(grid[j][i]);
      }
    }

    return new int[]{k, r, c};
  }
}