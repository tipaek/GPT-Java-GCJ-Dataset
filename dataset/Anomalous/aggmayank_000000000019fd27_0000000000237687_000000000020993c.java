import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int c = 1; c <= t; c++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;

            // Read matrix and calculate trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            int duplicateRows = 0;
            int duplicateCols = 0;

            // Check for duplicate values in rows
            for (int i = 0; i < n; i++) {
                if (hasDuplicates(matrix[i])) {
                    duplicateRows++;
                }
            }

            // Check for duplicate values in columns
            for (int j = 0; j < n; j++) {
                int[] column = new int[n];
                for (int i = 0; i < n; i++) {
                    column[i] = matrix[i][j];
                }
                if (hasDuplicates(column)) {
                    duplicateCols++;
                }
            }

            System.out.println("Case #" + c + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }

    // Helper method to check for duplicates in an array
    private static boolean hasDuplicates(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int value : array) {
            if (!seen.add(value)) {
                return true;
            }
        }
        return false;
    }
}