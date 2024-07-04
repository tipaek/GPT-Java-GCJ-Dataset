import java.io.*;
import java.util.*;

public class Solution {
    
    static public void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine().replaceAll("\\s+$", ""));
        
        for (int i = 0; i < testCases; i++) {
            int size = Integer.parseInt(bufferedReader.readLine().replaceAll("\\s+$", ""));
            int[][] matrix = new int[size][size];
            for (int row = 0; row < size; row++) {
                String[] matrixLine = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
                for (int col = 0; col < size; col++) {
                   matrix[row][col] = Integer.parseInt(matrixLine[col]); 
                }
            }
            int[] solution = solve(matrix);
            System.out.println("Case #" + (i + 1) + ": " + solution[0] + " " + solution[1] + " " + solution[2]);
        }
    }
    
    static private int[] solve(int[][] matrix) {
        int[] result = new int[3];
        
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        
        int repeatedRows = 0;
        int repeatedCols = 0;
        
        for (int row = 0; row < matrix.length; row++) {
            Set<Integer> currRow = new HashSet<>();
            for (int col = 0; col < matrix.length; col++) {
                int value = matrix[row][col];
                if (currRow.contains(value)) {
                    repeatedRows++;
                    break;
                }
                currRow.add(value);
            }   
        }
        
        for (int col = 0; col < matrix.length; col++) {
            Set<Integer> currCol = new HashSet<>();
            for (int row = 0; row < matrix.length; row++) {
                int value = matrix[row][col];
                if (currCol.contains(value)) {
                    repeatedCols++;
                    break;
                }
                currCol.add(value);
            }   
        }
        
        result[0] = trace;
        result[1] = repeatedRows;
        result[2] = repeatedCols;
        return result;
    }
}