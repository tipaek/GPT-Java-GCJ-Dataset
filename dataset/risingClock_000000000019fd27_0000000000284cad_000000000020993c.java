import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      int trace = 0;
      int duplicate_row = 0;
      int duplicate_column = 0;
      int[][] matrix = new int[n][n];
      for (int j = 0; j < n; ++j) {
        int[] rowCount = new int[n];
        boolean duplicateRow = false;
          for (int k = 0; k < n; ++k) {
              int curr = in.nextInt();
              matrix[j][k] = curr;
              if (j == k) {
                trace += curr;
              }
              if (rowCount[curr - 1] == 0) {
                rowCount[curr - 1] = 1;
              } else {
                duplicateRow = true;
              }
          }
        if (duplicateRow) {
          duplicate_row++;
        }
      }
      for (int col = 0; col < n; col++) {
        int[] col_count = new int[n];
        boolean duplicateCol = false;
        for (int row = 0; row < n; row++) {
          if (col_count[matrix[row][col] - 1] == 0) {
            col_count[matrix[row][col] - 1]++;
          } else {
            duplicateCol = true;
          }
        }
        if (duplicateCol) {
          duplicate_column++;
        }
      }
      System.out.println("Case #" + i + ": " + trace + " " + duplicate_row + " " + duplicate_column);
    }
  }
}
