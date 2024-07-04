package com.flyb1z0n.education.java.exercises.codejam.cj_2020;

import java.util.Scanner;

public class Vestigium {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCaseCount = sc.nextInt();
        for (int t = 1; t <= testCaseCount; t++) {
            int matrixSize = sc.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            int[] result = analyzeMatrix(matrix);
            System.out.println("Case #" + t + ": " + result[0] + " " + result[1] + " " + result[2]);
        }
        sc.close();
    }

    public static int[] analyzeMatrix(int[][] matrix) {
        int size = matrix.length;
        int trace = 0;
        int[] rowCount = new int[size];
        int[] colCount = new int[size];
        boolean[] rowHasDuplicate = new boolean[size];
        boolean[] colHasDuplicate = new boolean[size];

        for (int i = 0; i < size; i++) {
            boolean[] rowSeen = new boolean[size];
            boolean[] colSeen = new boolean[size];
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }

                // Check row duplication
                if (rowSeen[matrix[i][j] - 1]) {
                    rowHasDuplicate[i] = true;
                } else {
                    rowSeen[matrix[i][j] - 1] = true;
                }

                // Check column duplication
                if (colSeen[matrix[j][i] - 1]) {
                    colHasDuplicate[i] = true;
                } else {
                    colSeen[matrix[j][i] - 1] = true;
                }
            }
        }

        int duplicateRows = 0;
        int duplicateCols = 0;

        for (int i = 0; i < size; i++) {
            if (rowHasDuplicate[i]) {
                duplicateRows++;
            }
            if (colHasDuplicate[i]) {
                duplicateCols++;
            }
        }

        return new int[]{trace, duplicateRows, duplicateCols};
    }
}