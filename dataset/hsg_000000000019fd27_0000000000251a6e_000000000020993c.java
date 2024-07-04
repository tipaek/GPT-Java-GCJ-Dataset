import java.util.*;
import java.io.*;


public class Solution {
    static Scanner in;
    
    public static void main(String[] args) {
        in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int matrixSize = in.nextInt();
            int [] results = calc(matrixSize);
            System.out.println(String.format(
                "Case #%d: %d %d %d",
                i, results[0], results[1], results[2]));
        }
    }
    
    public static int[] calc(int matrixSize) {
        int [][] matrix = load(matrixSize);
        
        int rowsWithRepeted = calcRows(matrix);
        int colsWithRepeted = calcCols(matrix);
        int diagonalSum = calcDiagonal(matrix);
        
        return new int[] {diagonalSum, rowsWithRepeted, colsWithRepeted};
    }
    
    public static int[][] load(int matrixSize) {
        int[][] matrix = new int[matrixSize][matrixSize];
        for (int row = 0; row < matrixSize; row++) {
            for (int col = 0; col < matrixSize; col++) {
                matrix[row][col] = in.nextInt();   
            }
        }
        return matrix;
    }
    
    public static int calcRows (int[][] matrix) {
        int count = 0; 
        for (int row = 0; row < matrix.length; row++) {
            Set<Integer> rowValues = new HashSet<>();
            for (int col = 0; col < matrix.length; col++) {
                   rowValues.add(matrix[row][col]);
            }
            
            if (rowValues.size() != matrix.length) {
                count++;
            }
        }
        return count;
    }
    
    public static int calcCols (int[][] matrix) {
        int count = 0;
        for (int col = 0; col < matrix.length; col++) {
            Set<Integer> colValues = new HashSet<>();
            for (int row = 0; row < matrix.length; row++) {
                   colValues.add(matrix[row][col]);
            }
            
            if (colValues.size() != matrix.length) {
                count++;
            }
        }
        return count;
    }
    
    public static int calcDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }
   
  
}
  