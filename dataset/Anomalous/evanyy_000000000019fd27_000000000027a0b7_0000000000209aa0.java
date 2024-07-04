import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[][] matrix = generateMatrix(n, k);
            
            if (matrix == null) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": POSSIBLE");
                printMatrix(matrix);
            }
        }
    }
    
    private static int[][] generateMatrix(int n, int k) {
        int attempts = 0;
        int[][] matrix = new int[n][n];
        Random random = new Random();
        
        while (attempts < 300000) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 1 + random.nextInt(n);
                }
            }
            
            if (isValidMatrix(matrix, k)) {
                return matrix;
            }
            
            attempts++;
        }
        
        return null;
    }
    
    private static boolean isValidMatrix(int[][] matrix, int targetTrace) {
        return countRepeatedRows(matrix) == 0 && countRepeatedColumns(matrix) == 0 && calculateTrace(matrix) == targetTrace;
    }
    
    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }
    
    private static int countRepeatedRows(int[][] matrix) {
        int count = 0;
        for (int[] row : matrix) {
            if (hasDuplicates(row)) {
                count++;
            }
        }
        return count;
    }
    
    private static int countRepeatedColumns(int[][] matrix) {
        int count = 0;
        for (int col = 0; col < matrix.length; col++) {
            int[] column = new int[matrix.length];
            for (int row = 0; row < matrix.length; row++) {
                column[row] = matrix[row][col];
            }
            if (hasDuplicates(column)) {
                count++;
            }
        }
        return count;
    }
    
    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
    
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}