import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            
            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            int diagonalSum = 0;
            int rowDuplicateCount = 0;
            int colDuplicateCount = 0;
            
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                boolean rowHasDuplicate = false;
                boolean colHasDuplicate = false;
                
                for (int j = 0; j < n; j++) {
                    if (rowSet.contains(matrix[i][j])) {
                        rowHasDuplicate = true;
                    }
                    if (colSet.contains(matrix[j][i])) {
                        colHasDuplicate = true;
                    }
                    rowSet.add(matrix[i][j]);
                    colSet.add(matrix[j][i]);
                    
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
                
                if (rowHasDuplicate) {
                    rowDuplicateCount++;
                }
                if (colHasDuplicate) {
                    colDuplicateCount++;
                }
            }
            
            System.out.println("Case #" + t + ": " + diagonalSum + " " + rowDuplicateCount + " " + colDuplicateCount);
        }
        
        scanner.close();
    }
}