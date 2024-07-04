package p;

import java.util.HashSet;
import java.util.Scanner;

class Vestigium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int l = 1; l <= t; l++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            // Input matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            // Calculate trace
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            // Check for row duplicates
            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    rowSet.add(matrix[i][j]);
                }
                if (rowSet.size() != n) {
                    rowDuplicates++;
                }
            }

            // Check for column duplicates
            for (int j = 0; j < n; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    colSet.add(matrix[i][j]);
                }
                if (colSet.size() != n) {
                    colDuplicates++;
                }
            }

            System.out.println("Case #" + l + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
        sc.close();
    }
}