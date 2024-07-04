import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        int caseCount = Integer.parseInt(reader.readLine());
        
        for (int i = 0; i < caseCount; i++) {
            int n = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[n][n];
            
            for (int j = 0; j < n; j++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = Integer.parseInt(tokenizer.nextToken());
                }
            }
            
            StringBuilder result = new StringBuilder();
            result.append("Case #").append(i + 1).append(": ")
                  .append(calculateTrace(matrix)).append(" ")
                  .append(countRepeatedRows(matrix)).append(" ")
                  .append(countRepeatedColumns(matrix));
            
            writer.println(result.toString());
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
        int n = matrix.length;
        for (int col = 0; col < n; col++) {
            int[] column = new int[n];
            for (int row = 0; row < n; row++) {
                column[row] = matrix[row][col];
            }
            if (hasDuplicates(column)) {
                repeatedColumns++;
            }
        }
        return repeatedColumns;
    }
    
    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }
}