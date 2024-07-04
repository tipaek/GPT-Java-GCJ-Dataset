import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      int[][] grid = new int[n][n];
      for(int row = 0; row < n; row++) {
          for(int col = 0; col < n; col++) {
              grid[row][col] = in.nextInt();
          }
          
      }
      process(i, grid, n);
    }
  }
  
  private static void process(int kase, int[][] grid, int n) {
      Set<Integer>[] rows = new HashSet[n];
      Set<Integer>[] cols = new HashSet[n];
      for(int i = 0; i < n; i++) {
          rows[i] = new HashSet<>();
          cols[i] = new HashSet<>();
      }
      Set<Integer> rSet = new HashSet<>(n);
      Set<Integer> cSet = new HashSet<>(n);
      int trace = 0;
      int num;
      for(int row = 0; row < n; row++) {
          for(int col = 0; col < n; col++) {
              num = grid[row][col];
              if(row == col) {
                  trace += num;
              }
              if(!rows[row].add(num)) {
                  rSet.add(row);
              }
              if(!cols[col].add(num)) {
                  cSet.add(col);
              }
          }
      }
      System.out.printf("Case #%d: %d %d %d\n", 
        kase, trace, rSet.size(), cSet.size());
  }
}