package com.googlecodejam.vestigium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int numOfCases = Integer.parseInt(br.readLine());
            for (int i = 0; i < numOfCases; i++) {
                int size = Integer.parseInt(br.readLine());
                processCase(i + 1, size, br);
            }
        } catch (NumberFormatException | IOException e) {
            System.err.println("Error reading input: " + e.getMessage());
        }
    }

    private static void processCase(int caseNum, int size, BufferedReader br) throws IOException {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < size; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }

        int trace = calculateTrace(matrix, size);
        int dupRowCount = countDuplicateRows(matrix, size);
        int dupColCount = countDuplicateColumns(matrix, size);

        System.out.printf("Case #%d: %d %d %d%n", caseNum, trace, dupRowCount, dupColCount);
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix, int size) {
        int dupRowCount = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            boolean duplicateFound = false;
            for (int j = 0; j < size && !duplicateFound; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    dupRowCount++;
                    duplicateFound = true;
                }
            }
        }
        return dupRowCount;
    }

    private static int countDuplicateColumns(int[][] matrix, int size) {
        int dupColCount = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> colSet = new HashSet<>();
            boolean duplicateFound = false;
            for (int j = 0; j < size && !duplicateFound; j++) {
                if (!colSet.add(matrix[j][i])) {
                    dupColCount++;
                    duplicateFound = true;
                }
            }
        }
        return dupColCount;
    }
}