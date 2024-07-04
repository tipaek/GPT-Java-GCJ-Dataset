package vestigium;

import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            
            solve(matrix, t);
        }

        scanner.close();
    }

    public static void solve(int[][] matrix, int testCaseNumber) {
        int trace = 0;
        int repeatedRows = 0;
        int repeatedColumns = 0;
        int size = matrix.length;

        for (int i = 0; i < size; i++) {
            HashSet<Integer> rowSet = new HashSet<>();
            HashSet<Integer> colSet = new HashSet<>();
            
            for (int j = 0; j < size; j++) {
                // Calculate trace
                if (i == j) {
                    trace += matrix[i][j];
                }
                
                // Check for duplicate in row
                rowSet.add(matrix[i][j]);
                
                // Check for duplicate in column
                colSet.add(matrix[j][i]);
            }

            // If rowSet size is less than matrix size, there are duplicates
            if (rowSet.size() < size) {
                repeatedRows++;
            }

            // If colSet size is less than matrix size, there are duplicates
            if (colSet.size() < size) {
                repeatedColumns++;
            }
        }

        System.out.println(String.format("Case #%d: %d %d %d", testCaseNumber + 1, trace, repeatedRows, repeatedColumns));
    }
}