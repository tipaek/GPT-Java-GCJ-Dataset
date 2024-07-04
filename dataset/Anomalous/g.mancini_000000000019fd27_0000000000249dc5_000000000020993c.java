package com.google.code.jam;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        List<int[][]> matrices = new ArrayList<>(testCases);

        for (int i = 0; i < testCases; i++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            for (int r = 0; r < matrixSize; r++) {
                for (int c = 0; c < matrixSize; c++) {
                    matrix[r][c] = scanner.nextInt();
                }
            }
            matrices.add(matrix);
        }

        for (int i = 0; i < testCases; i++) {
            int[][] matrix = matrices.get(i);
            int size = matrix.length;

            long trace = 0;
            long rowsWithDuplicates = 0;
            long columnsWithDuplicates = 0;

            for (int r = 0; r < size; r++) {
                Set<Integer> rowValues = new HashSet<>();
                for (int c = 0; c < size; c++) {
                    rowValues.add(matrix[r][c]);
                    if (r == c) {
                        trace += matrix[r][c];
                    }
                }
                if (rowValues.size() != size) {
                    rowsWithDuplicates++;
                }
            }

            for (int c = 0; c < size; c++) {
                Set<Integer> columnValues = new HashSet<>();
                for (int r = 0; r < size; r++) {
                    columnValues.add(matrix[r][c]);
                }
                if (columnValues.size() != size) {
                    columnsWithDuplicates++;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", i + 1, trace, rowsWithDuplicates, columnsWithDuplicates);
        }

        scanner.close();
    }
}