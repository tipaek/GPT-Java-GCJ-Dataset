import java.util.*;
import java.io.*;

public class Solution
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
              
      int t = in.nextInt();
      for (int i = 1; i <= t; ++i)
      {
        int N = in.nextInt();
         
        int[][] M = new int[N][N];
        int rows    = 0;
        int columns = 0;
        int trace   = 0;
         
         for (int r = 0; r < N; ++r)
            for (int c = 0; c < N; ++c)
               M[r][c] = in.nextInt();
               
        for (int r = 0; r < N; ++r)
        {
            trace += M[r][r];
            int rowValues[] = new int[N + 1];
            for (int c = 0; c < N; ++c)
            {
               if (rowValues[M[r][c]] > 0)
               {
                  rows++;
                  break;
               }
               
               rowValues[M[r][c]]++;
            }
            
            int columnValues[] = new int[N + 1];
            for (int c = 0; c < N; ++c)
            {
               if (columnValues[M[c][r]] > 0)
               {
                  columns++;
                  break;
               }
               
               columnValues[M[c][r]]++;
            }
        }

        System.out.println("Case #" + i + ": " + trace + " " + rows + " " + columns);
      }
   }
}
