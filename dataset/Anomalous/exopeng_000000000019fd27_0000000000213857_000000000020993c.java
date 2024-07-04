import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        
        int cases = Integer.parseInt(reader.readLine().trim());
        
        for (int i = 0; i < cases; i++) {
            int n = Integer.parseInt(reader.readLine().trim());
            int[][] matrix = new int[n][n];
            
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(reader.readLine());
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            
            String result = String.format("Case #%d: %d %d %d", 
                                          i + 1, 
                                          calculateTrace(matrix), 
                                          countRepeatedRows(matrix), 
                                          countRepeatedColumns(matrix));
                                          
            writer.println(result);
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
        int repeatedRows = 0;
        for (int[] row : matrix) {
            if (hasDuplicates(row)) {
                repeatedRows++;
            }
        }
        return repeatedRows;
    }
    
    private static int countRepeatedColumns(int[][] matrix) {
        int repeatedColumns = 0;
        for (int col = 0; col < matrix.length; col++) {
            int[] column = new int[matrix.length];
            for (int row = 0; row < matrix.length; row++) {
                column[row] = matrix[row][col];
            }
            if (hasDuplicates(column)) {
                repeatedColumns++;
            }
        }
        return repeatedColumns;
    }
    
    private static boolean hasDuplicates(int[] array) {
        Set<Integer> uniqueElements = new HashSet<>();
        for (int element : array) {
            if (!uniqueElements.add(element)) {
                return true;
            }
        }
        return false;
    }
}