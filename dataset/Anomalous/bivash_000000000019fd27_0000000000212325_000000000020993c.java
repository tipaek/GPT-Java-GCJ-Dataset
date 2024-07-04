import java.util.Arrays;
import java.util.Scanner;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            long trace = calculateTrace(matrix);
            int duplicateRows = countDuplicateRows(matrix);
            int duplicateColumns = countDuplicateColumns(matrix);

            System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }

    private static long calculateTrace(int[][] matrix) {
        long trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix) {
        int duplicateRowCount = 0;

        for (int[] row : matrix) {
            if (hasDuplicates(row)) {
                duplicateRowCount++;
            }
        }

        return duplicateRowCount;
    }

    private static int countDuplicateColumns(int[][] matrix) {
        int duplicateColumnCount = 0;
        int n = matrix.length;

        for (int col = 0; col < n; col++) {
            int[] column = new int[n];
            for (int row = 0; row < n; row++) {
                column[row] = matrix[row][col];
            }

            if (hasDuplicates(column)) {
                duplicateColumnCount++;
            }
        }

        return duplicateColumnCount;
    }

    private static boolean hasDuplicates(int[] array) {
        int[] sortedArray = array.clone();
        Arrays.sort(sortedArray);

        for (int i = 0; i < sortedArray.length - 1; i++) {
            if (sortedArray[i] == sortedArray[i + 1]) {
                return true;
            }
        }

        return false;
    }
}