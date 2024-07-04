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
         int u = Integer.parseInt(st.readLine());
         ArrayList<String>[] data = new ArrayList[100];
         for(int i = 0; i < 100; i++)
         {
            data[i] = new ArrayList<String>();
         }
         for(int i = 0; i < 10000; i++)
         {
            StringTokenizer s = new StringTokenizer(st.readLine());
            data[Integer.parseInt(s.nextToken())].add(s.nextToken());
         }
         HashSet<String> set = new HashSet<String>();
         String[] ans = new String[11];
         for(int i = 1; i <= 10; i++)
         {
            for(String j : data[i])
            {
               if(!set.contains(j))
               {
                  ans[i] = j;
                  set.add(j);
                  break;
               }
            }
         }
         ans[0] = ""+ans[10].charAt(1);
         System.out.print("Case #"+cur_c+": ");
         for(int i = 0; i < 10; i++)
         {
            System.out.print(ans[i]);
         }
         System.out.println("");
      }
   }
}
