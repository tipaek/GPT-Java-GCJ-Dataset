package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        ArrayList<String> results = new ArrayList<>();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            results.add(processMatrix(matrix, n));
        }

        for (int i = 0; i < results.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + results.get(i));
        }
    }

    public static String processMatrix(int[][] matrix, int n) {
        int trace = calculateTrace(matrix, n);
        int duplicateRows = countDuplicateRows(matrix, n);
        int duplicateCols = countDuplicateCols(matrix, n);

        return trace + " " + duplicateRows + " " + duplicateCols;
    }

    public static int calculateTrace(int[][] matrix, int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    public static int countDuplicateRows(int[][] matrix, int n) {
        int duplicateRows = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!uniqueElements.add(matrix[i][j])) {
                    duplicateRows++;
                    break;
                }
            }
        }

        return duplicateRows;
    }

    public static int countDuplicateCols(int[][] matrix, int n) {
        int duplicateCols = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!uniqueElements.add(matrix[j][i])) {
                    duplicateCols++;
                    break;
                }
            }
        }

        return duplicateCols;
    }
}