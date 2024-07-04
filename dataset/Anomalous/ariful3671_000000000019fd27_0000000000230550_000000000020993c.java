import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int caseNo = 1;

        while (t-- > 0) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, row = 0, col = 0;

            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculate trace
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            // Calculate rows with duplicate values
            for (int i = 0; i < n; i++) {
                if (hasDuplicates(matrix[i])) {
                    row++;
                }
            }

            // Calculate columns with duplicate values
            for (int i = 0; i < n; i++) {
                if (hasDuplicates(getColumn(matrix, i))) {
                    col++;
                }
            }

            System.out.println("Case #" + caseNo + ": " + trace + " " + row + " " + col);
            caseNo++;
        }

        scanner.close();
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int num : array) {
            if (seen[num]) {
                return true;
            }
            seen[num] = true;
        }
        return false;
    }

    private static int[] getColumn(int[][] matrix, int colIndex) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][colIndex];
        }
        return column;
    }
}