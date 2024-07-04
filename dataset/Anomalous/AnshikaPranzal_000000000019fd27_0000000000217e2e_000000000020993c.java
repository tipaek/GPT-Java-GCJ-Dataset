package Practice;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowDupCount = 0, colDupCount = 0;

            // Reading matrix and calculating trace and row duplicates
            for (int row = 0; row < n; row++) {
                int[] rowChecker = new int[n];
                boolean rowHasDuplicate = false;

                for (int col = 0; col < n; col++) {
                    matrix[row][col] = sc.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                    if (rowChecker[matrix[row][col] - 1] == 1 && !rowHasDuplicate) {
                        rowDupCount++;
                        rowHasDuplicate = true;
                    } else {
                        rowChecker[matrix[row][col] - 1] = 1;
                    }
                }
            }

            // Calculating column duplicates
            for (int col = 0; col < n; col++) {
                int[] colChecker = new int[n];
                boolean colHasDuplicate = false;

                for (int row = 0; row < n; row++) {
                    if (colChecker[matrix[row][col] - 1] == 1 && !colHasDuplicate) {
                        colDupCount++;
                        colHasDuplicate = true;
                    } else {
                        colChecker[matrix[row][col] - 1] = 1;
                    }
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowDupCount + " " + colDupCount);
        }
    }
}