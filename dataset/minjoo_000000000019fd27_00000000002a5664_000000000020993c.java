import java.util.*;
import java.io.*;

public class Solution {
   public static void main (String[] args)
   {
   
      
      Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      int numTestCase = scanner.nextInt();
      for(int i = 1; i <= numTestCase; i++)
      {
         int N = scanner.nextInt();
         int[][] matrix = new int[N][N];
         for(int k = 0; k < N; k++)
         {
            for(int j = 0; j < N; j++)
            {
              matrix[k][j] = scanner.nextInt();
            }
         }
         
          System.out.println("Case #" + i + ": " + trace(matrix, N) +" "+ row(matrix, N)+" " + column(matrix, N)); 
      }
      scanner.close();
    // System.out.println("Case #1: 4 0 0");
   }
   
   
   public static int trace(int[][] matrix, int N)
   {
      int result = 0;
      for (int i = 0; i < N; i++)
      {
         result += matrix[i][i];
      }
      return result;
   }
   
   public static int row(int[][] matrix, int N)//# of rows w repeated
   {
   
    int result = 0;
      for(int j = 0; j < N; j++)
      {
         Set<Integer> s = new HashSet<Integer>();
         for(int x : matrix[j])
         {
            if(s.add(x) == false)
            {
               result++;
               break;
            }
         }  
               
         
      }
      return result;
   }
   
   public static int column(int[][] matrix, int N)
   {
      int result = 0;
      for(int j = 0; j < N; j++)
      {
         Set<Integer> s = new HashSet<Integer>();
         for (int i = 0; i < N; i++)
         {
         
            if(s.add(matrix[i][j]) == false)
            {
               result++ ;
               break;
            }
         }
      }
      return result;
   }
}