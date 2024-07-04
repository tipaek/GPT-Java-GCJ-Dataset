package com.google.codejam;

import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    private static int calculateMatrixTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix, int size) {
        int duplicateRowCount = 0;
        for (int i = 0; i < size; i++) {
            HashSet<Integer> rowElements = new HashSet<>();
            boolean hasDuplicate = false;
            for (int j = 0; j < size; j++) {
                if (!rowElements.add(matrix[i][j])) {
                    hasDuplicate = true;
                    break;
                }
            }
            if (hasDuplicate) {
                duplicateRowCount++;
            }
        }
        return duplicateRowCount;
    }

    private static int countDuplicateColumns(int[][] matrix, int size) {
        int duplicateColumnCount = 0;
        for (int j = 0; j < size; j++) {
            HashSet<Integer> columnElements = new HashSet<>();
            boolean hasDuplicate = false;
            for (int i = 0; i < size; i++) {
                if (!columnElements.add(matrix[i][j])) {
                    hasDuplicate = true;
                    break;
                }
            }
            if (hasDuplicate) {
                duplicateColumnCount++;
            }
        }
        return duplicateColumnCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = calculateMatrixTrace(matrix, size);
            int duplicateRows = countDuplicateRows(matrix, size);
            int duplicateColumns = countDuplicateColumns(matrix, size);

            System.out.printf("Case #%d: %d %d %d%n", t, trace, duplicateRows, duplicateColumns);
        }

        scanner.close();
    }
}