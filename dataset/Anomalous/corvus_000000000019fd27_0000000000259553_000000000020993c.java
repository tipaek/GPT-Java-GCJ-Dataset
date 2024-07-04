package com.codejam;

import java.util.*;
import java.io.*;

public class Vestigium {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    matrix[r][c] = in.nextInt();
                }
            }

            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            // Calculate the trace
            for (int j = 0; j < n; j++) {
                trace += matrix[j][j];
            }

            // Check for row duplicates
            for (int r = 0; r < n; r++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int c = 0; c < n; c++) {
                    if (!rowSet.add(matrix[r][c])) {
                        rowDuplicates++;
                        break;
                    }
                }
            }

            // Check for column duplicates
            for (int c = 0; c < n; c++) {
                Set<Integer> colSet = new HashSet<>();
                for (int r = 0; r < n; r++) {
                    if (!colSet.add(matrix[r][c])) {
                        colDuplicates++;
                        break;
                    }
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", i, trace, rowDuplicates, colDuplicates);
        }
    }
}