import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
        int n = in.nextInt();
        int k = in.nextInt();
        process(i, n, k);
    }
  }
  private static Map<Integer, Set<Integer>> rows = new HashMap<>();
  private static Map<Integer, Set<Integer>> cols = new HashMap<>();
  private static int trace = 0;
  private static void process(int kase, int n, int k) {
      int[][] grid = new int[n][n];
      trace = k;
      rows = new HashMap<>();
      cols = new HashMap<>();
      fillMappings(n);
      boolean solved = solve(grid, 0, 0, n);
      if(solved) {
          String s = toString(grid, n);
          System.out.printf("Case #%d: POSSIBLE\n%s\n", kase, s);
      } else {
          System.out.printf("Case #%d: IMPOSSIBLE\n", kase);
      }
      
      
  }
  private static String toString(int[][] grid, int n) {
      StringJoiner sj = new StringJoiner("\n");
          for(int row = 0; row < n; row++) {
              StringJoiner sb = new StringJoiner(" ");
              for(int col = 0; col < n; col++) {
                  sb.add(String.valueOf(grid[row][col]));
              }
              sj.add(sb.toString());
          }
      return sj.toString();
  }
  private static void fillMappings(int n) {
      for(int i = 0; i < n; i++) {
          rows.put(i, new HashSet<>());
          cols.put(i, new HashSet<>());
      }
  }
  private static boolean solve(int[][] grid, int row, 
    int col, int n) {
      boolean solved = false;
      for(int i = 1; i <= n; i++) {
          if(isValid(i, row, col)) {
              grid[row][col] = i;
              addToMappings(i, row, col);
              if(col + 1 < n) {
                  solved = solve(grid, row, col+1, n);
              } else if(row + 1 < n) {
                  solved = solve(grid, row+1, 0, n);
              } else {
                  int tmp = 0;
                  for(int x = 0; x < n; x++) tmp += grid[x][x];
                  if(tmp == trace) solved = true;
              }
              if(solved) break;
              grid[row][col] = 0;
              removeFromMappings(i, row, col);
          }
      }
      return solved;
  }
  private static boolean isValid(int n, int row, int col) {
      return !rows.get(row).contains(n) 
        && !cols.get(col).contains(n);
  }
  private static void addToMappings(int n, int row, int col) {
      rows.get(row).add(n);
      cols.get(col).add(n);
  }
  private static void removeFromMappings(int n, int row, int col) {
      rows.get(row).remove(n);
      cols.get(col).remove(n);
  }
}