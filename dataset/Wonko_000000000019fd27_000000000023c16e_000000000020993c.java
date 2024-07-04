import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int tCase = 1; tCase <= t; ++tCase) {
      int n = in.nextInt();
      int[][] m = new int[n][n];
      for (int row = 0; row < n; ++row) {
        for (int col = 0; col < n; ++col) {
          m[row][col] = in.nextInt();
        }
      }
      int rowRepeats = 0, colRepeats = 0;
      for (int row = 0; row < n; ++row) {
        boolean[] check = new boolean[n];
        for (int col = 0; col < n; ++col) {
          if (check[m[row][col] - 1]) {
            rowRepeats++;
            break;
          }
          check[m[row][col] - 1] = true;
        }
      }

      for (int col = 0; col < n; ++col) {
        boolean[] check = new boolean[n];
        for (int row = 0; row < n; ++row) {
          if (check[m[row][col] - 1]) {
            colRepeats++;
            break;
          }
          check[m[row][col] - 1] = true;
        }
      }
      int trace = 0;
      for (int col = 0; col < n; ++col) {
        trace += m[col][col];
      }
      System.out.println("Case #" + tCase + ": " + trace + " " + rowRepeats + " " + colRepeats);
    }
  }
}
