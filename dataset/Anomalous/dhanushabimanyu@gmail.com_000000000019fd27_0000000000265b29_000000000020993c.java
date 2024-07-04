package vestigium;

import java.util.Scanner;

public class Solution {

    static int[][] matrix;

    public static int hasRowDuplicates(int row, int size) {
        boolean[] seen = new boolean[size + 1];
        for (int i = 0; i < size; i++) {
            if (seen[matrix[row][i]]) {
                return 1;
            }
            seen[matrix[row][i]] = true;
        }
        return 0;
    }

    public static int hasColumnDuplicates(int col, int size) {
        boolean[] seen = new boolean[size + 1];
        for (int i = 0; i < size; i++) {
            if (seen[matrix[i][col]]) {
                return 1;
            }
            seen[matrix[i][col]] = true;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;
            matrix = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
                rowDuplicates += hasRowDuplicates(i, n);
                colDuplicates += hasColumnDuplicates(i, n);
            }
            
            System.out.println("Case #" + t + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
        scanner.close();
    }
}