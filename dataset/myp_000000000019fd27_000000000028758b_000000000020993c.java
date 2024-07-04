import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Solution {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int T = s.nextInt();
    for (int t = 1; t <= T; t++) {
      int n = s.nextInt();
      int[][] g = new int[n][n];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          g[i][j] = s.nextInt();
        }
      }

      int trace = 0;
      for (int i = 0; i < n; i++) {
        trace += g[i][i];
      }

      int row = 0;
      for (int i = 0; i < n; i++) {
        boolean[] f = new boolean[n];
        for (int j = 0; j < n; j++) {
          int idx = g[i][j] - 1;
          if (f[idx]) {
            row++;
            break;
          }
          f[idx] = true;
        }
      }

      int col = 0;
      for (int i = 0; i < n; i++) {
        boolean[] f = new boolean[n];
        for (int j = 0; j < n; j++) {
          int idx = g[j][i] - 1;
          if (f[idx]) {
            col++;
            break;
          }
          f[idx] = true;
        }
      }
      System.out.println(String.format("Case #%d: %d %d %d", t, trace, row, col));
    }
  }


}
