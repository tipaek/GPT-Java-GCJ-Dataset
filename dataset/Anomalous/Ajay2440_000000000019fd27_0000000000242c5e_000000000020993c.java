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

            int maxRowRepeats = 0, maxColRepeats = 0;

            // Check for maximum row and column repeats
            for (int i = 0; i < n; i++) {
                int[] rowCount = new int[n + 1];
                int[] colCount = new int[n + 1];

                for (int j = 0; j < n; j++) {
                    rowCount[matrix[i][j]]++;
                    colCount[matrix[j][i]]++;
                }

                for (int k = 1; k <= n; k++) {
                    maxRowRepeats = Math.max(maxRowRepeats, rowCount[k]);
                    maxColRepeats = Math.max(maxColRepeats, colCount[k]);
                }
            }

            // Adjust repeats if they are less than 2
            if (maxRowRepeats < 2) {
                maxRowRepeats = 0;
            }
            if (maxColRepeats < 2) {
                maxColRepeats = 0;
            }

            System.out.println("Case #" + t + ": " + diagonalSum + " " + maxRowRepeats + " " + maxColRepeats);
        }

        scanner.close();
    }
}