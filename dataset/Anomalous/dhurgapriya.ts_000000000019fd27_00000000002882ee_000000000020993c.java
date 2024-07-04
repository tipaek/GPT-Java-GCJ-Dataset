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

        int trace = calculateTrace(matrix);
        int duplicateRows = countDuplicateRows(matrix, n);
        int duplicateColumns = countDuplicateColumns(matrix, n);

        System.out.printf("Case #%d: %d %d %d%n", caseNumber + 1, trace, duplicateRows, duplicateColumns);
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix, int n) {
        int duplicateRows = 0;
        for (int[] row : matrix) {
            Set<Integer> uniqueElements = Arrays.stream(row).boxed().collect(Collectors.toSet());
            if (uniqueElements.size() < n) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    private static int countDuplicateColumns(int[][] matrix, int n) {
        int duplicateColumns = 0;
        for (int col = 0; col < n; col++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int row = 0; row < n; row++) {
                uniqueElements.add(matrix[row][col]);
            }
            if (uniqueElements.size() < n) {
                duplicateColumns++;
            }
        }
        return duplicateColumns;
    }
}