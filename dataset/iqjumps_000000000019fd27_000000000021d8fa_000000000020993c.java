import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int t = 1; t <= T; ++t) {
      int n = in.nextInt();
      int[][] mat = new int[n][n];
      for (int i=0; i<n; i++) {
          for (int j=0; j<n; j++) {
              mat[i][j] = in.nextInt();
          }
      }
      
      System.out.println("Case #" + t + ": " + trace(mat) + " " + repeatedRows(mat) + " " + repeatedCols(mat));
    }
  }
  static int trace(int[][] mat) {
      int n = mat.length;
      int sum = 0;
      for (int i=0; i<n; i++) {
          sum += mat[i][i];
      }
      return sum;
  }
  static int repeatedRows(int[][] mat) {
      int n = mat.length;
      int cnt = 0;
      for (int i=0; i<n; i++) {
          boolean[] visited = new boolean[n+1];
          for (int j=0; j<n; j++) {
              if (visited[mat[i][j]]) {
                  cnt++;
                  break;
              }
              visited[mat[i][j]] = true;
          }
      }
      return cnt;
  }
  
  static int repeatedCols(int[][] mat) {
      int n = mat.length;
      int cnt = 0;
      for (int i=0; i<n; i++) {
          boolean[] visited = new boolean[n+1];
          for (int j=0; j<n; j++) {
              if (visited[mat[j][i]]) {
                  cnt++;
                  break;
              }
              visited[mat[j][i]] = true;
          }
      }
      return cnt;
  }
}
  