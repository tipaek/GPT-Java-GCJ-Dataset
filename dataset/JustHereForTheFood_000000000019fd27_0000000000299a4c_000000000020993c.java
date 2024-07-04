import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int testCases = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= testCases; ++i) {
      int n = in.nextInt();

      int[][] matrix = readMatrix(in, n);
      int trace = trace(matrix, n);
      int repeatingRows = repeatingRows(matrix, n);
      int repeatingCols = repeatingCols(matrix, n);
      
      System.out.println("Case #" + i + ": " + trace + " " + repeatingRows + " " + repeatingCols);
    }
  }

  private static int[][] readMatrix(Scanner in, int n) {
  	int[][] matrix = new int[n][n];
  	for (int i=0; i < n; i++) {
  		for (int j=0; j < n; j++) {
  			matrix[i][j] = in.nextInt();
  		}
  	}

  	return matrix;
  }

  private static int trace(int[][] matrix, int n) {
    int sum = 0;
    for (int i=0;i<n;i++) {
      sum += matrix[i][i];
    }
    return sum;
  }

  private static int repeatingRows(int[][] matrix, int n) {
    int repeatingRows = 0;
    for (int row=0;row<n;row++) {
      if (rowRepeats(matrix[row])) {
        repeatingRows++;
      }
    }

    return repeatingRows;
  }

  private static boolean rowRepeats(int[] row) {
    Set<Integer> set = new HashSet<Integer>();
    for (int k : row) {
      if (set.contains(k)) return true; else set.add(k);
    }

    return false;
  }

  private static int repeatingCols(int[][] matrix, int n) {
    int repeatingCols = 0;
    for (int col=0;col<n;col++) {
      if (ColRepeats(matrix, n, col)) {
        repeatingCols++;
      }
    }

    return repeatingCols;
  }

  private static boolean ColRepeats(int[][] matrix, int n, int col) {
    Set<Integer> set = new HashSet<Integer>();
    for (int i=0; i < n; i++) {
      if (set.contains(matrix[i][col])) return true; else set.add(matrix[i][col]);
    }

    return false;
  }
}