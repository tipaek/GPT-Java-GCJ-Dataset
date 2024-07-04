package com.company;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        for (int cas = 1; cas <= t; cas++) {
            int n = scan.nextInt();
            int[][] arr = new int[n][n];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = scan.nextInt();
                }
            }

            // Calculating the diagonal sum
            int diag = 0;
            for (int i = 0; i < n; i++) {
                diag += arr[i][i];
            }

            // Calculating the number of repeated elements in rows
            int rep1 = 0;
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (seen[arr[i][j]]) {
                        rep1++;
                        break;
                    }
                    seen[arr[i][j]] = true;
                }
            }

            // Calculating the number of repeated elements in columns
            int rep2 = 0;
            for (int j = 0; j < n; j++) {
                boolean[] seen = new boolean[n + 1];
                for (int i = 0; i < n; i++) {
                    if (seen[arr[i][j]]) {
                        rep2++;
                        break;
                    }
                    seen[arr[i][j]] = true;
                }
            }

            // Printing the result for the current case
            System.out.println("Case #" + cas + ": " + diag + " " + rep1 + " " + rep2);
        }
    }
}