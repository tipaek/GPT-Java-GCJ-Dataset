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
         int n = Integer.parseInt(st.readLine());
         ArrayList<int[]>[] list = new ArrayList[1441];
         for(int i = 0; i < 1441; i++)
            list[i] = new ArrayList<int[]>();
         int[] timeline = new int[1441];
         for(int i = 0; i < n; i++)
         {
            StringTokenizer s = new StringTokenizer(st.readLine());
            int x = Integer.parseInt(s.nextToken());
            int y = Integer.parseInt(s.nextToken());
            list[x].add(new int[]{i, y});
            timeline[x]++;
            timeline[y]--;
         }
         if(timeline[0] > 2)
         {
            System.out.println("Case #"+curc+": IMPOSSIBLE");
            continue nextcase;
         }
         for(int i = 1; i < 1441; i++)
         {
            timeline[i] += timeline[i-1];
            if(timeline[i] > 2)
            {
               System.out.println("Case #"+curc+": IMPOSSIBLE");
               continue nextcase;
            }
         }
         char[] arr = new char[n];
         int clast = 0;
         int jlast = 0;
         for(int i = 0; i < 1441; i++)
         {
            if(list[i].size() == 0) continue;
            else if(list[i].size() == 2)
            {
               clast = list[i].get(0)[1];
               arr[list[i].get(0)[0]] = 'C';
               jlast = list[i].get(1)[1];
               arr[list[i].get(1)[0]] = 'J';
            }
            else
            {
               if(clast <= i)
               {
                  clast = list[i].get(0)[1];
                  arr[list[i].get(0)[0]] = 'C';
               }
               else
               {
                  jlast = list[i].get(0)[1];
                  arr[list[i].get(0)[0]] = 'J';
               }
            }
         }

         System.out.println("Case #"+curc+": "+(new String(arr)));
      }
   }
}