import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            int trace = calculateTrace(matrix, n);
            int rowDuplicates = countRowDuplicates(matrix, n);
            int colDuplicates = countColDuplicates(matrix, n);
            
            System.out.printf("Case #%d: %d %d %d%n", t + 1, trace, rowDuplicates, colDuplicates);
        }
    }
    
    private static int calculateTrace(int[][] matrix, int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }
    
    private static int countRowDuplicates(int[][] matrix, int n) {
        int duplicateRows = 0;
        for (int i = 0; i < n; i++) {
            HashSet<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!uniqueElements.add(matrix[i][j])) {
                    duplicateRows++;
                    break;
                }
            }
        }
        return duplicateRows;
    }
    
    private static int countColDuplicates(int[][] matrix, int n) {
        int duplicateCols = 0;
        for (int j = 0; j < n; j++) {
            HashSet<Integer> uniqueElements = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (!uniqueElements.add(matrix[i][j])) {
                    duplicateCols++;
                    break;
                }
            }
        }
        return duplicateCols;
    }
}