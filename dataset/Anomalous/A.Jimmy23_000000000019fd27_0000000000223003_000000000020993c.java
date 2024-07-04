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
            
            // Calculate the diagonal sum
            int diagSum = 0;
            for (int i = 0; i < n; i++) {
                diagSum += arr[i][i];
            }
            
            // Count repeated elements in rows
            int rowRepeats = 0;
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (seen[arr[i][j]]) {
                        rowRepeats++;
                        break;
                    }
                    seen[arr[i][j]] = true;
                }
            }
            
            // Count repeated elements in columns
            int colRepeats = 0;
            for (int j = 0; j < n; j++) {
                boolean[] seen = new boolean[n + 1];
                for (int i = 0; i < n; i++) {
                    if (seen[arr[i][j]]) {
                        colRepeats++;
                        break;
                    }
                    seen[arr[i][j]] = true;
                }
            }
            
            // Print the result for the current case
            System.out.println("Case #" + cas + ": " + diagSum + " " + rowRepeats + " " + colRepeats);
        }
        
        scan.close();
    }
}