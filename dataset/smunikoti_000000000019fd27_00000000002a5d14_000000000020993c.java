import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GoogleJam {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int numTestCases = scanner.nextInt();

    for (int k = 0; k < numTestCases; k++) {
      int diaSum = 0;
      int matrixSize = scanner.nextInt();
      int[][] matrix = new int[matrixSize][matrixSize];

      for (int i = 0; i < matrixSize; i++) {
        for (int j = 0; j < matrixSize; j++) {
          matrix[i][j] = scanner.nextInt();
        }
      }


      for (int i = 0; i < matrixSize; i++) {
        diaSum += matrix[i][i];
      }

      System.out.print("Case #" + (k + 1) +": " + diaSum + " ");

      Set<Integer> row = new HashSet<>();
      Set<Integer> col = new HashSet<>();
      int numRows = 0;
      int numCols = 0;
      int totalRows = 0;
      int totlCols = 0;

      for (int i = 0; i < matrixSize; i++) {
        for (int j = 0; j < matrixSize; j++) {
          if (row.contains(matrix[i][j])) {
            numRows++;
          } else {
            row.add(matrix[i][j]);
          }

          if (col.contains(matrix[j][i])) {
            numCols++;
          } else {
            col.add(matrix[j][i]);
          }

        }

        if (numRows > 0) totalRows++;
        if (numCols > 0) totlCols++;

        col.clear();
        row.clear();
      }

      System.out.print(totalRows + " " + totlCols + "\n");

    }
  }
}
