import java.util.Scanner;
import java.io.IOException;

public class HelloWorld {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();

        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            // Read matrix
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            // Calculate trace
            int trace = 0;
            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];
            }

            // Calculate number of rows with duplicate elements
            int duplicateRows = 0;
            for (int row = 0; row < matrixSize; row++) {
                if (hasDuplicates(matrix[row])) {
                    duplicateRows++;
                }
            }

            // Calculate number of columns with duplicate elements
            int duplicateCols = 0;
            for (int col = 0; col < matrixSize; col++) {
                if (hasDuplicates(getColumn(matrix, col))) {
                    duplicateCols++;
                }
            }

            // Print result for the current case
            System.out.printf("Case #%d: %d %d %d%n", caseIndex + 1, trace, duplicateRows, duplicateCols);
        }
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int value : array) {
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }

    private static int[] getColumn(int[][] matrix, int colIndex) {
        int[] column = new int[matrix.length];
        for (int row = 0; row < matrix.length; row++) {
            column[row] = matrix[row][colIndex];
        }
        return column;
    }
}