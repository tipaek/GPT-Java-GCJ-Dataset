package com.adobe.daemonapp.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = scanner.nextInt();
        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            scanner.nextLine(); // Consume the remaining newline character

            for (int row = 0; row < matrixSize; row++) {
                String[] rowData = scanner.nextLine().split(" ");
                for (int col = 0; col < rowData.length; col++) {
                    matrix[row][col] = Integer.parseInt(rowData[col]);
                }
            }

            calculate(matrix, testCase);
        }
    }

    public static void calculate(int[][] matrix, int testCaseNumber) {
        int diagonalSum = 0;
        int duplicateRows = 0;
        int duplicateCols = 0;

        if (matrix == null || matrix.length == 0) {
            System.out.println("Case #" + testCaseNumber + ": " + diagonalSum + " " + duplicateRows + " " + duplicateCols);
            return;
        }

        // Calculate diagonal sum
        for (int i = 0; i < matrix.length; i++) {
            diagonalSum += matrix[i][i];
        }

        // Check for duplicate elements in rows
        for (int[] row : matrix) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int element : row) {
                if (!uniqueElements.add(element)) {
                    duplicateRows++;
                    break;
                }
            }
        }

        // Check for duplicate elements in columns
        for (int col = 0; col < matrix[0].length; col++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int[] row : matrix) {
                if (!uniqueElements.add(row[col])) {
                    duplicateCols++;
                    break;
                }
            }
        }

        System.out.println("Case #" + testCaseNumber + ": " + diagonalSum + " " + duplicateRows + " " + duplicateCols);
    }
}