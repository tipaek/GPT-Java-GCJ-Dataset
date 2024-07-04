package com.adobe.daemonapp.util;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= testCases; i++) {
            int matrixSize = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int j = 0; j < matrixSize; j++) {
                String[] rowValues = scanner.nextLine().split(" ");
                for (int k = 0; k < rowValues.length; k++) {
                    matrix[j][k] = Integer.parseInt(rowValues[k]);
                }
            }

            calculate(matrix, i);
        }
    }

    public static void calculate(int[][] matrix, int caseNumber) {
        int trace = 0, rowRepeated = 0, colRepeated = 0;

        if (matrix == null || matrix.length == 0) {
            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowRepeated + " " + colRepeated);
            return;
        }

        // Calculate trace
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }

        // Check for repeated values in rows
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < matrix[i].length; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    rowRepeated++;
                    break;
                }
            }
        }

        // Check for repeated values in columns
        for (int i = 0; i < matrix[0].length; i++) {
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < matrix.length; j++) {
                if (!colSet.add(matrix[j][i])) {
                    colRepeated++;
                    break;
                }
            }
        }

        System.out.println("Case #" + caseNumber + ": " + trace + " " + rowRepeated + " " + colRepeated);
    }
}