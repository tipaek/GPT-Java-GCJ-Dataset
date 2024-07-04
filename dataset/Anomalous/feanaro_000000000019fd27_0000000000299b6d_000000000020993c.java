package com.google.code.qualificationround.NestingDepth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        Function<int[][], String> solver = (matrix) -> {
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            for (int i = 0; i < matrix.length; ++i) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < matrix.length; ++j) {
                    if (!rowSet.add(matrix[i][j])) {
                        ++rowDuplicates;
                        break;
                    }
                }
            }

            for (int i = 0; i < matrix.length; ++i) {
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < matrix.length; ++j) {
                    if (!colSet.add(matrix[j][i])) {
                        ++colDuplicates;
                        break;
                    }
                }
            }

            for (int i = 0; i < matrix.length; ++i) {
                trace += matrix[i][i];
            }

            return " " + trace + " " + rowDuplicates + " " + colDuplicates;
        };

        if (scanner != null) {
            int testCases = scanner.nextInt();
            for (int i = 1; i <= testCases; ++i) {
                int n = scanner.nextInt();
                int[][] matrix = new int[n][n];

                for (int j = 0; j < n; ++j) {
                    for (int k = 0; k < n; ++k) {
                        matrix[j][k] = scanner.nextInt();
                    }
                }

                System.out.println("Case #" + i + ": " + solver.apply(matrix));
            }
        }
    }
}