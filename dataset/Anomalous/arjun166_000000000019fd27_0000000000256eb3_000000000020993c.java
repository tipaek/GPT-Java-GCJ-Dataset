package codejam1;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int x = 1; x <= t; x++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = 0;
            int rowDupCount = 0;
            int colDupCount = 0;

            // Calculate trace and row duplicates
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];

                boolean[] rowSeen = new boolean[n + 1];
                boolean rowHasDup = false;

                for (int j = 0; j < n; j++) {
                    if (rowSeen[matrix[i][j]]) {
                        rowHasDup = true;
                    }
                    rowSeen[matrix[i][j]] = true;
                }

                if (rowHasDup) {
                    rowDupCount++;
                }
            }

            // Calculate column duplicates
            for (int j = 0; j < n; j++) {
                boolean[] colSeen = new boolean[n + 1];
                boolean colHasDup = false;

                for (int i = 0; i < n; i++) {
                    if (colSeen[matrix[i][j]]) {
                        colHasDup = true;
                    }
                    colSeen[matrix[i][j]] = true;
                }

                if (colHasDup) {
                    colDupCount++;
                }
            }

            System.out.println("Case #" + x + ": " + trace + " " + rowDupCount + " " + colDupCount);
        }

        scanner.close();
    }
}