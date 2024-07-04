import java.util.Scanner;
import java.io.IOException;

class Solution {
    public static int countDuplicateRows(int[][] matrix) {
        int duplicateRowCount = 0;
        
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> rowElements = new HashSet<>();
            boolean hasDuplicate = false;
            
            for (int j = 0; j < matrix[i].length; j++) {
                if (!rowElements.add(matrix[i][j])) {
                    hasDuplicate = true;
                }
            }
            
            if (hasDuplicate) {
                duplicateRowCount++;
            }
        }
        
        return duplicateRowCount;
    }

    public static int countDuplicateColumns(int[][] matrix) {
        int duplicateColumnCount = 0;
        
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> columnElements = new HashSet<>();
            boolean hasDuplicate = false;
            
            for (int j = 0; j < matrix.length; j++) {
                if (!columnElements.add(matrix[j][i])) {
                    hasDuplicate = true;
                }
            }
            
            if (hasDuplicate) {
                duplicateColumnCount++;
            }
        }
        
        return duplicateColumnCount;
    }

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            
            for (int t = 1; t <= testCases; t++) {
                int n = scanner.nextInt();
                int[][] matrix = new int[n][n];
                int diagonalSum = 0;
                
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = scanner.nextInt();
                        if (i == j) {
                            diagonalSum += matrix[i][j];
                        }
                    }
                }
                
                int duplicateRows = countDuplicateRows(matrix);
                int duplicateColumns = countDuplicateColumns(matrix);
                
                System.out.printf("Case #%d: %d %d %d%n", t, diagonalSum, duplicateRows, duplicateColumns);
            }
        } catch (Exception e) {
            System.out.println("An error occurred.");
        }
    }
}