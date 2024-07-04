import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    matrix[r][c] = scanner.nextInt();
                }
            }
            
            System.out.printf("Case #%d: %d %d %d%n", i, calculateTrace(matrix, n), countDuplicateRows(matrix, n), countDuplicateColumns(matrix, n));
        }
        
        scanner.close();
    }
    
    private static long calculateTrace(int[][] matrix, int n) {
        long trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }
    
    private static int countDuplicateRows(int[][] matrix, int n) {
        int duplicateRowCount = 0;
        
        for (int r = 0; r < n; r++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int c = 0; c < n; c++) {
                if (!rowSet.add(matrix[r][c])) {
                    duplicateRowCount++;
                    break;
                }
            }
        }
        
        return duplicateRowCount;
    }
    
    private static int countDuplicateColumns(int[][] matrix, int n) {
        int duplicateColumnCount = 0;
        
        for (int c = 0; c < n; c++) {
            Set<Integer> colSet = new HashSet<>();
            for (int r = 0; r < n; r++) {
                if (!colSet.add(matrix[r][c])) {
                    duplicateColumnCount++;
                    break;
                }
            }
        }
        
        return duplicateColumnCount;
    }
}