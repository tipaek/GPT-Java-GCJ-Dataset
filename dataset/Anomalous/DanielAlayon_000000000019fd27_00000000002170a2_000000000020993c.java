import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int numberOfCases = scanner.nextInt();
        
        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            int matrixSize = scanner.nextInt();
            long[][] matrix = new long[matrixSize][matrixSize];
            long diagonalSum = 0;
            int duplicateRowsCount = 0;
            int duplicateColumnsCount = 0;

            // Fill the matrix
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextLong();
                }
            }

            // Check for duplicates in rows and columns
            for (int i = 0; i < matrixSize; i++) {
                if (hasDuplicates(matrix[i])) {
                    duplicateRowsCount++;
                }

                long[] column = new long[matrixSize];
                for (int j = 0; j < matrixSize; j++) {
                    column[j] = matrix[j][i];
                }
                if (hasDuplicates(column)) {
                    duplicateColumnsCount++;
                }
            }

            // Calculate diagonal sum
            for (int i = 0; i < matrixSize; i++) {
                diagonalSum += matrix[i][i];
            }

            // Print the result for the current case
            System.out.printf("Case #%d: %d %d %d%n", caseIndex, diagonalSum, duplicateRowsCount, duplicateColumnsCount);
        }
    }

    private static boolean hasDuplicates(long[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}