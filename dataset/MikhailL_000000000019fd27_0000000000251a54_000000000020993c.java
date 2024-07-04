import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    try (Scanner in = new Scanner((System.in))) {
      int t = in.nextInt();
      in.nextLine();
      for (int i = 1; i <= t; ++i) {
        int size = in.nextInt();
        int[][] matrix = new int[size][size];
        for (int j = 0; j < size; j++) {
          for (int k = 0; k < size; k++) {
            matrix[j][k] = in.nextInt();
          }
        }
        System.out.println(String.format("Case #%d: %d %d %d", i,
            trace(matrix), rows(matrix), columns(matrix)));
      }
    }
  }

  private static int columns(int[][] matrix) {
    int c = 0;
    int expected = matrix.length * (matrix.length + 1) / 2;
    for (int j = 0; j < matrix.length; j++) {
      int tmp = expected;
      for (int i = 0; i < matrix.length; i++) {
        tmp -= matrix[i][j];
      }
      if (tmp != 0) {
        c++;
      }
    }
    return c;
  }

  private static int rows(int[][] matrix) {
    int r = 0;
    int expected = matrix.length * (matrix.length + 1) / 2;
    for (int i = 0; i < matrix.length; i++) {
      int tmp = expected;
      for (int j = 0; j < matrix.length; j++) {
        tmp -= matrix[i][j];
      }
      if (tmp != 0) {
        r++;
      }
    }
    return r;
  }

  private static int trace(int[][] matrix) {
    int t = 0;
    for (int i = 0; i < matrix.length; i++) {
      t += matrix[i][i];
    }
    return t;
  }
}
