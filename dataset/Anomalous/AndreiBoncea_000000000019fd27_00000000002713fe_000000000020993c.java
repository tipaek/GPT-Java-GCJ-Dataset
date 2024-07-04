package com.google;

import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public void solve() {
        Scanner scan = new Scanner(System.in);
        int inputCases = scan.nextInt();

        for (int i = 1; i <= inputCases; i++) {
            int sum = 0, duplicateRows = 0, duplicateCols = 0;
            int matrixSize = scan.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            // Read the matrix input
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scan.nextInt();
                }
            }

            // Calculate the sum of the diagonal elements
            for (int k = 0; k < matrixSize; k++) {
                sum += matrix[k][k];
            }

            // Check for duplicate values in each row
            for (int row = 0; row < matrixSize; row++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < matrixSize; col++) {
                    rowSet.add(matrix[row][col]);
                }
                if (rowSet.size() != matrixSize) {
                    duplicateRows++;
                }
            }

            // Check for duplicate values in each column
            for (int col = 0; col < matrixSize; col++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int row = 0; row < matrixSize; row++) {
                    colSet.add(matrix[row][col]);
                }
                if (colSet.size() != matrixSize) {
                    duplicateCols++;
                }
            }

            // Print the result for the current case
            System.out.println("Case #" + i + ": " + sum + " " + duplicateRows + " " + duplicateCols);
        }

        scan.close();
    }

    public static void main(String[] args) {
        new Solution().solve();
    }
}