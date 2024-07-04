import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] frequency = new int[n + 1][101];
            int[][] matrix = new int[n + 1][n + 1];
            int duplicateRows = 0, duplicateColumns = 0;
            long diagonalSum = 0L;

            // Read the matrix
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Check rows for duplicates and calculate diagonal sum
            for (int i = 1; i <= n; i++) {
                boolean hasDuplicate = false;
                for (int j = 1; j <= n; j++) {
                    int value = matrix[i][j];
                    frequency[i][value]++;
                    if (frequency[i][value] > 1) {
                        hasDuplicate = true;
                    }
                    if (i == j) {
                        diagonalSum += value;
                    }
                }
                if (hasDuplicate) {
                    duplicateRows++;
                }
            }

            // Reset frequency array for column check
            frequency = new int[n + 1][101];

            // Check columns for duplicates
            for (int i = 1; i <= n; i++) {
                boolean hasDuplicate = false;
                for (int j = 1; j <= n; j++) {
                    int value = matrix[j][i];
                    frequency[i][value]++;
                    if (frequency[i][value] > 1) {
                        hasDuplicate = true;
                    }
                }
                if (hasDuplicate) {
                    duplicateColumns++;
                }
            }

            // Print the result for the current test case
            System.out.println("Case #" + t + ": " + diagonalSum + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}