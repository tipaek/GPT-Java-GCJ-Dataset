import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numOfCases = in.nextInt();
        String[] results = new String[numOfCases];

        for (int i = 0; i < numOfCases; i++) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];

            // Read the matrix
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = in.nextInt();
                }
            }

            // Calculate the diagonal sum
            int diagonalSum = 0;
            for (int j = 0; j < n; j++) {
                diagonalSum += matrix[j][j];
            }

            // Calculate the number of rows with duplicate elements
            int duplicateRows = 0;
            for (int row = 0; row < n; row++) {
                if (hasDuplicates(matrix[row])) {
                    duplicateRows++;
                }
            }

            // Calculate the number of columns with duplicate elements
            int duplicateCols = 0;
            for (int col = 0; col < n; col++) {
                if (hasDuplicates(getColumn(matrix, col))) {
                    duplicateCols++;
                }
            }

            // Store the result for this case
            results[i] = "Case #" + (i + 1) + ": " + diagonalSum + " " + duplicateRows + " " + duplicateCols;
        }

        // Print all results
        for (String result : results) {
            System.out.println(result);
        }
    }

    // Helper method to check if an array has duplicates
    private static boolean hasDuplicates(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int value : array) {
            if (!seen.add(value)) {
                return true;
            }
        }
        return false;
    }

    // Helper method to get a column from a matrix
    private static int[] getColumn(int[][] matrix, int colIndex) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][colIndex];
        }
        return column;
    }
}