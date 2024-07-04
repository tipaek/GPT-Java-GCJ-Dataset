import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();

        for (int testCaseNumber = 1; testCaseNumber <= numberOfTestCases; testCaseNumber++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            processTestCase(testCaseNumber, matrix);
        }
    }

    private static void processTestCase(int testCaseNumber, int[][] matrix) {
        int trace = calculateTrace(matrix);
        int rowCountWithDuplicates = countRowsWithDuplicates(matrix);
        int colCountWithDuplicates = countColumnsWithDuplicates(matrix);

        System.out.printf("Case #%d: %d %d %d\n", testCaseNumber, trace, rowCountWithDuplicates, colCountWithDuplicates);
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowsWithDuplicates(int[][] matrix) {
        int duplicateRowCount = 0;

        for (int[] row : matrix) {
            Set<Integer> uniqueElements = Arrays.stream(row).boxed().collect(Collectors.toSet());
            if (uniqueElements.size() < row.length) {
                duplicateRowCount++;
            }
        }

        return duplicateRowCount;
    }

    private static int countColumnsWithDuplicates(int[][] matrix) {
        int duplicateColumnCount = 0;

        for (int col = 0; col < matrix.length; col++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int[] row : matrix) {
                uniqueElements.add(row[col]);
            }
            if (uniqueElements.size() < matrix.length) {
                duplicateColumnCount++;
            }
        }

        return duplicateColumnCount;
    }
}