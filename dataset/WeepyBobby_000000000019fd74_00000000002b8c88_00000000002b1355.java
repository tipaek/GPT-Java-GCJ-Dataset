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
      nextcase:
      while(curc++ < cases)
      {
         StringTokenizer s = new StringTokenizer(st.readLine());
         int r = Integer.parseInt(s.nextToken());
         int c = Integer.parseInt(s.nextToken());
         int[][][] data = new int[r][c][2];
         for(int i = 0; i < r; i++)
         {
            s = new StringTokenizer(st.readLine());
            for(int j = 0; j < c; j++)
            {
               data[i][j][0] = Integer.parseInt(s.nextToken());
               data[i][j][1] = data[i][j][0];
               
            }
         }
         long sum = 0;
         while(true)
         {
            int eliminated = 0;
            for(int i = 0; i < r; i++)
            {
               for(int j = 0; j < c; j++)
               {
                  if(data[i][j][0] == 0) continue;
                  int neighbors = 0;
                  long neighbors_total = 0;
                  for(int k = i-1; k >= 0; k--)
                  {
                     if(data[k][j][0] != 0)
                     {
                        neighbors++;
                        neighbors_total += data[k][j][0];
                        break;
                     }
                  }
                  for(int k = i+1; k < r; k++)
                  {
                     if(data[k][j][0] != 0)
                     {
                        neighbors++;
                        neighbors_total += data[k][j][0];
                        break;
                     }
                  }
                  for(int k = j-1; k >= 0; k--)
                  {
                     if(data[i][k][0] != 0)
                     {
                        neighbors++;
                        neighbors_total += data[i][k][0];
                        break;
                     }
                  }
                  for(int k = j+1; k < c; k++)
                  {
                     if(data[i][k][0] != 0)
                     {
                        neighbors++;
                        neighbors_total += data[i][k][0];
                        break;
                     }
                  }
                  sum += data[i][j][0];
                  if((long)data[i][j][0]*neighbors >= neighbors_total)
                  {
                     data[i][j][1] = data[i][j][0];
                  }
                  else
                  {
                     eliminated++;
                     data[i][j][1] = 0;
                  }
               }
            }
            //System.out.println("After this round: "+sum);
            if(eliminated == 0)
               break;
            for(int i = 0; i < r; i++)
            {
               for(int j = 0; j < c; j++)
               {
                  data[i][j][0] = data[i][j][1];
               }
            }
         }
         print("Case #"+curc+": "+sum);
      }
   }
   public static void print(String str)
   {
      System.out.println(str);
      System.out.flush();
      return;
   }
   public static void print(int str)
   {
      System.out.println(str);
      System.out.flush();
      return;
   }
}
