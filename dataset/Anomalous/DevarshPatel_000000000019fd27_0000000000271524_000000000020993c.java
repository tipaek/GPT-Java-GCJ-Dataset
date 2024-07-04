package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        ArrayList<String> results = new ArrayList<>();

        for (int i = 0; i < testCases; i++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            results.add(solve(matrix, size));
        }

        for (int i = 0; i < results.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + results.get(i));
        }
    }

    private static String solve(int[][] matrix, int size) {
        int trace = calculateTrace(matrix, size);
        int rowDuplicates = countRowDuplicates(matrix, size);
        int colDuplicates = countColDuplicates(matrix, size);
        return trace + " " + rowDuplicates + " " + colDuplicates;
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowDuplicates(int[][] matrix, int size) {
        int duplicateCount = 0;
        for (int row = 0; row < size; row++) {
            Map<Integer, Integer> elementCount = new HashMap<>();
            for (int col = 0; col < size; col++) {
                if (elementCount.containsKey(matrix[row][col])) {
                    duplicateCount++;
                    break;
                } else {
                    elementCount.put(matrix[row][col], 1);
                }
            }
        }
        return duplicateCount;
    }

    private static int countColDuplicates(int[][] matrix, int size) {
        int duplicateCount = 0;
        for (int col = 0; col < size; col++) {
            Map<Integer, Integer> elementCount = new HashMap<>();
            for (int row = 0; row < size; row++) {
                if (elementCount.containsKey(matrix[row][col])) {
                    duplicateCount++;
                    break;
                } else {
                    elementCount.put(matrix[row][col], 1);
                }
            }
        }
        return duplicateCount;
    }
}