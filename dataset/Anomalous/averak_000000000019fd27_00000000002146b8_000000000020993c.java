package com.adobe.daemonapp.util;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCaseCount = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < testCaseCount; i++) {
                int matrixSize = Integer.parseInt(scanner.nextLine());
                int[][] matrix = new int[matrixSize][matrixSize];
                for (int j = 0; j < matrixSize; j++) {
                    String[] row = scanner.nextLine().split(" ");
                    for (int k = 0; k < row.length; k++) {
                        matrix[j][k] = Integer.parseInt(row[k]);
                    }
                }
                calculate(matrix, i + 1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void calculate(int[][] matrix, int caseNumber) {
        int diagonalSum = 0;
        int rowCount = 0;
        int colCount = 0;

        if (matrix == null || matrix.length == 0) {
            System.out.printf("Case #%d: %d %d %d%n", caseNumber, diagonalSum, rowCount, colCount);
            return;
        }

        // Calculate diagonal sum
        for (int i = 0; i < matrix.length; i++) {
            diagonalSum += matrix[i][i];
        }

        // Calculate row count with duplicates
        for (int[] row : matrix) {
            Set<Integer> rowSet = new HashSet<>();
            for (int value : row) {
                if (!rowSet.add(value)) {
                    rowCount++;
                    break;
                }
            }
        }

        // Calculate column count with duplicates
        for (int i = 0; i < matrix[0].length; i++) {
            Set<Integer> colSet = new HashSet<>();
            for (int[] ints : matrix) {
                if (!colSet.add(ints[i])) {
                    colCount++;
                    break;
                }
            }
        }

        System.out.printf("Case #%d: %d %d %d%n", caseNumber, diagonalSum, rowCount, colCount);
    }
}