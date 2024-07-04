package com.adobe.daemonapp.util;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = Integer.parseInt(scanner.nextLine());
            for (int i = 1; i <= testCases; i++) {
                int matrixSize = Integer.parseInt(scanner.nextLine());
                int[][] matrix = new int[matrixSize][matrixSize];
                
                for (int row = 0; row < matrixSize; row++) {
                    String[] line = scanner.nextLine().split(" ");
                    for (int col = 0; col < matrixSize; col++) {
                        matrix[row][col] = Integer.parseInt(line[col]);
                    }
                }
                
                calculate(matrix, i);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void calculate(int[][] matrix, int caseNumber) {
        int diagonalSum = 0;
        int duplicateRows = 0;
        int duplicateCols = 0;

        if (matrix == null || matrix.length == 0) {
            System.out.printf("Case #%d: %d %d %d%n", caseNumber, diagonalSum, duplicateRows, duplicateCols);
            return;
        }

        // Calculate diagonal sum
        for (int i = 0; i < matrix.length; i++) {
            diagonalSum += matrix[i][i];
        }

        // Check for duplicate elements in rows
        for (int[] row : matrix) {
            Set<Integer> rowSet = new HashSet<>();
            for (int value : row) {
                if (!rowSet.add(value)) {
                    duplicateRows++;
                    break;
                }
            }
        }

        // Check for duplicate elements in columns
        for (int col = 0; col < matrix[0].length; col++) {
            Set<Integer> colSet = new HashSet<>();
            for (int row = 0; row < matrix.length; row++) {
                if (!colSet.add(matrix[row][col])) {
                    duplicateCols++;
                    break;
                }
            }
        }

        System.out.printf("Case #%d: %d %d %d%n", caseNumber, diagonalSum, duplicateRows, duplicateCols);
    }
}