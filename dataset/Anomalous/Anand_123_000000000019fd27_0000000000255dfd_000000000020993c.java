import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            // Calculating the sum of the diagonal
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += matrix[i][i];
            }

            // Counting duplicate rows and columns
            int duplicateRow = 0;
            int duplicateCol = 0;
            for (int i = 0; i < n; i++) {
                if (hasDuplicateRow(i, matrix)) {
                    duplicateRow++;
                }
                if (hasDuplicateCol(i, matrix)) {
                    duplicateCol++;
                }
            }

            // Printing the results
            System.out.println(sum + " " + duplicateRow + " " + duplicateCol);
        }
        sc.close();
    }

    private static boolean hasDuplicateRow(int row, int[][] matrix) {
        Set<Integer> set = new HashSet<>();
        for (int value : matrix[row]) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasDuplicateCol(int col, int[][] matrix) {
        Set<Integer> set = new HashSet<>();
        for (int[] row : matrix) {
            if (!set.add(row[col])) {
                return true;
            }
        }
        return false;
    }
}