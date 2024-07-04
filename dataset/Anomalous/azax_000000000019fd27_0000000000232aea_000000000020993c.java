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

            for (int i = 0; i < matrixSize; i++) {
                String[] row = scanner.nextLine().split(" ");
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = Integer.parseInt(row[j]);
                }
                trace += matrix[i][i];
            }

            int[] result = evaluateMatrix(matrix);
            int badRows = result[0];
            int badColumns = result[1];

            System.out.printf("Case #%d: %d %d %d%n", caseIndex, trace, badRows, badColumns);
        }

        scanner.close();
    }

    private static int[] evaluateMatrix(int[][] matrix) {
        int badRows = 0;
        int badColumns = 0;
        int size = matrix.length;

        for (int i = 0; i < size; i++) {
            if (hasDuplicate(matrix[i])) {
                badRows++;
            }
        }

        for (int j = 0; j < size; j++) {
            int[] column = new int[size];
            for (int i = 0; i < size; i++) {
                column[i] = matrix[i][j];
            }
            if (hasDuplicate(column)) {
                badColumns++;
            }
        }

        return new int[] { badRows, badColumns };
    }

    private static boolean hasDuplicate(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int value : array) {
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }
}