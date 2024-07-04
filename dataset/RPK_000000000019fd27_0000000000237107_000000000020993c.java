import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      int[][] a = new int[n][n];
      for (int j = 0; j < n; ++j) {
        for (int k = 0; k < n; ++k) {
            a[j][k] = in.nextInt();
        }
      }
      int r = 0;
      for (int j = 0; j < n; ++j) {
          boolean[] b = new boolean[n];
          for (int k = 0; k < n; ++k) {
              if(b[a[j][k] - 1]) {
                  ++r;
                  break;
              } else {
                  b[a[j][k] - 1] = true;
              }
          }
      }
      int c = 0;
      for (int j = 0; j < n; ++j) {
          boolean[] b = new boolean[n];
          for (int k = 0; k < n; ++k) {
              if(b[a[k][j] - 1]) {
                  ++c;
                  break;
              } else {
                  b[a[k][j] - 1] = true;
              }
          }
      }
      int tr = 0;
      for (int j = 0; j < n; ++j) {
          tr += a[j][j];
      }
      System.out.println("Case #" + i + ": " + tr + " " + r + " " + c);
    }
  }
}