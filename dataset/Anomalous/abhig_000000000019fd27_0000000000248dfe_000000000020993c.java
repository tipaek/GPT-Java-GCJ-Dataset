import java.util.*;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, duplicateRows = 0, duplicateCols = 0;
            
            // Read matrix and calculate trace
            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                boolean rowDuplicate = false;
                
                for (int j = 0; j < n; j++) {
                    int value = scanner.nextInt();
                    matrix[i][j] = value;
                    
                    if (i == j) {
                        trace += value;
                    }
                    
                    if (!rowSet.add(value) && !rowDuplicate) {
                        duplicateRows++;
                        rowDuplicate = true;
                    }
                }
            }
            
            // Check for duplicate columns
            for (int j = 0; j < n; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                boolean colDuplicate = false;
                
                for (int i = 0; i < n; i++) {
                    int value = matrix[i][j];
                    
                    if (!colSet.add(value) && !colDuplicate) {
                        duplicateCols++;
                        colDuplicate = true;
                    }
                }
            }
            
            System.out.println("Case #" + t + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
        
        scanner.close();
    }
}