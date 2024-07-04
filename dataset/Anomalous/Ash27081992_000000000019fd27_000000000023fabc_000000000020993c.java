import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            int matrixSize = scanner.nextInt();
            processTestCase(matrixSize, i);
        }
    }
    
    private static void processTestCase(int matrixSize, int testCaseNumber) {
        int[][] matrix = new int[matrixSize][matrixSize];
        int trace = 0;
        int duplicateRows = 0;
        int duplicateColumns = 0;

        // Read the matrix and calculate the trace
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = scanner.nextInt();
                if (i == j) {
                    trace += matrix[i][j];
                }
            }
        }

        // Check for duplicate values in rows
        for (int i = 0; i < matrixSize; i++) {
            if (hasDuplicates(matrix[i])) {
                duplicateRows++;
            }
        }

        // Check for duplicate values in columns
        for (int j = 0; j < matrixSize; j++) {
            int[] column = new int[matrixSize];
            for (int i = 0; i < matrixSize; i++) {
                column[i] = matrix[i][j];
            }
            if (hasDuplicates(column)) {
                duplicateColumns++;
            }
        }

        System.out.printf("Case #%d: %d %d %d%n", testCaseNumber + 1, trace, duplicateRows, duplicateColumns);
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int value : array) {
            if (value > 0 && value <= array.length) {
                if (seen[value]) {
                    return true;
                }
                seen[value] = true;
            }
        }
        return false;
    }
}