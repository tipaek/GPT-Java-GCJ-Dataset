
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Adedayo Ominiyi
 */
public class Solution {

  public static void main(String[] args) throws Exception {
    try (Scanner scanner = new Scanner(
            new BufferedReader(new InputStreamReader(System.in)));) {
      final int numberOfTestCases = Integer.parseInt(scanner.nextLine());

      for (int testCase = 0; testCase < numberOfTestCases; testCase++) {
        final int matrixSize = Integer.parseInt(scanner.nextLine());

        int trace = 0;
        int duplicateRows = 0;
        int duplicateColumns = 0;
        final boolean[] rowAlreadyCounted = new boolean[matrixSize];
        final int[][] matrix = new int[matrixSize][matrixSize];
        
        final boolean[] columnAlreadyCounted = new boolean[matrixSize];
        final Map<Integer, Set<Integer>> numbersSeenInColumn = new HashMap<>();
        for (int matrixColumn = 0; matrixColumn < matrixSize;
                  matrixColumn++) {
          numbersSeenInColumn.put(matrixColumn, new HashSet<Integer>());
        }
        for (int matrixRow = 0; matrixRow < matrixSize; matrixRow++) {
          final Set<Integer> numbersSeenInRow = new HashSet<>();
          final String[] lineParts = scanner.nextLine().split(" ");
          for (int matrixColumn = 0; matrixColumn < lineParts.length;
                  matrixColumn++) {
            matrix[matrixRow][matrixColumn] = Integer.parseInt(
                    lineParts[matrixColumn]);

            if (matrixRow == matrixColumn) {
              trace = trace + matrix[matrixRow][matrixColumn];
            }

            if (!rowAlreadyCounted[matrixRow] 
                    && numbersSeenInRow.contains(matrix[matrixRow][matrixColumn])) {
              duplicateRows = duplicateRows + 1;
              rowAlreadyCounted[matrixRow] = true;
            }
            numbersSeenInRow.add(matrix[matrixRow][matrixColumn]);
            
            if (!columnAlreadyCounted[matrixColumn]
                    && numbersSeenInColumn.get(
                            matrixColumn).contains(
                                    matrix[matrixRow][matrixColumn])) {
              duplicateColumns = duplicateColumns + 1;
              columnAlreadyCounted[matrixColumn] = true;
            }
            numbersSeenInColumn.get(matrixColumn).add(
                    matrix[matrixRow][matrixColumn]);
          }
        }
        
        System.out.println(String.format("Case #%d: %d %d %d", testCase + 1,
                trace, duplicateRows, duplicateColumns));
      }
    }
  }
}
