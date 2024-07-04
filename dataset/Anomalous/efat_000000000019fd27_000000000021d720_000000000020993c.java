import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            boolean[] rowHasDuplicate = new boolean[n];
            boolean[] colHasDuplicate = new boolean[n];

            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Check for duplicate values in rows
            for (int i = 0; i < n; i++) {
                Set<Integer> seen = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!seen.add(matrix[i][j])) {
                        rowHasDuplicate[i] = true;
                        break;
                    }
                }
            }

            // Check for duplicate values in columns
            for (int j = 0; j < n; j++) {
                Set<Integer> seen = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (!seen.add(matrix[i][j])) {
                        colHasDuplicate[j] = true;
                        break;
                    }
                }
            }

            // Calculate the sum of the diagonal
            int diagonalSum = 0;
            for (int i = 0; i < n; i++) {
                diagonalSum += matrix[i][i];
            }

            // Count the number of rows and columns with duplicates
            int duplicateRows = 0;
            int duplicateCols = 0;
            for (int i = 0; i < n; i++) {
                if (rowHasDuplicate[i]) {
                    duplicateRows++;
                }
                if (colHasDuplicate[i]) {
                    duplicateCols++;
                }
            }

            // Print the result for the current test case
            System.out.printf("Case #%d: %d %d %d%n", testCase, diagonalSum, duplicateRows, duplicateCols);
        }
    }
}