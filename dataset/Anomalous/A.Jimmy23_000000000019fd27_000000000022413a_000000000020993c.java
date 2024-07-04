package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = scanner.nextInt();
        for (int cas = 1; cas <= t; cas++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculate the sum of the diagonal
            int diagonalSum = 0;
            for (int i = 0; i < n; i++) {
                diagonalSum += matrix[i][i];
            }

            // Count repeated elements in rows
            int repeatedRows = 0;
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (seen[matrix[i][j]]) {
                        repeatedRows++;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
            }

            // Count repeated elements in columns
            int repeatedColumns = 0;
            for (int j = 0; j < n; j++) {
                boolean[] seen = new boolean[n + 1];
                for (int i = 0; i < n; i++) {
                    if (seen[matrix[i][j]]) {
                        repeatedColumns++;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
            }

            // Print the result for the current case
            System.out.println("Case #" + cas + ": " + diagonalSum + " " + repeatedRows + " " + repeatedColumns);
        }
    }
}