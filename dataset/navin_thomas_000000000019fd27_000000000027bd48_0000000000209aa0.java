import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

  public static final String IMPOSSIBLE = "IMPOSSIBLE";

  public static final String POSSIBLE = "POSSIBLE";

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    // Number of test cases
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      int k = in.nextInt();

      if (k % n == 0 && k / n <= n) {
        System.out.println("Case #" + i + ": " + POSSIBLE);
        int[][] matrix = new int[n][n];
        int offset = n;
        for (int a = 0; a < n; a++) {
          int num = 1;
          for (int b = 0; b < n; b++) {
            matrix[a][(b + offset) % n] = num++;
          }
          offset--;
        }
        process(matrix, k, traceOfMatrix(matrix));
      } else {
        System.out.println("Case #" + i + ": " + IMPOSSIBLE);
      }
    }
  }

  private static void process(int[][] matrix, int k, int currTrace) {
    if (currTrace == k) {
      printMatrix(matrix);
    } else {
      for (int i = 0; i < matrix.length; i++) {
        for (int j = i + 1; j < matrix.length; j++) {
          int newTrace = currTrace + matrix[i][j] + matrix[j][i] - matrix[i][i] - matrix[j][j];
          if (((currTrace < k) && (currTrace < newTrace)) || ((currTrace > k) && (currTrace
              > newTrace))) {
            swapMatrixRows(matrix, i, j);
            process(matrix, k, newTrace);
          }
        }
      }
    }
  }

  private static void swapMatrixRows(int[][] matrix, int row1, int row2) {
    int[] t = matrix[row1];
    matrix[row1] = matrix[row2];
    matrix[row2] = t;
  }

  private static int traceOfMatrix(int[][] matrix) {
    int sum = 0;
    for (int i = 0; i < matrix.length; i++) {
      sum += matrix[i][i];
    }
    return sum;
  }

  private static void printMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }
}
