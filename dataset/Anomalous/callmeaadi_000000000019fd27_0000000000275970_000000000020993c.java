import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        for (int t = 1; t <= p; t++) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            int diagonalSum = 0;

            // Read the matrix and calculate the diagonal sum
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = in.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }

            int rowDuplicates = 0;
            int colDuplicates = 0;

            // Check for column duplicates
            for (int c = 0; c < n; c++) {
                Set<Integer> colSet = new HashSet<>();
                for (int r = 0; r < n; r++) {
                    if (!colSet.add(matrix[r][c])) {
                        colDuplicates++;
                        break;
                    }
                }
            }

            // Check for row duplicates
            for (int r = 0; r < n; r++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int c = 0; c < n; c++) {
                    if (!rowSet.add(matrix[r][c])) {
                        rowDuplicates++;
                        break;
                    }
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", t, diagonalSum, rowDuplicates, colDuplicates);
        }
    }
}