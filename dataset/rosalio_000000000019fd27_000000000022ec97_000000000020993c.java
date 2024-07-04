package com.alex;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    matrix[j][k] = in.nextInt();
                }
            }

            int[] output = getOutput(n, matrix);

            System.out.println(String.format("Case #%d: %d %d %d", i, output[0], output[1], output[2]));
        }
    }

    private static int[] getOutput(int n, int[][] matrix) {
        int[] output = new int[3];

        output[0] = calculateTrace(n, matrix);
        output[1] = rowCounts(n, matrix);
        output[2] = colCounts(n, matrix);

        return output;
    }

    private static int rowCounts(int n, int[][] matrix) {
        int count = 0;
        int[] table = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(table, -1);
            for (int j = 0; j < n; ++j) {
                int num = matrix[i][j];
                if (table[num] == 1) {
                    count++;
                    break;
                }
                table[num] = 1;
            }
        }
        return count;
    }

    private static int colCounts(int n, int[][] matrix) {
        int count = 0;
        int[] table = new int[n + 1];
        for (int j = 0; j < n; ++j) {
            Arrays.fill(table, -1);
            for (int i = 0; i < n; ++i) {
                int num = matrix[i][j];
                if (table[num] == 1) {
                    count++;
                    break;
                }
                table[num] = 1;
            }
        }
        return count;
    }

    private static int calculateTrace(int n, int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < n; ++i) {
            trace += matrix[i][i];
        }
        return trace;
    }


}
