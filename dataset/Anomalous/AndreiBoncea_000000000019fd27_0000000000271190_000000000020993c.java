package com.google;

import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public void solve() {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            // Read matrix elements
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int trace = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;

            // Calculate trace
            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];
            }

            // Check for duplicate rows
            for (int row = 0; row < matrixSize; row++) {
                HashSet<Integer> uniqueElements = new HashSet<>();
                for (int col = 0; col < matrixSize; col++) {
                    uniqueElements.add(matrix[row][col]);
                }
                if (uniqueElements.size() != matrixSize) {
                    duplicateRows++;
                }
            }

            // Check for duplicate columns
            for (int col = 0; col < matrixSize; col++) {
                HashSet<Integer> uniqueElements = new HashSet<>();
                for (int row = 0; row < matrixSize; row++) {
                    uniqueElements.add(matrix[row][col]);
                }
                if (uniqueElements.size() != matrixSize) {
                    duplicateCols++;
                }
            }

            // Print the result for the current test case
            System.out.printf("Case #%d: %d %d %d%n", testCase, trace, duplicateRows, duplicateCols);
        }

        scanner.close();
    }

    public static void main(String[] args) {
        new Solution().solve();
    }
}