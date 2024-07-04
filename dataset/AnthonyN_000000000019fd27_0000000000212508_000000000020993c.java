import java.util.*;

public class Solution{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    
    int numOfTestCases = Integer.valueOf(in.nextLine());
    for(int i = 0; i < numOfTestCases; i++){
      int matrixSize = Integer.valueOf(in.nextLine());
      
      // Creates matrix
      int[][] matrix = fillMatrix(matrixSize, in);
      
      // Calculates trace
      int trace = calcTrace(matrix);
      
      // Calculates number of rows with repeated elements
      int repeatsRow = findRepeatsInRows(matrix);
      
      // Calculates number of columns with repeated elements
      int repeatsCol = findRepeatsInCols(matrix);
      
      System.out.println("Case #" + (i + 1) + ": " + trace + " " + repeatsRow + " " + repeatsCol);
    }
  }
  
  private static int[][] fillMatrix(int size, Scanner in){
    int[][] matrix = new int[size][size];
    
    for(int i = 0; i < matrix.length; i++){
        String[] row = in.nextLine().split(" ");
        
        for(int j = 0; j < matrix.length; j++)
          matrix[i][j] = Integer.valueOf(row[j]);
      }
    
    return matrix;
  }
  
  private static int calcTrace(int[][] matrix){
    int trace = 0;
    for(int i = 0; i < matrix.length; i++)
      trace += matrix[i][i];
    
    return trace;
  }
  
  private static int findRepeatsInRows(int[][] matrix){
    int count = 0;
    for(int[] row : matrix)
      if(hasRepeats(row))
        count++;
    
    return count;
  }
  
  private static int findRepeatsInCols(int[][] matrix){
    int count = 0;
    
    for(int c = 0; c < matrix.length; c++){
      int[] col = new int[matrix.length];
      for(int i = 0; i < matrix.length; i++)
        col[i] = matrix[i][c];
      
      if(hasRepeats(col))
        count++;
    }
    
    return count;
  }
  
  private static boolean hasRepeats(int[] arr){
    for(int i = 0; i < arr.length - 1; i++)
      for(int j = i + 1; j < arr.length; j++)
        if(arr[i] == arr[j])
          return true;
    
    return false;
  }
}