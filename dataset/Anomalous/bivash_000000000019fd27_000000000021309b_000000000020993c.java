import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        String[] results = new String[t];
        
        for (int a = 0; a < t; a++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            int trace = calculateTrace(matrix);
            int duplicateRows = countDuplicateRows(matrix);
            int duplicateCols = countDuplicateCols(matrix);
            
            results[a] = String.format("Case #%d: %d %d %d", a + 1, trace, duplicateRows, duplicateCols);
        }
        
        for (String result : results) {
            System.out.println(result);
        }
        
        scanner.close();
    }
    
    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }
    
    private static int countDuplicateRows(int[][] matrix) {
        int duplicateRowCount = 0;
        
        for (int[] row : matrix) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int element : row) {
                if (!uniqueElements.add(element)) {
                    duplicateRowCount++;
                    break;
                }
            }
        }
        
        return duplicateRowCount;
    }
    
    private static int countDuplicateCols(int[][] matrix) {
        int duplicateColCount = 0;
        
        for (int col = 0; col < matrix.length; col++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int row = 0; row < matrix.length; row++) {
                if (!uniqueElements.add(matrix[row][col])) {
                    duplicateColCount++;
                    break;
                }
            }
        }
        
        return duplicateColCount;
    }
}