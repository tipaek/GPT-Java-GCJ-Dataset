import java.io.*;
import java.util.*;



public class Solution
{

   public static void main(String[] args) throws IOException
   {
      BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(input.readLine());
      for(int tc = 1; tc <= T; tc++)
      {
         System.out.printf("Case #%d: ", tc);
         StringTokenizer st = new StringTokenizer(input.readLine());
         int R = Integer.parseInt(st.nextToken());
         int C = Integer.parseInt(st.nextToken());
         int[][] arr = new int[R][C];
         boolean[][] elim = new boolean[R][C];
         for(int i = 0; i < R; i++)
         {
            st = new StringTokenizer(input.readLine());
            for(int j = 0; j < C; j++)
            {
               arr[i][j] = Integer.parseInt(st.nextToken());
            }
         }
         int result = 0;
         while(true)
         {
            boolean[][] elim_tmp = new boolean[R][C];
            boolean brk = true;
            for(int i = 0; i < R; i++)
            {
               for(int j = 0; j < C; j++)
               {
                  if(elim[i][j]) continue;
                  result += arr[i][j];
                  ArrayList<Integer> neighbors = new ArrayList<Integer>();
                  int t = i - 1;
                  while(t >= 0 && elim[t][j]) t--;
                  if(t != -1) neighbors.add(arr[t][j]);
                  int b = i + 1;
                  while(b < R && elim[b][j]) b++;
                  if(b != R) neighbors.add(arr[b][j]);
                  int l = j - 1;
                  while(l >= 0 && elim[i][l]) l--;
                  if(l != -1) neighbors.add(arr[i][l]);
                  int r = j + 1;
                  while(r < C && elim[i][r]) r++;
                  if(r != C) neighbors.add(arr[i][r]);
                  int sum = 0;
                  for(int n : neighbors) sum += n;
                  if(sum > arr[i][j] * neighbors.size())
                  {
                     elim_tmp[i][j] = true;
                     brk = false;
                  }
               }
            }
            for(int i = 0; i < R; i++)
            {
               for(int j = 0; j < C; j++)
               {
                  elim[i][j] |= elim_tmp[i][j];
               }
            }
            if(brk) break;
         }
         System.out.println(result);
      }
   }

}