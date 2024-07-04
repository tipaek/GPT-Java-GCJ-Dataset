import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Vestigium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int[][] copyMatrix = new int[n][n];
            int duplicateRows = 0, duplicateCols = 0, trace = 0;
            
            // Read matrix and calculate trace
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = sc.nextInt();
                    copyMatrix[row][col] = matrix[row][col];
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
            }
            
            // Check for duplicate rows
            for (int row = 0; row < n; row++) {
                boolean[] seen = new boolean[n];
                for (int col = 0; col < n; col++) {
                    int value = matrix[row][col] - 1;
                    if (seen[value]) {
                        duplicateRows++;
                        break;
                    } else {
                        seen[value] = true;
                    }
                }
            }
            
            // Check for duplicate columns
            for (int col = 0; col < n; col++) {
                boolean[] seen = new boolean[n];
                for (int row = 0; row < n; row++) {
                    int value = copyMatrix[row][col] - 1;
                    if (seen[value]) {
                        duplicateCols++;
                        break;
                    } else {
                        seen[value] = true;
                    }
                }
            }
            
            // Print the result for the current case
            System.out.println("Case #" + i + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }
}