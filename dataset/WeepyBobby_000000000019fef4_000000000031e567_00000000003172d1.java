import java.io.*;
import java.util.*;
class Solution {
    public static void main(String args[] ) throws Exception
    {
      BufferedReader st = new BufferedReader(new InputStreamReader(System.in));
      int cases = Integer.parseInt(st.readLine());
      int cur_c = 0;
      next_case:
      while(++cur_c <= cases)
      {
         StringTokenizer s = new StringTokenizer(st.readLine());
         int n = Integer.parseInt(s.nextToken());
         int d = Integer.parseInt(s.nextToken());
         long[] data = new long[n];
         s = new StringTokenizer(st.readLine());
         for(int i = 0; i < n; i++)
         {
            data[i] = Long.parseLong(s.nextToken())*360L;
         }
         Arrays.sort(data);
         int same = 1;
         for(int i = 0; i < n; i++)
         {
            int cur = 1;
            for(int j = i+1; j < n; j++)
            {
               if(data[i] == data[j]) cur++;
            }
            same = Math.max(same, cur);
         }
         if(d == 2)
         {
            if(same >= 2) printAns(cur_c, 0);
            else printAns(cur_c, 1);
         }
         else if(d == 3)
         {
            if(same >= 3) printAns(cur_c, 0);
            boolean val = false;
            for(int i = 0; i < n; i++)
            {
               if(Arrays.binarySearch(data, data[i]*2) >= 0)
               {
                  printAns(cur_c, 1);
                  val = true;
                  break;
               }
            }
            if(!val)
            {
               printAns(cur_c, 2);
            }
         }
      }
   }

   public static void printAns(int cas, int ans)
   {
      System.out.println("Case #"+cas+": "+ans);
      return;
   }
}
