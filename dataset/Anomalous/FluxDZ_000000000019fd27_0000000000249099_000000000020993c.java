package com.company;

import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of test cases
        int testCaseCount = scanner.nextInt();
        int[][] results = new int[testCaseCount][4]; // [case number, trace, row repeats, column repeats]

        // Process each test case
        for (int caseIndex = 1; caseIndex <= testCaseCount; caseIndex++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            // Read the matrix
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculate the trace
            int trace = 0;
            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];
            }

            // Calculate the number of rows with duplicates
            int rowRepeats = 0;
            for (int i = 0; i < matrixSize; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < matrixSize; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowRepeats++;
                        break;
                    }
                }
            }

            // Calculate the number of columns with duplicates
            int columnRepeats = 0;
            for (int j = 0; j < matrixSize; j++) {
                HashSet<Integer> columnSet = new HashSet<>();
                for (int i = 0; i < matrixSize; i++) {
                    if (!columnSet.add(matrix[i][j])) {
                        columnRepeats++;
                        break;
                    }
                }
            }

            // Store the results for the current test case
            results[caseIndex - 1] = new int[]{caseIndex, trace, rowRepeats, columnRepeats};
        }

        // Print the results for all test cases
        for (int[] result : results) {
            System.out.printf("Case #%d: %d %d %d\n", result[0], result[1], result[2], result[3]);
        }
    }
}