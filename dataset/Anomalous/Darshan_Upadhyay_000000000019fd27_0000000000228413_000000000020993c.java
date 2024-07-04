package problem;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int sum = 0, rowDuplicates = 0, colDuplicates = 0;

            // Reading matrix and calculating diagonal sum
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = sc.nextInt();
                    if (j == k) {
                        sum += matrix[j][k];
                    }
                }
            }

            // Checking for duplicate values in rows
            for (int j = 0; j < n; j++) {
                if (hasDuplicates(matrix[j])) {
                    rowDuplicates++;
                }
            }

            // Checking for duplicate values in columns
            for (int j = 0; j < n; j++) {
                int[] column = new int[n];
                for (int k = 0; k < n; k++) {
                    column[k] = matrix[k][j];
                }
                if (hasDuplicates(column)) {
                    colDuplicates++;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + sum + " " + rowDuplicates + " " + colDuplicates);
        }
    }

    // Utility method to check for duplicates in an array
    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[101];
        for (int value : array) {
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }
}