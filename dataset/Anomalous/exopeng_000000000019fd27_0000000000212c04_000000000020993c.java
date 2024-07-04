import java.io.*;
import java.util.*;

public class Vestigium {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        int cases = Integer.parseInt(reader.readLine());
        
        for (int i = 1; i <= cases; i++) {
            int n = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[n][n];
            
            for (int row = 0; row < n; row++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = Integer.parseInt(tokenizer.nextToken());
                }
            }
            
            int traceValue = calculateTrace(matrix);
            int repeatedRows = countRepeatedRows(matrix);
            int repeatedCols = countRepeatedCols(matrix);
            
            writer.printf("Case #%d: %d %d %d%n", i, traceValue, repeatedRows, repeatedCols);
        }
        
        writer.close();
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
            if (containsDuplicates(row)) {
                count++;
            }
        }
        return count;
    }
    
    private static int countRepeatedCols(int[][] matrix) {
        int count = 0;
        for (int col = 0; col < matrix.length; col++) {
            int[] column = new int[matrix.length];
            for (int row = 0; row < matrix.length; row++) {
                column[row] = matrix[row][col];
            }
            if (containsDuplicates(column)) {
                count++;
            }
        }
        return count;
    }
    
    private static boolean containsDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}