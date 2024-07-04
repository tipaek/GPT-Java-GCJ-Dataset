import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();
        int caseNumber = 1;

        while (numberOfTests-- > 0) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0, duplicateRows = 0, duplicateColumns = 0;

            // Read the matrix and calculate the trace
            for (int i = 0; i < matrixSize; i++) {
                boolean rowHasDuplicates = false;
                for (int j = 0; j < matrixSize; j++) {
                    int value = scanner.nextInt();
                    matrix[i][j] = value;
                    if (i == j) {
                        trace += value;
                    }
                    if (!rowHasDuplicates && hasDuplicates(matrix[i], value)) {
                        duplicateRows++;
                        rowHasDuplicates = true;
                    }
                }
            }

            // Check for duplicate values in columns
            for (int j = 0; j < matrixSize; j++) {
                if (hasColumnDuplicates(matrix, j)) {
                    duplicateColumns++;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
            caseNumber++;
        }
    }

    private static boolean hasDuplicates(int[] array, int value) {
        int count = 0;
        for (int element : array) {
            if (element == value) {
                count++;
                if (count > 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasColumnDuplicates(int[][] matrix, int columnIndex) {
        int size = matrix.length;
        boolean[] seen = new boolean[size + 1];
        for (int i = 0; i < size; i++) {
            int value = matrix[i][columnIndex];
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }
}