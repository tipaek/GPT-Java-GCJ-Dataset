package com.google;

import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalCases = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= totalCases; caseIndex++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            HashSet<Integer> uniqueElements = new HashSet<>();

            // Reading the matrix
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int diagonalSum = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;

            // Calculate diagonal sum
            for (int i = 0; i < matrixSize; i++) {
                diagonalSum += matrix[i][i];
            }

            // Check for duplicate elements in rows
            for (int row = 0; row < matrixSize; row++) {
                uniqueElements.clear();
                for (int col = 0; col < matrixSize; col++) {
                    uniqueElements.add(matrix[row][col]);
                }
                if (uniqueElements.size() != matrixSize) {
                    duplicateRows++;
                }
            }

            // Check for duplicate elements in columns
            for (int col = 0; col < matrixSize; col++) {
                uniqueElements.clear();
                for (int row = 0; row < matrixSize; row++) {
                    uniqueElements.add(matrix[row][col]);
                }
                if (uniqueElements.size() != matrixSize) {
                    duplicateCols++;
                }
            }

            // Print the result for the current case
            System.out.printf("Case #%d: %d %d %d%n", caseIndex, diagonalSum, duplicateRows, duplicateCols);
        }

        scanner.close();
    }
}