import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

  private static int[][] buildMatrix(int size, Scanner scanner) {
    int[][] matrix = new int[size][size];
    for (int row = 0; row < size; row++) {
      for (int col = 0; col < size; col++) {
        matrix[row][col] = scanner.nextInt();
      }
    }
    return matrix;
  }

  private static void process(int caseNumber, int[][] matrix) {
    int diagonalSum = 0;

    for (int i = 0; i < matrix.length; i++) {
      diagonalSum += matrix[i][i];
    }

    int expectedSum = 0;
    for (int i = 1; i <= matrix.length; i++) {
      expectedSum += i;
    }

    int duplicateRows = 0, duplicateCols = 0;

    for (int col = 0; col < matrix[0].length; col++) {
      boolean[] seen = new boolean[matrix.length];
      boolean hasDuplicate = false;
      for (int row = 0; row < matrix.length; row++) {
        int value = matrix[row][col];
        if (seen[value - 1]) hasDuplicate = true;
        seen[value - 1] = true;
      }
      if (hasDuplicate) duplicateCols++;
    }

    for (int row = 0; row < matrix.length; row++) {
      boolean[] seen = new boolean[matrix.length];
      boolean hasDuplicate = false;
      for (int col = 0; col < matrix[row].length; col++) {
        int value = matrix[row][col];
        if (seen[value - 1]) hasDuplicate = true;
        seen[value - 1] = true;
      }
      if (hasDuplicate) duplicateRows++;
    }

    System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + duplicateRows + " " + duplicateCols);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int totalCases = scanner.nextInt();

    for (int caseNumber = 1; caseNumber <= totalCases; caseNumber++) {
      int matrixSize = scanner.nextInt();
      int[][] matrix = buildMatrix(matrixSize, scanner);
      process(caseNumber, matrix);
    }
  }
}