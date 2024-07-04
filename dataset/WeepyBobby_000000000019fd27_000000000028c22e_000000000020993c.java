import java.util.*;
import java.math.*;
import java.io.*;
class Solution
{
   public static void main(String args[]) throws IOException
   {
      BufferedReader st = new BufferedReader(new InputStreamReader(System.in));
      int cases = Integer.parseInt(st.readLine());
      int curc = 0;
      while(curc++ < cases)
      {
         int n = Integer.parseInt(st.readLine());
         int[][] data = new int[n][n];
         int k = 0;
         int r = 0;
         int c = 0;
         for(int i = 0; i < n; i++)
         {
            StringTokenizer s = new StringTokenizer(st.readLine());
            for(int j = 0; j < n; j++)
               data[i][j] = Integer.parseInt(s.nextToken());
            k += data[i][i];            
         }
         for(int i = 0; i < n; i++)
         {
            boolean[] nbool = new boolean[n+1];
            for(int j = 0; j < n; j++)
            {
               if(nbool[data[i][j]])
               {
                  r++;
                  break;
               }
               nbool[data[i][j]] = true;
            }
            nbool = new boolean[n+1];
            for(int j = 0; j < n; j++)
            {
               if(nbool[data[j][i]])
               {
                  c++;
                  break;
               }
               nbool[data[j][i]] = true;
            }
         }
         System.out.println("Case #"+curc+": "+k+" "+r+" "+c);
      }
   }
}