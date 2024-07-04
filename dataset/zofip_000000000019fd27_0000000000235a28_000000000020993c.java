import java.util.*;
import java.io.*;

public class Solution {
    
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    
    int nCase = in.nextInt();
    int size = in.nextInt();
    int [][]matrix = new int[size][size];
    
    for (int row = 0; row < size; ++row) {
      for(int column = 0; column < size; ++ column){
          matrix[row][column] = in.nextInt();
      }
    }
    
    System.out.println("Case #" + nCase + ": " + getDiagonalSum(matrix) + " " + getDuplicateRows(matrix) + " " + getDuplicateColumns(matrix));
  }
  
    private static int getDiagonalSum(int[][] matrix){
        int sum = 0;
        for (int i = 0; i < matrix.length; ++i) {
          sum = sum + matrix[i][i];
        }
        return sum;
    }
  
    private static boolean containsValue(int[] arr, int value) {
      for(int i=0; i < arr.length; i++) {
          if(arr[i] == value) {
            return true;
          }
      }
      return false;
    }
  
    private static int getDuplicateRows(int[][] matrix){
        int sum = 0;
        for (int row = 0; row < matrix.length; ++row) {
            int []byRow = new int[matrix.length];
            byRow[row] = matrix[row][0];
            for(int column = 1; column < matrix.length; ++ column){
                if (containsValue(byRow, matrix[row][column])) {
                   sum = sum + 1;
                   break;
                }else {
                    byRow[column] = matrix[row][column];
                }
            }
        }
        return sum;
    }
  
    private static int getDuplicateColumns(int[][] matrix){
        int sum = 0;
        for (int column = 0; column < matrix.length; ++column) {
            int []byColumn = new int[matrix.length];
            byColumn[column] = matrix[0][column];
            for(int row = 1; row < matrix.length; ++row){
                if (containsValue(byColumn, matrix[row][column])) {
                   sum = sum + 1;
                   break;
                }else {
                    byColumn[row] = matrix[row][column];
                }
            }
        }
        return sum;
    }
}