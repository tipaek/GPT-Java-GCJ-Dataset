import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            
            int traceValue = calculateTrace(matrix, n);
            int rowCount = countDuplicateRows(matrix, n);
            int colCount = countDuplicateCols(matrix, n);
            
            System.out.println("Case #" + caseNum + ": " + traceValue + " " + rowCount + " " + colCount);
        }
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix, int size) {
        int duplicateRowCount = 0;
        
        for (int row = 0; row < size; row++) {
            Set<Integer> seen = new HashSet<>();
            for (int col = 0; col < size; col++) {
                if (!seen.add(matrix[row][col])) {
                    duplicateRowCount++;
                    break;
                }
            }
        }
        
        return duplicateRowCount;
    }

    private static int countDuplicateCols(int[][] matrix, int size) {
        int duplicateColCount = 0;
        
        for (int col = 0; col < size; col++) {
            Set<Integer> seen = new HashSet<>();
            for (int row = 0; row < size; row++) {
                if (!seen.add(matrix[row][col])) {
                    duplicateColCount++;
                    break;
                }
            }
        }
        
        return duplicateColCount;
    }
}