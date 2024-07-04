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
                String[] rowData = scanner.nextLine().split(" ");
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = Integer.parseInt(rowData[col]);
                }
                trace += matrix[row][row];
            }

            int[] invalidCounts = findInvalidRowsAndColumns(matrix);
            int invalidRows = invalidCounts[0];
            int invalidColumns = invalidCounts[1];

            System.out.println("Case #" + caseIndex + ": " + trace + " " + invalidRows + " " + invalidColumns);
        }
        scanner.close();
    }

    private static int[] findInvalidRowsAndColumns(int[][] matrix) {
        int invalidRows = 0;
        int invalidColumns = 0;
        int matrixSize = matrix.length;

        for (int row = 0; row < matrixSize; row++) {
            boolean[] seenInRow = new boolean[matrixSize];
            for (int col = 0; col < matrixSize; col++) {
                int value = matrix[row][col];
                if (seenInRow[value - 1]) {
                    invalidRows++;
                    break;
                }
                seenInRow[value - 1] = true;
            }
        }

        for (int col = 0; col < matrixSize; col++) {
            boolean[] seenInColumn = new boolean[matrixSize];
            for (int row = 0; row < matrixSize; row++) {
                int value = matrix[row][col];
                if (seenInColumn[value - 1]) {
                    invalidColumns++;
                    break;
                }
                seenInColumn[value - 1] = true;
            }
        }

        return new int[] { invalidRows, invalidColumns };
    }
}