import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    // Number of test cases
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
      // Size of Matrix
      int n = in.nextInt();
      int[][] matrix = new int[n][n];
      int trace = 0;
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < n; k++) {
          matrix[j][k] = in.nextInt();
          if (j == k) {
            trace += matrix[j][k];
          }
        }
      }

      int rowCount = 0, colCount = 0;
      for (int j = 0; j < n; j++) {
        int[] rowFreq = new int[n];
        int[] colFreq = new int[n];
        boolean row = false, col = false;
        for (int k = 0; k < n; k++) {
          if (row && col) {
            break;
          }
          if (!row) {
            rowFreq[matrix[j][k] - 1]++;
            if (rowFreq[matrix[j][k] - 1] > 1) {
              row = true;
            }
          }
          if (!col) {
            colFreq[matrix[k][j] - 1]++;
            if (colFreq[matrix[k][j] - 1] > 1) {
              col = true;
            }
          }
        }
        if (row) {
          rowCount++;
        }
        if (col) {
          colCount++;
        }
      }

      System.out.println("Case #" + i + ": " + trace + " " + rowCount + " " + colCount);
    }
  }
}