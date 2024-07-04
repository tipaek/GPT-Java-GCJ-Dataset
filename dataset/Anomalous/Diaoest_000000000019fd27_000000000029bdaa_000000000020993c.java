import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int testCases = scanner.nextInt();

            for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
                int matrixSize = scanner.nextInt();
                int[][] matrix = new int[matrixSize][matrixSize];
                int duplicateRows = 0;
                int duplicateCols = 0;

                // Read the matrix and count duplicate rows
                for (int row = 0; row < matrixSize; row++) {
                    Set<Integer> rowSet = new HashSet<>();
                    for (int col = 0; col < matrixSize; col++) {
                        matrix[row][col] = scanner.nextInt();
                        rowSet.add(matrix[row][col]);
                    }
                    if (rowSet.size() != matrixSize) {
                        duplicateRows++;
                    }
                }

                // Count duplicate columns
                for (int col = 0; col < matrixSize; col++) {
                    Set<Integer> colSet = new HashSet<>();
                    for (int row = 0; row < matrixSize; row++) {
                        colSet.add(matrix[row][col]);
                    }
                    if (colSet.size() != matrixSize) {
                        duplicateCols++;
                    }
                }

                // Calculate the trace
                int trace = 0;
                for (int i = 0; i < matrixSize; i++) {
                    trace += matrix[i][i];
                }

                // Print the result for the current test case
                System.out.printf("Case #%d: %d %d %d%n", caseIndex + 1, trace, duplicateRows, duplicateCols);
            }
        }
        
        scanner.close();
    }
}