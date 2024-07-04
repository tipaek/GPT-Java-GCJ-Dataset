import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int test = 1; test <= testCases; test++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            analyzeMatrix(matrix, test);
        }
    }
    
    public static void analyzeMatrix(int[][] matrix, int testCaseNumber) {
        int trace = 0, duplicateRows = 0, duplicateColumns = 0;
        
        if (matrix == null || matrix.length == 0) {
            System.out.println("Case #" + testCaseNumber + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
            return;
        }
        
        // Calculate trace
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        
        // Check for duplicate elements in rows
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < matrix[i].length; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    duplicateRows++;
                    break;
                }
            }
        }
        
        // Check for duplicate elements in columns
        for (int j = 0; j < matrix[0].length; j++) {
            Set<Integer> columnSet = new HashSet<>();
            for (int i = 0; i < matrix.length; i++) {
                if (!columnSet.add(matrix[i][j])) {
                    duplicateColumns++;
                    break;
                }
            }
        }
        
        System.out.println("Case #" + testCaseNumber + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
    }
}