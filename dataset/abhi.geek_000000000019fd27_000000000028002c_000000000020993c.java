import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String input;
    int totalTestCases = -1, matrixSize = -1, rowCounter = 0, testCaseCounter = 1;
    int[][] matrix =  null;
    String[] tokens;

    input = scan.nextLine().trim();
    totalTestCases = totalTestCases == -1 ? Integer.parseInt(input) : totalTestCases;

    while (testCaseCounter <= totalTestCases && scan.hasNextLine()) {

      if(matrixSize == -1) {
        input = scan.nextLine().trim();
        matrixSize =  Integer.parseInt(input);
        matrix = new int[matrixSize][matrixSize];
      }

      if(totalTestCases != -1 && matrixSize != -1) {
        while (rowCounter < matrixSize) {
          input = scan.nextLine().trim();
          tokens = input.split(" ");
          for(int i = 0; i < matrixSize; i++) {
            matrix[rowCounter][i] = Integer.parseInt(tokens[i]);
          }
          ++rowCounter;
        }

        int[] result = evaluateMatrixForLatinMatrix(matrix);
        System.out.println("Case #" + testCaseCounter + ": " + result[0] + " " + result[1] + " " + result[2]);
      }
      matrixSize = -1;
      input = null;
      tokens = null;
      matrix = null;
      rowCounter = 0;
      ++testCaseCounter;
    }
  }

  private static int[] evaluateMatrixForLatinMatrix(int[][] inputMatrix) {
    int trace = 0, rowCounter = 0, columnCounter = 0;

    if(inputMatrix.length != 0) {
      int size = inputMatrix.length;
      boolean isRowDup = false, isColDup = false;

      for (int i = 0; i < size; i++) {
        int[] row = new int[inputMatrix.length];
        int[] column = new int[inputMatrix.length];
        trace += inputMatrix[i][i];

        for(int j = 0; j < size; j++) {
          if (row[inputMatrix[i][j] - 1] == 0) {
            row[inputMatrix[i][j] - 1] = row[inputMatrix[i][j] - 1] + 1;
          } else {
            isRowDup = true;
          }

          if (column[inputMatrix[j][i] - 1] == 0) {
            column[inputMatrix[j][i] - 1] = column[inputMatrix[j][i] - 1] + 1;
          } else {
            isColDup = true;
          }
        }

        if(isColDup) {
          ++columnCounter;
        }

        if(isRowDup) {
          ++rowCounter;
        }
        isColDup = false;
        isRowDup = false;
      }
    }

    return new int[]{trace, rowCounter, columnCounter};
  }
}