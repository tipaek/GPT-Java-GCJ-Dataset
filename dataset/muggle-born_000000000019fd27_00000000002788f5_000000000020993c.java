import java.util.*;
import java.io.*;

public class Solution {

  private static void printMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        System.out.print(matrix[i][j]);
      }
      System.out.println();
    }
  }

  private static int getRepeatedRows(int n, int[][] matrix) {
    Set<Integer> row;
    int count = 0;
    for (int i = 0; i < n; i++) {
      row = new HashSet<Integer>();
      for (int j = 0; j < n; j++) {
        if (row.contains(matrix[i][j])){
          count++;
          break;
        }
        row.add(matrix[i][j]);
      }
    }
    return count;
  }

  private static int getRepeatedCols(int n, int[][] matrix) {
    Set<Integer> col;
    int count = 0;
    for (int i = 0; i < n; i++) {
      col = new HashSet<Integer>();
      for (int j = 0; j < n; j++) {
        if (col.contains(matrix[j][i])){
          count++;
          break;
        }
        col.add(matrix[j][i]);
      }
    }
    return count;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      // populate matrix
      int[][] matrix = new int[n][n];
      int k = 0; // matrix trace
      for (int r = 0; r < n; r++) {
        for (int c = 0; c < n; c++) {
          matrix[r][c] = in.nextInt();
          if (r == c) {
            k += matrix[r][c];
          }
        }
      }

      int rowsRepeated = getRepeatedRows(n, matrix);
      int colsRepeated = getRepeatedCols(n, matrix);
      
      String output = String.format("Case #%d: %d %d %d", i, k, rowsRepeated, colsRepeated);
      System.out.println(output);
    }
  }
} 