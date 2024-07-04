
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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
    Set<Integer> unique = new HashSet<>();
    for (int j = 0; j < matrix.length; j++) {
      for (int i = 0; i < matrix.length; i++) {
        unique.add(matrix[i][j]);
      }

      if (unique.size() != matrix.length) {
        c++;
      }
      unique.clear();
    }
    return c;
  }

  private static int rows(int[][] matrix) {
    int r = 0;
    Set<Integer> unique = new HashSet<>();
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        unique.add(matrix[i][j]);
      }

      if (unique.size() != matrix.length) {
        r++;
      }
      unique.clear();
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
