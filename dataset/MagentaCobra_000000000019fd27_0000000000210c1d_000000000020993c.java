/*
If you want to aim high, aim high
Don't let that studying and grades consume you
Just live life young
******************************
If I'm the sun, you're the moon
Because when I go up, you go down
*******************************
I'm working for the day I will surpass you
https://www.a2oj.com/Ladder16.html
*/
import java.util.*;
import java.io.*;
import java.math.*;

   public class Solution
   {
      public static void main(String omkar[]) throws Exception
      {
         BufferedReader infile = new BufferedReader(new InputStreamReader(System.in));  
         StringTokenizer st = new StringTokenizer(infile.readLine());
         int T = Integer.parseInt(st.nextToken());
         StringBuilder sb = new StringBuilder();
         for(int qw=1; qw <= T; qw++)
         {
            int N = Integer.parseInt(infile.readLine());
            int[][] grid = new int[N][N];
            for(int i=0; i < N; i++)
               grid[i] = readArr(N, infile, st);
            long sum = 0L;
            for(int i=0; i < N; i++)
               sum += grid[i][i];
            int rc = 0;
            for(int r=0; r < N; r++)
            {
               HashSet<Integer> set = new HashSet<Integer>();
               for(int c=0; c < N; c++)
                  set.add(grid[r][c]);
               if(set.size() < N)
                  rc++;
            }
            int cc = 0;
            for(int c=0; c < N; c++)
            {
               HashSet<Integer> set = new HashSet<Integer>();
               for(int r=0; r < N; r++)
                  set.add(grid[r][c]);
               if(set.size() < N)
                  cc++;
            }
            sb.append("Case #"+qw+": "+sum+" "+rc+" "+cc);
            sb.append("\n");
         }
         System.out.print(sb);
      }
      //input shenanigans
      public static int[] readArr(int N, BufferedReader infile, StringTokenizer st) throws Exception
      {
         int[] arr = new int[N];
         st = new StringTokenizer(infile.readLine());
         for(int i=0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
         return arr;
      }
   }