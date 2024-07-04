import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();
        String[] results = new String[numberOfTests];

        for (int testIndex = 0; testIndex < numberOfTests; testIndex++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            scanner.nextLine(); // Consume the remaining newline

            for (int rowIndex = 0; rowIndex < matrixSize; rowIndex++) {
                String[] rowValues = scanner.nextLine().split(" ");
                for (int colIndex = 0; colIndex < matrixSize; colIndex++) {
                    matrix[rowIndex][colIndex] = Integer.parseInt(rowValues[colIndex]);
                }
            }

            int traceValue = calculateTrace(matrix);
            int duplicateRows = countDuplicateRows(matrix);
            int duplicateColumns = countDuplicateColumns(matrix);

            results[testIndex] = String.format("Case #%d: %d %d %d", testIndex + 1, traceValue, duplicateRows, duplicateColumns);
        }

        for (String result : results) {
            System.out.println(result);
        }
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix) {
        int duplicateRowCount = 0;
        for (int[] row : matrix) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int element : row) {
                if (!uniqueElements.add(element)) {
                    duplicateRowCount++;
                    break;
                }
            }
        }
        return duplicateRowCount;
    }

    private static int countDuplicateColumns(int[][] matrix) {
        int duplicateColumnCount = 0;
        int matrixSize = matrix.length;

        for (int colIndex = 0; colIndex < matrixSize; colIndex++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int rowIndex = 0; rowIndex < matrixSize; rowIndex++) {
                if (!uniqueElements.add(matrix[rowIndex][colIndex])) {
                    duplicateColumnCount++;
                    break;
                }
            }
        }
        return duplicateColumnCount;
    }
}