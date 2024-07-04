package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        ArrayList<String> results = new ArrayList<>();

        for (int t = 0; t < testCases; t++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            results.add(processMatrix(matrix, size));
        }

        for (int i = 0; i < results.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + results.get(i));
        }
    }

    public static String processMatrix(int[][] matrix, int size) {
        int trace = calculateTrace(matrix, size);
        int repeatedRows = countRepeatedRows(matrix, size);
        int repeatedColumns = countRepeatedColumns(matrix, size);

        return trace + " " + repeatedRows + " " + repeatedColumns;
    }

    public static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    public static int countRepeatedRows(int[][] matrix, int size) {
        int repeatedRows = 0;
        for (int i = 0; i < size; i++) {
            Map<Integer, Integer> rowMap = new HashMap<>();
            for (int j = 0; j < size; j++) {
                if (rowMap.containsKey(matrix[i][j])) {
                    repeatedRows++;
                    break;
                } else {
                    rowMap.put(matrix[i][j], 0);
                }
            }
        }
        return repeatedRows;
    }

    public static int countRepeatedColumns(int[][] matrix, int size) {
        int repeatedColumns = 0;
        for (int i = 0; i < size; i++) {
            Map<Integer, Integer> columnMap = new HashMap<>();
            for (int j = 0; j < size; j++) {
                if (columnMap.containsKey(matrix[j][i])) {
                    repeatedColumns++;
                    break;
                } else {
                    columnMap.put(matrix[j][i], 0);
                }
            }
        }
        return repeatedColumns;
    }
}