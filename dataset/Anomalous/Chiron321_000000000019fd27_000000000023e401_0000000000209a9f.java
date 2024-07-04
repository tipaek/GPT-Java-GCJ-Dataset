import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseNumber = 1;
        int numberOfTests = sc.nextInt();

        while (numberOfTests-- > 0) {
            int matrixSize = sc.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0;
            int rowDuplicates = 0;
            int columnDuplicates = 0;

            // Read matrix and calculate trace and row duplicates
            for (int i = 0; i < matrixSize; i++) {
                boolean rowHasDuplicate = false;
                for (int j = 0; j < matrixSize; j++) {
                    int value = sc.nextInt();
                    matrix[i][j] = value;
                    if (i == j) {
                        trace += value;
                    }
                    if (!rowHasDuplicate && hasDuplicate(matrix[i], value, j)) {
                        rowDuplicates++;
                        rowHasDuplicate = true;
                    }
                }
            }

            // Calculate column duplicates
            for (int j = 0; j < matrixSize; j++) {
                if (hasColumnDuplicate(matrix, j, matrixSize)) {
                    columnDuplicates++;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowDuplicates + " " + columnDuplicates);
            caseNumber++;
        }
    }

    private static boolean hasDuplicate(int[] array, int value, int upToIndex) {
        for (int i = 0; i < upToIndex; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasColumnDuplicate(int[][] matrix, int columnIndex, int matrixSize) {
        for (int i = 0; i < matrixSize - 1; i++) {
            for (int j = i + 1; j < matrixSize; j++) {
                if (matrix[i][columnIndex] == matrix[j][columnIndex]) {
                    return true;
                }
            }
        }
        return false;
    }
}