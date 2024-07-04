import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        while (t > 0) {
            int n = scanner.nextInt();
            int trace = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;
            int[][] matrix = new int[n][n];
            
            // Read the matrix and calculate trace
            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                boolean hasDuplicateInRow = false;
                
                for (int j = 0; j < n; j++) {
                    int value = scanner.nextInt();
                    matrix[i][j] = value;
                    
                    if (i == j) {
                        trace += value;
                    }
                    
                    if (!rowSet.add(value)) {
                        hasDuplicateInRow = true;
                    }
                }
                
                if (hasDuplicateInRow) {
                    duplicateRows++;
                }
            }
            
            // Check for duplicate values in columns
            for (int j = 0; j < n; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                boolean hasDuplicateInColumn = false;
                
                for (int i = 0; i < n; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        hasDuplicateInColumn = true;
                        break;
                    }
                }
                
                if (hasDuplicateInColumn) {
                    duplicateColumns++;
                }
            }
            
            System.out.println(trace + " " + duplicateRows + " " + duplicateColumns);
            t--;
        }
        
        scanner.close();
    }
}