
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int testCases = in.nextInt();
    for (int i = 1; i <= testCases; ++i) {

      int matrixSize = in.nextInt();

      int rowCount = 0;
      int colCount = 0;

      int[][] matrix = new int[matrixSize][matrixSize];

      int traceOfTheMatrix = 0;

      Set<Integer> sumOfRow = new HashSet<>();

      for (int j = 0; j < matrixSize; j++) {
        for (int k = 0; k < matrixSize; k++) {
          int val = in.nextInt();
          if (j == k) {
            traceOfTheMatrix += val;
          }
          sumOfRow.add(val);
          matrix[j][k] = val;
        }
        if (sumOfRow.size() != matrixSize) {
          rowCount++;
        }
        sumOfRow.clear();
      }

      for (int y = 0; y < matrixSize; y++) {
        for (int x = 0; x < matrixSize; x++) {
          sumOfRow.add(matrix[x][y]);
        }
        if (sumOfRow.size() != matrixSize) {
          colCount++;
        }
        sumOfRow.clear();
      }

      System.out.println("Case #" + i + ": " + traceOfTheMatrix + " " + rowCount + " " + colCount);
    }
  }
}
