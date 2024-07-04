import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    
    for (int x = 1; x <= t; ++x) {
      int dim = in.nextInt();
      
      int[][] matrix = new int[dim][dim];
      
      int k = 0;
      int r = 0;
      int c = 0;
      
      for(int i = 0; i < matrix.length; i++)
          for(int j = 0; j < matrix[i].length; j++)
              matrix[i][j] = in.nextInt();
              
      for(int i = 0; i < matrix.length; i++)
          for(int j = 0; j < matrix[i].length; j++)
             if(rowContains(matrix, i, matrix[i][j])){
                r += 1;
                break;
             }
             
      for(int i = 0; i < matrix.length; i++)
          for(int j = 0; j < matrix[i].length; j++)
             if(columnContains(matrix, j, matrix[j][i])){
                c += 1;
                break;
             }
             
      for(int i = 0; i < matrix.length; i++)
          k += matrix[i][i];
      
      System.out.println("Case #" + x + ": " + k + " " + r + " " + c);
    }
  }
  
  private static boolean rowContains(int[][] matrix, int row, int val){
      int counter = 0;
      for(int i = 0; i < matrix[row].length; i++){
          if(matrix[row][i] == val)
            counter += 1;
      }
      
      return counter >= 2;
  }
  
  private static boolean columnContains(int[][] matrix, int col, int val){
      int counter = 0;
      for(int i = 0; i < matrix.length; i++){
          if(matrix[i][col] == val)
            counter += 1;
      }
      
      return counter >= 2;
  }
}