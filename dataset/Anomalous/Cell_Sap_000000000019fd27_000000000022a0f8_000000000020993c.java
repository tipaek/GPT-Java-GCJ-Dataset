import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int diagonalSum = 0, rowDuplicates = 0, columnDuplicates = 0;
            
            // Read matrix and calculate diagonal sum
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        diagonalSum += matrix[row][col];
                    }
                }
            }
            
            // Check for duplicate values in rows
            for (int row = 0; row < matrixSize; row++) {
                if (hasDuplicates(matrix[row])) {
                    rowDuplicates++;
                }
            }
            
            // Check for duplicate values in columns
            for (int col = 0; col < matrixSize; col++) {
                int[] column = new int[matrixSize];
                for (int row = 0; row < matrixSize; row++) {
                    column[row] = matrix[row][col];
                }
                if (hasDuplicates(column)) {
                    columnDuplicates++;
                }
            }
            
            // Print result for the current test case
            System.out.println("Case #" + caseNum + ": " + diagonalSum + " " + rowDuplicates + " " + columnDuplicates);
        }
    }
    
    // Helper method to check for duplicates in an array
    private static boolean hasDuplicates(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int value : array) {
            if (seen.contains(value)) {
                return true;
            }
            seen.add(value);
        }
        return false;
    }
}