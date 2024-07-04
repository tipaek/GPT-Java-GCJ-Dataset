import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      int[][] a = new int[n][n];
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < n; k++) {
          a[j][k] = in.nextInt();
        }
      }
      processMatrix(i,n, a);

    }
  }

  static void processMatrix(int testNum, int n, int[][] a) {
    int trace = 0;
    int r = 0;
    int c = 0;

    boolean tr[] = new boolean[n];
    for (int j = 0; j < n; j++) {
      Arrays.fill(tr, false);
      trace += a[j][j];
      for (int k = 0; k < n; k++ ) {
        if (tr[a[j][k] - 1]) {
          r++;
          break;
        }
        tr[a[j][k]-1] = true;
      }
    }

    for (int j = 0; j < n; j++) {
      Arrays.fill(tr, false);
      for (int k = 0; k < n; k++ ) {
        if (tr[a[k][j] - 1]) {
          c++;
          break;
        }
        tr[a[k][j] - 1] = true;
      }
    }
    System.out.println("Case #" + testNum + ": " + trace + " " + r + " " + c);
  }
}
