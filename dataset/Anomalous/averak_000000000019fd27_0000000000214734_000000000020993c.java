package com.adobe.daemonapp.util;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCaseCount = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < testCaseCount; i++) {
                int matrixSize = Integer.parseInt(scanner.nextLine());
                int[][] matrix = new int[matrixSize][matrixSize];
                
                for (int j = 0; j < matrixSize; j++) {
                    String[] row = scanner.nextLine().split(" ");
                    for (int k = 0; k < row.length; k++) {
                        matrix[j][k] = Integer.parseInt(row[k]);
                    }
                }
                
                calculate(matrix, i + 1);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void calculate(int[][] matrix, int testCaseNumber) {
        int trace = 0, rowCount = 0, colCount = 0;

        if (matrix == null || matrix.length == 0) {
            System.out.println("Case #" + testCaseNumber + ": " + trace + " " + rowCount + " " + colCount);
            return;
        }

        // Calculate trace
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }

        // Calculate duplicate rows
        for (int[] row : matrix) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int element : row) {
                if (!uniqueElements.add(element)) {
                    rowCount++;
                    break;
                }
            }
        }

        // Calculate duplicate columns
        for (int i = 0; i < matrix[0].length; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int[] ints : matrix) {
                if (!uniqueElements.add(ints[i])) {
                    colCount++;
                    break;
                }
            }
        }

        System.out.println("Case #" + testCaseNumber + ": " + trace + " " + rowCount + " " + colCount);
    }
}