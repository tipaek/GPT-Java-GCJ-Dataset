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
         int[] start = new int[N];
         int[] end = new int[N];
         int[] index = new int[N];
         char[] parent = new char[N];
         boolean isPossible = true;
         
         for (int j = 0; j < N; ++j)
         {
            start[j] = in.nextInt();
            end[j]   = in.nextInt();
            index[j] = j;
         }
         
         int camFree = 0;
         int jamFree = 0;
         int temp;
         
         for (int j = 0; j < N; ++j)
         {
            int minStartTime = start[j];
            int minIndex     = j;
            
            for (int k = j + 1; k < N; ++k)
            {
                if (minStartTime > start[k])
                {
                    minStartTime = start[k];
                    minIndex = k;
                }
            }

            if (camFree <= start[minIndex])
            {
                camFree = end[minIndex];
                parent[index[minIndex]] = 'C';
            }
            else if (jamFree <= start[minIndex])
            {
                jamFree = end[minIndex];
                parent[index[minIndex]] = 'J';
            }
            else
            {
                isPossible = false;
                break;
            }
            
            temp = start[j];
            start[j] = start[minIndex];
            start[minIndex] = temp;
            
            temp = end[j];
            end[j] = end[minIndex];
            end[minIndex] = temp;
            
            temp = index[j];
            index[j] = index[minIndex];
            index[minIndex] = temp;
         }
    
         StringBuilder result = new StringBuilder();
         
         if (isPossible)
         {
            for (int j = 0; j < N; ++j)
                result.append(parent[j]);
         }
         else
            result.append("IMPOSSIBLE");

         
         System.out.println("Case #" + i + ": " + result);
      }
   }
}
