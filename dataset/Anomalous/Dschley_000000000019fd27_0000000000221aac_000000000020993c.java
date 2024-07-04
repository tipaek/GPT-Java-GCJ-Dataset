import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            
            int trace = calculateTrace(matrix);
            int repeatedRows = countRepeatedRows(matrix);
            int repeatedCols = countRepeatedCols(matrix);
            
            System.out.println("Case #" + caseNumber + ": " + trace + " " + repeatedRows + " " + repeatedCols);
        }
    }
    
    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }
    
    private static int countRepeatedRows(int[][] matrix) {
        int repeatedRows = 0;
        for (int[] row : matrix) {
            if (hasDuplicates(row)) {
                repeatedRows++;
            }
        }
        return repeatedRows;
    }
    
    private static int countRepeatedCols(int[][] matrix) {
        int repeatedCols = 0;
        for (int col = 0; col < matrix.length; col++) {
            int[] columnArray = new int[matrix.length];
            for (int row = 0; row < matrix.length; row++) {
                columnArray[row] = matrix[row][col];
            }
            if (hasDuplicates(columnArray)) {
                repeatedCols++;
            }
        }
        return repeatedCols;
    }
    
    private static boolean hasDuplicates(int[] array) {
        Set<Integer> uniqueValues = new HashSet<>();
        for (int value : array) {
            if (!uniqueValues.add(value)) {
                return true;
            }
        }
        return false;
    }
}