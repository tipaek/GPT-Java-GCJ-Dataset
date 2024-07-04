import java.util.*;
import java.io.*;

public class Solution {

  private static int[][] buildMatrix(int size, Scanner scanner) {
    int[][] matrix = new int[size][size];
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        matrix[i][j] = scanner.nextInt();
      }
    }
    return matrix;
  }

  private static void process(int testCaseNumber, int[][] matrix) {
    int size = matrix.length;
    int diagonalSum = 0;

    for (int i = 0; i < size; i++) {
      diagonalSum += matrix[i][i];
    }

    int targetSum = size * (size + 1) / 2;
    int duplicateRows = 0, duplicateColumns = 0;

    for (int i = 0; i < size; i++) {
      if (hasDuplicates(matrix[i])) {
        duplicateRows++;
      }
    }

    for (int j = 0; j < size; j++) {
      if (hasDuplicates(getColumn(matrix, j))) {
        duplicateColumns++;
      }
    }

    System.out.println("Case #" + testCaseNumber + ": " + diagonalSum + " " + duplicateRows + " " + duplicateColumns);
  }

  private static boolean hasDuplicates(int[] array) {
    boolean[] seen = new boolean[array.length];
    for (int num : array) {
      if (seen[num - 1]) {
        return true;
      }
      seen[num - 1] = true;
    }
    return false;
  }

  private static int[] getColumn(int[][] matrix, int columnIndex) {
    int size = matrix.length;
    int[] column = new int[size];
    for (int i = 0; i < size; i++) {
      column[i] = matrix[i][columnIndex];
    }
    return column;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int testCaseCount = scanner.nextInt();

    for (int i = 1; i <= testCaseCount; i++) {
      int size = scanner.nextInt();
      int[][] matrix = buildMatrix(size, scanner);
      process(i, matrix);
    }
  }
}