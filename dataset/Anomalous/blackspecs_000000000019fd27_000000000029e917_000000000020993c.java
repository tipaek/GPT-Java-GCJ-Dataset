import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int diagonalSum = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;
            
            // Read matrix and calculate diagonal sum
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        diagonalSum += matrix[row][col];
                    }
                }
            }
            
            // Check for duplicates in rows
            for (int row = 0; row < n; row++) {
                boolean[] seen = new boolean[101];
                for (int col = 0; col < n; col++) {
                    if (seen[matrix[row][col]]) {
                        rowDuplicates++;
                        break;
                    }
                    seen[matrix[row][col]] = true;
                }
            }
            
            // Check for duplicates in columns
            for (int col = 0; col < n; col++) {
                boolean[] seen = new boolean[101];
                for (int row = 0; row < n; row++) {
                    if (seen[matrix[row][col]]) {
                        colDuplicates++;
                        break;
                    }
                    seen[matrix[row][col]] = true;
                }
            }
            
            System.out.println("Case #" + i + ": " + diagonalSum + " " + rowDuplicates + " " + colDuplicates);
        }
        
        scanner.close();
    }
}