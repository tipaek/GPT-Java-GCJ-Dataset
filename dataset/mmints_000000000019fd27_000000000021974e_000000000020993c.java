import java.io.*;
import java.util.*;



public class Solution
{

   public static void main(String[] args) throws IOException
   {
      BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(input.readLine());
      for(int t = 0; t < T; t++)
      {
         int N = Integer.parseInt(input.readLine());
         int[][] arr = new int[N][N];
         for(int i = 0; i < N; i++)
         {
            StringTokenizer st = new StringTokenizer(input.readLine());
            for(int j = 0; j < N; j++)
            {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
         }
         int trace = 0;
         for(int i = 0; i < N; i++) trace += arr[i][i];
         int reprows = 0;
         for(int i = 0; i < N; i++)
         {
            HashSet<Integer> prev = new HashSet<Integer>();
            boolean repeats = false;
            for(int j = 0; j < N; j++)
            {
               if(prev.contains(arr[i][j]))
               {
                  repeats = true;
                  break;
               }
               prev.add(arr[i][j]);
            }
            if(repeats) reprows++;
         }
         int repcols = 0;
         for(int j = 0; j < N; j++)
         {
            HashSet<Integer> prev = new HashSet<Integer>();
            boolean repeats = false;
            for(int i = 0; i < N; i++)
            {
               if(prev.contains(arr[i][j]))
               {
                  repeats = true;
                  break;
               }
               prev.add(arr[i][j]);
            }
            if(repeats) repcols++;
         }
         System.out.printf("Case #%d: %d %d %d\n", t + 1, trace, reprows, repcols);
      }   
   }

}