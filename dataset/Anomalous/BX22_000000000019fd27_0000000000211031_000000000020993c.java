package code_jam;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; ++i) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            
            int trace = calculateTrace(matrix);
            int duplicateRows = countDuplicateRows(matrix);
            int duplicateCols = countDuplicateCols(matrix);
            
            System.out.println("Case #" + i + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }
    
    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix) {
        int count = 0;
        
        for (int[] row : matrix) {
            if (hasDuplicates(row)) {
                count++;
            }
        }
        
        return count;
    }

    private static int countDuplicateCols(int[][] matrix) {
        int count = 0;
        
        for (int col = 0; col < matrix.length; col++) {
            int[] column = new int[matrix.length];
            for (int row = 0; row < matrix.length; row++) {
                column[row] = matrix[row][col];
            }
            if (hasDuplicates(column)) {
                count++;
            }
        }
        
        return count;
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] visited = new boolean[array.length + 1];
        
        for (int value : array) {
            if (visited[value]) {
                return true;
            }
            visited[value] = true;
        }
        
        return false;
    }
}