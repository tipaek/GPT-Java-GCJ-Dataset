import java.util.*;
import java.io.*;

public class Solution {
  
  // Method to construct a matrix from input
  private static int[][] constructMatrix(int size, Scanner scanner) {
    int[][] matrix = new int[size][size];
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        matrix[i][j] = scanner.nextInt();
      }
    }
    return matrix;
  }

  // Method to process each test case
  private static void evaluateTestCase(int testCaseNumber, int[][] matrix) {
    int diagonalSum = 0;
    int matrixSize = matrix.length;

    // Calculate the sum of the main diagonal
    for (int i = 0; i < matrixSize; i++) {
      diagonalSum += matrix[i][i];
    }

    int expectedSum = matrixSize * (matrixSize + 1) / 2;
    int rowRepeats = 0, colRepeats = 0;

    // Check for repeated elements in columns
    for (int j = 0; j < matrixSize; j++) {
      boolean[] usedElements = new boolean[matrixSize];
      boolean hasRepeats = false;
      for (int i = 0; i < matrixSize; i++) {
        int value = matrix[i][j];
        if (usedElements[value - 1]) {
          hasRepeats = true;
        }
        usedElements[value - 1] = true;
      }
      if (hasRepeats) colRepeats++;
    }

    // Check for repeated elements in rows
    for (int i = 0; i < matrixSize; i++) {
      boolean[] usedElements = new boolean[matrixSize];
      boolean hasRepeats = false;
      for (int j = 0; j < matrixSize; j++) {
        int value = matrix[i][j];
        if (usedElements[value - 1]) {
          hasRepeats = true;
        }
        usedElements[value - 1] = true;
      }
      if (hasRepeats) rowRepeats++;
    }

    // Output the result for the current test case
    System.out.println("Case #" + testCaseNumber + ": " + diagonalSum + " " + rowRepeats + " " + colRepeats);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int numberOfTestCases = scanner.nextInt();

    for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
      int matrixSize = scanner.nextInt();
      int[][] matrix = constructMatrix(matrixSize, scanner);
      evaluateTestCase(testCase, matrix);
    }
  }
}