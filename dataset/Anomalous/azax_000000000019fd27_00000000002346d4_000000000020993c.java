import java.util.Scanner;
import java.io.BufferedInputStream;

public class Matrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int numberOfCases = Integer.parseInt(scanner.nextLine());

        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            int matrixSize = Integer.parseInt(scanner.nextLine());
            int trace = 0;
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                String[] elements = scanner.nextLine().split(" ");
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = Integer.parseInt(elements[col]);
                }
                trace += matrix[row][row];
            }

            int[] invalidCounts = findInvalidRowsAndColumns(matrix);
            int invalidRows = invalidCounts[0];
            int invalidCols = invalidCounts[1];

            System.out.println("Case #" + (caseIndex + 1) + ": " + trace + " " + invalidRows + " " + invalidCols);
        }

        scanner.close();
    }

    private static int[] findInvalidRowsAndColumns(int[][] matrix) {
        int invalidRows = 0;
        int invalidCols = 0;

        for (int i = 0; i < matrix.length; i++) {
            if (hasDuplicate(matrix[i])) {
                invalidRows++;
            }
        }

        for (int j = 0; j < matrix.length; j++) {
            int[] column = new int[matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                column[i] = matrix[i][j];
            }
            if (hasDuplicate(column)) {
                invalidCols++;
            }
        }

        return new int[]{invalidRows, invalidCols};
    }

    private static boolean hasDuplicate(int[] array) {
        boolean[] seen = new boolean[array.length];
        for (int value : array) {
            int index = value - 1;
            if (seen[index]) {
                return true;
            }
            seen[index] = true;
        }
        return false;
    }
}