import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            
            // Reading the matrix
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = scanner.nextInt();
                }
            }
            
            // Calculating the sum of the diagonal
            int diagonalSum = 0;
            for (int j = 0; j < n; j++) {
                diagonalSum += matrix[j][j];
            }
            
            int duplicateRows = 0;
            int duplicateCols = 0;

            // Checking for duplicate values in rows and columns
            for (int j = 0; j < n; j++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                
                for (int k = 0; k < n; k++) {
                    // Check row for duplicates
                    if (!rowSet.add(matrix[j][k])) {
                        duplicateRows++;
                        break;
                    }
                }
                
                for (int k = 0; k < n; k++) {
                    // Check column for duplicates
                    if (!colSet.add(matrix[k][j])) {
                        duplicateCols++;
                        break;
                    }
                }
            }
            
            // Printing the result
            System.out.println(diagonalSum + " " + duplicateRows + " " + duplicateCols);
        }
        
        scanner.close();
    }
}