import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfCases = scanner.nextInt();
        String[] results = new String[numOfCases];

        for (int caseIndex = 0; caseIndex < numOfCases; caseIndex++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Reading the matrix
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int duplicateRows = 0;
            int duplicateCols = 0;
            int diagonalSum = 0;

            // Calculate diagonal sum and check for duplicate rows
            for (int i = 0; i < n; i++) {
                diagonalSum += matrix[i][i];
                if (hasDuplicates(matrix[i])) {
                    duplicateRows++;
                }
            }

            // Check for duplicate columns
            for (int col = 0; col < n; col++) {
                if (hasDuplicatesInColumn(matrix, col)) {
                    duplicateCols++;
                }
            }

            results[caseIndex] = String.format("Case #%d: %d %d %d", caseIndex + 1, diagonalSum, duplicateRows, duplicateCols);
        }

        // Print all results
        for (String result : results) {
            System.out.println(result);
        }
    }

    // Helper method to check if a row has duplicates
    private static boolean hasDuplicates(int[] row) {
        Set<Integer> set = new HashSet<>();
        for (int num : row) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    // Helper method to check if a column has duplicates
    private static boolean hasDuplicatesInColumn(int[][] matrix, int col) {
        Set<Integer> set = new HashSet<>();
        for (int[] row : matrix) {
            if (!set.add(row[col])) {
                return true;
            }
        }
        return false;
    }
}