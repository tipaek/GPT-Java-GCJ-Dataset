//package Q2020.rount1A.pascal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[][] grid = buildPascal();
    int t = sc.nextInt();
    for (int tt = 1; tt <= t; tt++) {
      int N = sc.nextInt();
      List<Pair> path = new ArrayList<>();
      boolean[][] visited = new boolean[1000][1000];
      visited[0][0] = true;
      //path.add(new Pair(0,0));
      walk(grid, N, 0, 0, 1, path, visited);
      System.out.println("Case #" + tt + ":");
      System.out.println("1 1");
      for (int i = path.size() - 1 ; i >=0 ; i--) {
        System.out.println((path.get(i).i + 1) + " " + (path.get(i).j + 1));
      }
    }
    sc.close();
  }

  private static boolean walk(int[][] grid, int n, int x, int y, int sum, List<Pair> path, boolean[][] visited) {
    if (n == sum) {
     // path.add(new Pair(x, y));
      return true;
    }
    if( sum > n) {
      return false;
    }
    int[] dx = {-1, -1, 0, 0, 1, 1};
    int[] dy = {-1, 0, -1, 1, 0, 1};
    for (int i = 0; i < 6; i++) {
      int tx = x + dx[i];
      int ty = y + dy[i];
      if (validIndex(grid, tx, ty, n) && !visited[tx][ty]) {
        visited[tx][ty] = true;
        if(walk(grid, n, tx, ty, sum + grid[tx][ty], path, visited)) {
          path.add(new Pair(tx, ty));
          return true;
        }
        visited[tx][ty] = false;
      }
    }
    return false;
  }

  private static boolean validIndex(int[][] grid, int dx, int dy, int n) {
    if (dx < 0 || dx >= n || dy < 0 || dy > dx)
      return false;
    return true;
  }

  static class Pair {
    int i;
    int j;

    Pair(int i, int j) {
      this.i = i;
      this.j = j;
    }
  }

  private static int[][] buildPascal() {
    int[][] grid = new int[1000][1000];
    for (int i = 0; i < 1000; i++) {
      grid[i][0] = 1;
    }
    for (int i = 1; i < 1000; i++) {
      for (int j = 1; j <= i; j++) {
        grid[i][j] = grid[i - 1][j - 1] + grid[i - 1][j];
      }
    }
    return grid;
  }
}
