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
            String input = infile.readLine();
            char[] arr = input.toCharArray();
            int N = arr.length;
            ArrayList<Character> res = new ArrayList<Character>();
            int bal = 0;
            for(int i=0; i < N; i++)
            {
               int d = Integer.parseInt(arr[i]+"");
               while(bal > d)
               {
                  res.add(')');
                  bal--;
               }
               while(bal < d)
               {
                  res.add('(');
                  bal++;
               }
               res.add(arr[i]);
            }
            while(bal > 0)
            {
               res.add(')');
               bal--;
            }
            sb.append("Case #"+qw+": ");
            for(char c: res)
               sb.append(c);
            sb.append("\n");
         }
         System.out.print(sb);
      }
   }