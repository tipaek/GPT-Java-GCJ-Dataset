import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int test = 1; test <= testCases; test++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int duplicateRows = 0;
            int duplicateCols = 0;
            int diagonalSum = 0;

            // Check for duplicate rows
            for (int i = 0; i < n; i++) {
                boolean hasDuplicate = false;
                outerLoop:
                for (int j = 0; j < n; j++) {
                    for (int k = j + 1; k < n; k++) {
                        if (matrix[i][j] == matrix[i][k]) {
                            hasDuplicate = true;
                            break outerLoop;
                        }
                    }
                }
                if (hasDuplicate) {
                    duplicateRows++;
                }
            }

            // Check for duplicate columns
            for (int i = 0; i < n; i++) {
                boolean hasDuplicate = false;
                outerLoop:
                for (int j = 0; j < n; j++) {
                    for (int k = j + 1; k < n; k++) {
                        if (matrix[j][i] == matrix[k][i]) {
                            hasDuplicate = true;
                            break outerLoop;
                        }
                    }
                }
                if (hasDuplicate) {
                    duplicateCols++;
                }
            }

            // Calculate the sum of the main diagonal
            for (int i = 0; i < n; i++) {
                diagonalSum += matrix[i][i];
            }

            // Print the result for the current test case
            System.out.printf("Case #%d: %d %d %d%n", test, diagonalSum, duplicateRows, duplicateCols);
        }

        scanner.close();
    }
}