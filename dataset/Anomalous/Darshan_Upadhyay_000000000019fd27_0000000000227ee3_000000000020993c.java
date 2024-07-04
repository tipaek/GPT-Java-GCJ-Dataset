package problem;

import java.util.Scanner;
import java.util.HashSet;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int diagonalSum = 0, duplicateRows = 0, duplicateCols = 0;

            // Reading matrix and calculating diagonal sum
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = sc.nextInt();
                    if (row == col) {
                        diagonalSum += matrix[row][col];
                    }
                }
            }

            // Checking for duplicate elements in rows
            for (int row = 0; row < n; row++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < n; col++) {
                    if (!rowSet.add(matrix[row][col])) {
                        duplicateRows++;
                        break;
                    }
                }
            }

            // Checking for duplicate elements in columns
            for (int col = 0; col < n; col++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int row = 0; row < n; row++) {
                    if (!colSet.add(matrix[row][col])) {
                        duplicateCols++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + diagonalSum + " " + duplicateRows + " " + duplicateCols);
        }

        sc.close();
    }
}