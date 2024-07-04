import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = scanner.nextInt();
                }
            }

            int duplicateRows = countDuplicateRows(matrix, n);
            int duplicateColumns = countDuplicateColumns(matrix, n);
            int diagonalSum = calculateDiagonalSum(matrix, n);

            System.out.printf("Case #%d: %d %d %d%n", i, diagonalSum, duplicateRows, duplicateColumns);
        }
    }

    private static int countDuplicateRows(int[][] matrix, int n) {
        int duplicateRows = 0;

        for (int i = 0; i < n; i++) {
            if (hasDuplicates(matrix[i])) {
                duplicateRows++;
            }
        }

        return duplicateRows;
    }

    private static int countDuplicateColumns(int[][] matrix, int n) {
        int duplicateColumns = 0;

        for (int j = 0; j < n; j++) {
            int[] column = new int[n];
            for (int i = 0; i < n; i++) {
                column[i] = matrix[i][j];
            }
            if (hasDuplicates(column)) {
                duplicateColumns++;
            }
        }

        return duplicateColumns;
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    private static int calculateDiagonalSum(int[][] matrix, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }
}