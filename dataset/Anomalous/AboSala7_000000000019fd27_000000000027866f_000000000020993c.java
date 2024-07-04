package Vestigium.java;

import java.util.Scanner;
import java.util.HashSet;

public class Vestigium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTests = sc.nextInt();

        for (int test = 1; test <= numTests; test++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            // Read matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            // Calculate trace
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            // Calculate repeated rows
            int repeatedRows = 0;
            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        repeatedRows++;
                        break;
                    }
                }
            }

            // Calculate repeated columns
            int repeatedCols = 0;
            for (int j = 0; j < n; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        repeatedCols++;
                        break;
                    }
                }
            }

            // Print result for current test case
            System.out.println("Case #" + test + ": " + trace + " " + repeatedRows + " " + repeatedCols);
        }

        sc.close();
    }
}