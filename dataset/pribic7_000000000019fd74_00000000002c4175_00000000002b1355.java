//package Q2020.rount1A.dancing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for (int tt = 1; tt <= t; tt++) {
      int R = sc.nextInt();
      int C = sc.nextInt();
      int[][] grid = new int[R][C];
      for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
          grid[i][j] = sc.nextInt();
        }
      }
      long ans = solve(grid);
      System.out.println("Case #"+tt+": " + ans);
      
    }
    sc.close();
  }

  private static long solve(int[][] grid) {
    long total = 0;
    int R = grid.length;
    int C = grid[0].length;
    while (true) {
      total += sum(grid);
      boolean flag = false;
      boolean[][] markForDelete = new boolean[R][C];
      for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
          
          int[] dx = { -1, 1, 0 , 0};
          int[] dy = {0 ,0, -1, 1};
          int validN = 0;
          long ns = 0;
          for(int jj = 0; jj < 4; jj++) {
            int nskill = findNeiSkill(grid, i, j, dx[jj], dy[jj]);
            if(nskill != -1) {
              validN++;
              ns += nskill;
            }
          }
          if(validN > 0 && (validN * grid[i][j] < ns)) {
            markForDelete[i][j] = true;
          }
        }
      }
      for (int ii = 0; ii < R; ii++) {
        for (int jj = 0; jj < C; jj++) {
          if (markForDelete[ii][jj]) {
            grid[ii][jj] = -1;
            flag = true;
          }
        }
      }
      if(!flag)
        break;
    }
    return total;
  }

  private static int findNeiSkill(int[][] grid, int i, int j, int dx, int dy) {
    if(grid[i][j] == -1)
      return -1;
    while (true) {
      int tx = i + dx;
      int ty = j + dy;
      try {
        int xx = grid[tx][ty];
        if(xx != 0 && xx != -1) {
          return xx;
        }
        i = tx;
        j = ty;
      } catch (ArrayIndexOutOfBoundsException ar) {
        return -1;
      }
    }
  }

  private static long sum(int[][] grid) {
    int R = grid.length;
    int C = grid[0].length;
    long sum = 0;
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if(grid[i][j] != -1) {
          sum += grid[i][j];
        }
      }
    }
    return sum;
  }

  private static boolean walk(int[][] grid, int n, int x, int y, int sum, List<Pair> path, boolean[][] visited, int depth) {
    if (n == sum) {
     // path.add(new Pair(x, y));
      return true;
    }
    if( sum > n || depth > 502) {
      return false;
    }
    int[] dx = {-1, -1, 0, 0, 1, 1};
    int[] dy = {-1, 0, -1, 1, 0, 1};
    for (int i = 0; i < 6; i++) {
      int tx = x + dx[i];
      int ty = y + dy[i];
      if (validIndex(grid, tx, ty, n) && !visited[tx][ty]) {
        visited[tx][ty] = true;
        if(walk(grid, n, tx, ty, sum + grid[tx][ty], path, visited, depth + 1)) {
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
}
