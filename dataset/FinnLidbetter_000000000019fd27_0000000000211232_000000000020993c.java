/**
 * @author Finn Lidbetter
 */
import java.util.*;
import java.io.*;
import java.awt.geom.*;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
  
    int nTests = Integer.parseInt(br.readLine());
    for (int test=0; test<nTests; test++) {
      int n = Integer.parseInt(br.readLine());
      int[][] grid = new int[n][n];
      for (int r=0; r<n; r++) {
        String[] s = br.readLine().split(" ");
        for (int c=0; c<n; c++) {
          grid[r][c] = Integer.parseInt(s[c]);
        }
      }
      int trace = 0;
      for (int i=0; i<n; i++) {
        trace += grid[i][i];
      }
      int numRows = 0;
      for (int r=0; r<n; r++) {
        HashSet<Integer> vals = new HashSet<>();
        for (int c=0; c<n; c++) {
          vals.add(grid[r][c]);
        }
        if (vals.size()!=n) {
          numRows++;
        }
      }
      int numCols = 0;
      for (int c=0; c<n; c++) {
        HashSet<Integer> vals = new HashSet<>();
        for (int r=0; r<n; r++) {
          vals.add(grid[r][c]);
        }
        if (vals.size()!=n) {
          numCols++;
        }
      }
      sb.append(String.format("Case #%d: %d %d %d\n", test+1, trace, numRows, numCols));
    }
    System.out.print(sb);
  }
}
