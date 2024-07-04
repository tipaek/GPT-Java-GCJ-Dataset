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
            results.add(solve(matrix, size));
        }

        int caseNumber = 0;
        for (String result : results) {
            caseNumber++;
            System.out.println("Case #" + caseNumber + ": " + result + " ");
        }
    }

    public static String solve(int[][] matrix, int size) {
        int trace = calculateTrace(matrix, size);
        int repeatedRows = countRepeatedRows(matrix, size);
        int repeatedCols = countRepeatedCols(matrix, size);

        return trace + " " + repeatedRows + " " + repeatedCols;
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRepeatedRows(int[][] matrix, int size) {
        int repeatedRows = 0;
        for (int i = 0; i < size; i++) {
            if (hasDuplicates(matrix[i])) {
                repeatedRows++;
            }
        }
        return repeatedRows;
    }

    private static int countRepeatedCols(int[][] matrix, int size) {
        int repeatedCols = 0;
        for (int j = 0; j < size; j++) {
            int[] column = new int[size];
            for (int i = 0; i < size; i++) {
                column[i] = matrix[i][j];
            }
            if (hasDuplicates(column)) {
                repeatedCols++;
            }
        }
        return repeatedCols;
    }

    private static boolean hasDuplicates(int[] array) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int value : array) {
            if (map.containsKey(value)) {
                return true;
            }
            map.put(value, true);
        }
        return false;
    }
}