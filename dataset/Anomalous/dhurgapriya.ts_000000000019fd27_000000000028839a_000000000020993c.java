package com.appviewx.adc.f5.common.actions;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
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
        int rowDuplicates = countRowDuplicates(matrix, n);
        int colDuplicates = countColumnDuplicates(matrix, n);

        System.out.printf("Case #%d: %d %d %d%n", caseNumber, trace, rowDuplicates, colDuplicates);
    }

    private static int calculateTrace(int[][] matrix, int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowDuplicates(int[][] matrix, int n) {
        int duplicateRows = 0;
        for (int[] row : matrix) {
            Set<Integer> uniqueElements = Arrays.stream(row).boxed().collect(Collectors.toSet());
            if (uniqueElements.size() < n) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    private static int countColumnDuplicates(int[][] matrix, int n) {
        int duplicateColumns = 0;
        for (int col = 0; col < n; col++) {
            Set<Integer> uniqueElements = Arrays.stream(matrix).map(row -> row[col]).collect(Collectors.toSet());
            if (uniqueElements.size() < n) {
                duplicateColumns++;
            }
        }
        return duplicateColumns;
    }
}