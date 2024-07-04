import java.util.*;
import java.io.*;

public class Solution {
  private static void trace(int[][] matrix, int N, int t) {
    int repeatRow = 0, repeatCol = 0, sum = 0;
    for (int i = 0; i < N; ++i) {
      sum += matrix[i][i];
    }
    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < N; ++i) {
      set.clear();
      for (int j = 0; j < N; ++j) {
        if (set.contains(matrix[i][j])) {
          ++repeatRow;
          break;
        }
        set.add(matrix[i][j]);
      }
    }
    for (int i = 0; i < N; ++i) {
      set.clear();
      for (int j = 0; j < N; ++j) {
        if (set.contains(matrix[j][i])) {
          ++repeatCol;
          break;
        }
        set.add(matrix[j][i]);
      }
    }

    System.out.println("Case #" + t + ": " + sum + " " + repeatRow  + " " + repeatCol);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int cases = scanner.nextInt();
    for (int t = 1; t <= cases; ++t) {
      int N = scanner.nextInt();
      int[][] matrix = new int[N][N];
      for (int i = 0; i < N; ++i) {
        for (int j = 0; j < N; ++j) {
          matrix[i][j] = scanner.nextInt();
        }
      }
      trace(matrix, N, t);
    }
  }
}
