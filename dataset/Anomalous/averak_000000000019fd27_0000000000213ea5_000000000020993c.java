package com.adobe.daemonapp.util;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                String[] rowValues = scanner.nextLine().split(" ");
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = Integer.parseInt(rowValues[col]);
                }
            }

            calculate(matrix, testCase);
        }
    }

    private static void calculate(int[][] matrix, int testCaseNumber) {
        int trace = 0, duplicateRows = 0, duplicateCols = 0;

        if (matrix == null || matrix.length == 0) {
            System.out.printf("Case #%d: %d %d %d%n", testCaseNumber, trace, duplicateRows, duplicateCols);
            return;
        }

        // Calculate trace
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }

        // Check for duplicate values in rows
        for (int[] row : matrix) {
            Set<Integer> uniqueValues = new HashSet<>();
            for (int value : row) {
                if (!uniqueValues.add(value)) {
                    duplicateRows++;
                    break;
                }
            }
        }

        // Check for duplicate values in columns
        for (int col = 0; col < matrix[0].length; col++) {
            Set<Integer> uniqueValues = new HashSet<>();
            for (int[] row : matrix) {
                if (!uniqueValues.add(row[col])) {
                    duplicateCols++;
                    break;
                }
            }
        }

        System.out.printf("Case #%d: %d %d %d%n", testCaseNumber, trace, duplicateRows, duplicateCols);
    }
}