import java.util.*;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            
            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            // Calculate the sum of the diagonal
            int diagonalSum = 0;
            for (int i = 0; i < n; i++) {
                diagonalSum += matrix[i][i];
            }
            
            int duplicateRows = 0;
            int duplicateCols = 0;
            
            // Check for duplicate values in rows and columns
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                
                for (int j = 0; j < n; j++) {
                    // Check row for duplicates
                    if (!rowSet.add(matrix[i][j])) {
                        duplicateRows++;
                        break;
                    }
                }
                
                for (int j = 0; j < n; j++) {
                    // Check column for duplicates
                    if (!colSet.add(matrix[j][i])) {
                        duplicateCols++;
                        break;
                    }
                }
            }
            
            System.out.println(diagonalSum + " " + duplicateRows + " " + duplicateCols);
        }
        
        scanner.close();
    }
}