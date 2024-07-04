import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int diagonalSum = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }

            int duplicateRows = countDuplicateRows(matrix);
            int duplicateColumns = countDuplicateColumns(matrix);

            System.out.printf("Case #%d: %d %d %d%n", caseNumber, diagonalSum, duplicateRows, duplicateColumns);
        }
    }

    private static int countDuplicateRows(int[][] matrix) {
        int count = 0;
        for (int[] row : matrix) {
            if (hasDuplicates(row)) {
                count++;
            }
        }
        return count;
    }

    private static int countDuplicateColumns(int[][] matrix) {
        int count = 0;
        int n = matrix.length;

        for (int col = 0; col < n; col++) {
            int[] columnData = new int[n];
            for (int row = 0; row < n; row++) {
                columnData[row] = matrix[row][col];
            }
            if (hasDuplicates(columnData)) {
                count++;
            }
        }
        return count;
    }

    private static boolean hasDuplicates(int[] array) {
        HashSet<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }
}