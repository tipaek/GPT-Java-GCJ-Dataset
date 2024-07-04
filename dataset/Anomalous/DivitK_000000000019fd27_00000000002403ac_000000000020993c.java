import java.util.Scanner;
import java.io.IOException;

public class HelloWorld {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int trace = 0;
            for (int j = 0; j < matrixSize; j++) {
                trace += matrix[j][j];
            }

            int duplicateRows = 0;
            for (int row = 0; row < matrixSize; row++) {
                if (hasDuplicates(matrix[row])) {
                    duplicateRows++;
                }
            }

            int duplicateCols = 0;
            for (int col = 0; col < matrixSize; col++) {
                if (hasDuplicates(getColumn(matrix, col))) {
                    duplicateCols++;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + duplicateRows + " " + duplicateCols);
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