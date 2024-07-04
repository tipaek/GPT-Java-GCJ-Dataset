package com.appviewx.adc.f5.common.actions;

import java.util.*;
import java.util.stream.Collectors;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            calculateKRC(i, scanner);
        }
        scanner.close();
    }

    private static void calculateKRC(int caseNumber, Scanner scanner) {
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }

        int trace = calculateTrace(matrix, n);
        int duplicateRows = countDuplicateRows(matrix, n);
        int duplicateCols = countDuplicateCols(matrix, n);

        System.out.printf("Case #%d: %d %d %d%n", caseNumber + 1, trace, duplicateRows, duplicateCols);
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix, int size) {
        int duplicateRows = 0;
        for (int[] row : matrix) {
            Set<Integer> rowSet = Arrays.stream(row).boxed().collect(Collectors.toSet());
            if (rowSet.size() < size) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    private static int countDuplicateCols(int[][] matrix, int size) {
        int duplicateCols = 0;
        for (int col = 0; col < size; col++) {
            Set<Integer> colSet = new HashSet<>();
            for (int row = 0; row < size; row++) {
                colSet.add(matrix[row][col]);
            }
            if (colSet.size() < size) {
                duplicateCols++;
            }
        }
        return duplicateCols;
    }
}