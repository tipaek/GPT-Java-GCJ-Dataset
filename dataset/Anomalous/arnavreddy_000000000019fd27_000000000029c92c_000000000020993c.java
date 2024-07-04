import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

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
            
            System.out.println("Case #" + i + ": " + calculateTrace(matrix, n) + " " + countDuplicateRows(matrix, n) + " " + countDuplicateColumns(matrix, n));
        }
    }
    
    public static long calculateTrace(int[][] matrix, int n) {
        long trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }
    
    public static int countDuplicateColumns(int[][] matrix, int n) {
        int duplicateCount = 0;
        
        for (int c = 0; c < n; c++) {
            boolean[] seen = new boolean[n + 1];
            for (int r = 0; r < n; r++) {
                if (seen[matrix[r][c]]) {
                    duplicateCount++;
                    break;
                }
                seen[matrix[r][c]] = true;
            }
        }
        
        return duplicateCount;
    }
    
    public static int countDuplicateRows(int[][] matrix, int n) {
        int duplicateCount = 0;
        
        for (int r = 0; r < n; r++) {
            boolean[] seen = new boolean[n + 1];
            for (int c = 0; c < n; c++) {
                if (seen[matrix[r][c]]) {
                    duplicateCount++;
                    break;
                }
                seen[matrix[r][c]] = true;
            }
        }
        
        return duplicateCount;
    }
}