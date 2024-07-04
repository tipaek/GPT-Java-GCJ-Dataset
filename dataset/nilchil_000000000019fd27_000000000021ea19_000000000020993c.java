import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int cases = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    
    for(int i=0; i<cases; i++)
    {
        int sameRow = 0;
        int sameCol = 0;
        
        int N = in.nextInt();
        int[][] currentArr = new int[N][N];
        
        for(int row=0; row<N; row++)
        {
            for(int col=0; col<N; col++)
            {
                currentArr[row][col] = in.nextInt();
            }
        }
        
        sameRow = sameRows(currentArr);
        sameCol = sameCols(currentArr);
        int trace = calcTrace(currentArr);
        
        int num = i+1;
        
        System.out.println("Case #" + num + ": " +
            trace + " " + sameRow + " " + sameCol);
        
    }
    
  }
  
  public static int calcTrace(int[][] arr)
  {
      int trace = 0;
      
      for(int i=0; i<arr.length; i++)
      {
          trace+=arr[i][i];
      }
      
      return trace;
  }
  
  public static int sameRows(int[][] arr)
  {
      int sameRow = 0;
      
      for(int row=0; row<arr.length; row++)
      {
          for(int col=0; col<arr.length-1; col++)
          {
              if(arr[row][col]==arr[row][col+1]) sameRow++;
          }
      }
      return sameRow;
  }
  
  public static int sameCols(int[][] arr)
  {
      int sameCol = 0;

      for(int col=0; col<arr.length; col++)
      {
          for(int row=0; row<arr.length-1; row++)
          {
              if(arr[row][col]==arr[row+1][col]) sameCol++;
          }
      }
      return sameCol;
  }
}

