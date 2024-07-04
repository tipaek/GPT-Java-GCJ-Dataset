import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int diagonalSum = 0;

            // Read the matrix and calculate the diagonal sum
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }

            int maxRowDuplicates = 0, maxColDuplicates = 0;

            // Check for duplicate elements in rows and columns
            for (int i = 0; i < n; i++) {
                maxRowDuplicates = Math.max(maxRowDuplicates, countDuplicates(matrix[i]));
                maxColDuplicates = Math.max(maxColDuplicates, countDuplicatesInColumn(matrix, i));
            }

            System.out.println("Case #" + t + ": " + diagonalSum + " " + maxRowDuplicates + " " + maxColDuplicates);
        }
    }

    // Helper method to count duplicate elements in a row
    private static int countDuplicates(int[] row) {
        Set<Integer> seen = new HashSet<>();
        int duplicates = 0;
        for (int num : row) {
            if (!seen.add(num)) {
                duplicates++;
            }
        }
        return duplicates == 0 ? 0 : duplicates + 1;
    }

    // Helper method to count duplicate elements in a column
    private static int countDuplicatesInColumn(int[][] matrix, int col) {
        Set<Integer> seen = new HashSet<>();
        int duplicates = 0;
        for (int[] row : matrix) {
            if (!seen.add(row[col])) {
                duplicates++;
            }
        }
        return duplicates == 0 ? 0 : duplicates + 1;
    }
}