import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int testCases = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= testCases; ++i) {
      int n = in.nextInt();
      int k = in.nextInt();

      if (tracePossible(n, k)) {
        System.out.println("Case #" + i + ": POSSIBLE");
        printMatrix(makeMatrix(n, k));
      } else {
        System.out.println("Case #" + i + ": IMPOSSIBLE");
      }
    }
  }

  private static boolean tracePossible(int n, int k) {
    return k % n == 0;
  }

  private static int[][] makeMatrix(int n, int k) {
    int[][] matrix = new int[n][n];
    int offset = (k / n) + n - 1;
    for (int i=0; i < n; i++) {
      for (int j=0; j < n; j++) {
        matrix[i][j] = (j + offset) % n + 1;
      }
      offset = (offset - 1);
    }

    return matrix;
  }

  private static void printMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }
}