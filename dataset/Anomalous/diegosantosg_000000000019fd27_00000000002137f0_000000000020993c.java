import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Read matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculate trace
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            // Calculate number of rows with duplicate values
            int duplicateRows = 0;
            for (int i = 0; i < n; i++) {
                if (hasDuplicates(matrix[i])) {
                    duplicateRows++;
                }
            }

            // Calculate number of columns with duplicate values
            int duplicateColumns = 0;
            for (int j = 0; j < n; j++) {
                if (hasColumnDuplicates(matrix, j)) {
                    duplicateColumns++;
                }
            }

            System.out.println("Case #" + caseNum + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1]; // Assuming values are 1 to n
        for (int value : array) {
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }

    private static boolean hasColumnDuplicates(int[][] matrix, int col) {
        boolean[] seen = new boolean[matrix.length + 1]; // Assuming values are 1 to n
        for (int i = 0; i < matrix.length; i++) {
            int value = matrix[i][col];
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }
}