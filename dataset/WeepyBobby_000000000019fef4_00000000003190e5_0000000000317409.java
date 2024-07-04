
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
         int x = Integer.parseInt(s.nextToken());
         int y = Integer.parseInt(s.nextToken());
         String moves = s.nextToken();
         int n = moves.length();
         for(int i = 0; i < n; i++)
         {
            char ch = moves.charAt(i);
            if(ch == 'S')
               y--;
            else if(ch == 'N')
               y++;
            else if(ch == 'E')
               x++;
            else
               x--;
            if(Math.abs(x)+Math.abs(y) <= i+1)
            {
               System.out.println("Case #"+cur_c+": "+(i+1));
               continue next_case;
            }
         }
         System.out.println("Case #"+cur_c+": IMPOSSIBLE");
               
      }
   }
}
