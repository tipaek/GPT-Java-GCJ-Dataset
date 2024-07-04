package com.googlecodejam.vestigium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int numOfCases = Integer.parseInt(br.readLine());

            for (int i = 0; i < numOfCases; i++) {
                int size = Integer.parseInt(br.readLine());
                processMatrix(i + 1, size, br);
            }
        } catch (NumberFormatException | IOException e) {
            System.err.println("Error reading input: " + e.getMessage());
        }
    }

    private static void processMatrix(int caseNum, int size, BufferedReader br) {
        int[][] matrix = new int[size][size];

        try {
            for (int i = 0; i < size; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading matrix: " + e.getMessage());
            return;
        }

        int trace = calculateTrace(matrix, size);
        int dupRowCount = countDuplicateRows(matrix, size);
        int dupColCount = countDuplicateColumns(matrix, size);

        System.out.println("Case #" + caseNum + ": " + trace + " " + dupRowCount + " " + dupColCount);
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
            for (int j = 0; j < size; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    dupRowCount++;
                    break;
                }
            }
        }
        return dupRowCount;
    }

    private static int countDuplicateColumns(int[][] matrix, int size) {
        int dupColCount = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!colSet.add(matrix[j][i])) {
                    dupColCount++;
                    break;
                }
            }
        }
        return dupColCount;
    }
}