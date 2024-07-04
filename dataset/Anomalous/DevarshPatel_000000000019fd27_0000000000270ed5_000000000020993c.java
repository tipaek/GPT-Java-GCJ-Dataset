package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        ArrayList<String> results = new ArrayList<>();

        for (int i = 0; i < testCaseCount; i++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            results.add(solve(matrix, matrixSize));
        }

        int caseNumber = 1;
        for (String result : results) {
            System.out.println("Case #" + caseNumber + ": " + result);
            caseNumber++;
        }
    }

    private static String solve(int[][] matrix, int size) {
        int trace = calculateTrace(matrix, size);
        int duplicateRows = countDuplicateRows(matrix, size);
        int duplicateColumns = countDuplicateColumns(matrix, size);
        return trace + " " + duplicateRows + " " + duplicateColumns;
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix, int size) {
        int duplicateCount = 0;
        for (int row = 0; row < size; row++) {
            Map<Integer, Boolean> seen = new HashMap<>();
            for (int col = 0; col < size; col++) {
                if (seen.containsKey(matrix[row][col])) {
                    duplicateCount++;
                    break;
                } else {
                    seen.put(matrix[row][col], true);
                }
            }
        }
        return duplicateCount;
    }

    private static int countDuplicateColumns(int[][] matrix, int size) {
        int duplicateCount = 0;
        for (int col = 0; col < size; col++) {
            Map<Integer, Boolean> seen = new HashMap<>();
            for (int row = 0; row < size; row++) {
                if (seen.containsKey(matrix[row][col])) {
                    duplicateCount++;
                    break;
                } else {
                    seen.put(matrix[row][col], true);
                }
            }
        }
        return duplicateCount;
    }
}