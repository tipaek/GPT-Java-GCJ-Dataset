import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        StringBuilder resultBuilder = new StringBuilder();

        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0, maxRowDuplicates = 0, maxColDuplicates = 0;

            // Read matrix and calculate trace
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Calculate maximum row duplicates
            for (int i = 0; i < matrixSize; i++) {
                HashMap<Integer, Integer> rowMap = new HashMap<>();
                for (int j = 0; j < matrixSize; j++) {
                    rowMap.put(matrix[i][j], rowMap.getOrDefault(matrix[i][j], 0) + 1);
                }
                int rowDuplicates = (int) rowMap.values().stream().filter(count -> count > 1).count();
                maxRowDuplicates = Math.max(maxRowDuplicates, rowDuplicates);
            }

            // Calculate maximum column duplicates
            for (int i = 0; i < matrixSize; i++) {
                HashMap<Integer, Integer> colMap = new HashMap<>();
                for (int j = 0; j < matrixSize; j++) {
                    colMap.put(matrix[j][i], colMap.getOrDefault(matrix[j][i], 0) + 1);
                }
                int colDuplicates = (int) colMap.values().stream().filter(count -> count > 1).count();
                maxColDuplicates = Math.max(maxColDuplicates, colDuplicates);
            }

            resultBuilder.append(String.format("Case #%d: %d %d %d%n", caseIndex, trace, maxRowDuplicates, maxColDuplicates));
        }

        System.out.print(resultBuilder.toString());
        scanner.close();
    }
}