import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int diagonalSum = 0;

            // Reading the matrix and calculating the diagonal sum
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }

            int rowRepeats = 0, colRepeats = 0;

            // Check for duplicate elements in columns
            for (int col = 0; col < n; col++) {
                Set<Integer> colSet = new HashSet<>();
                boolean hasDuplicate = false;
                for (int row = 0; row < n; row++) {
                    if (!colSet.add(matrix[row][col])) {
                        hasDuplicate = true;
                        break;
                    }
                }
                if (hasDuplicate) {
                    colRepeats++;
                }
            }

            // Check for duplicate elements in rows
            for (int row = 0; row < n; row++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean hasDuplicate = false;
                for (int col = 0; col < n; col++) {
                    if (!rowSet.add(matrix[row][col])) {
                        hasDuplicate = true;
                        break;
                    }
                }
                if (hasDuplicate) {
                    rowRepeats++;
                }
            }

            // Output the result
            System.out.println("Case #" + t + ": " + diagonalSum + " " + rowRepeats + " " + colRepeats);
        }
    }
}