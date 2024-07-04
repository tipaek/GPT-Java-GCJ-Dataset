package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        
        for (int cas = 1; cas <= t; cas++) {
            int n = scan.nextInt();
            int[][] arr = new int[n][n];
            
            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = scan.nextInt();
                }
            }
            
            // Calculate the sum of the diagonal
            int diagSum = 0;
            for (int i = 0; i < n; i++) {
                diagSum += arr[i][i];
            }
            
            // Calculate repeated elements in rows
            int repRows = 0;
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (seen[arr[i][j]]) {
                        repRows++;
                        break;
                    }
                    seen[arr[i][j]] = true;
                }
            }
            
            // Calculate repeated elements in columns
            int repCols = 0;
            for (int j = 0; j < n; j++) {
                boolean[] seen = new boolean[n + 1];
                for (int i = 0; i < n; i++) {
                    if (seen[arr[i][j]]) {
                        repCols++;
                        break;
                    }
                    seen[arr[i][j]] = true;
                }
            }
            
            // Print the result for the current case
            System.out.println("Case #" + cas + ": " + diagSum + " " + repRows + " " + repCols);
        }
        
        scan.close();
    }
}