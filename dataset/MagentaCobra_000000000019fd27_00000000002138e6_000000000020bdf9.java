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
         outer:for(int qw=1; qw <= T; qw++)
         {
            int N = Integer.parseInt(infile.readLine());
            Thing[] arr = new Thing[N];
            for(int i=0; i < N; i++)
            {
               st = new StringTokenizer(infile.readLine());
               int a = Integer.parseInt(st.nextToken());
               int b = Integer.parseInt(st.nextToken());
               arr[i] = new Thing(a,b,i);
            }
            Arrays.sort(arr);
            char[] res = new char[N];
            int pc = 0;
            int pj = 1;
            res[arr[0].i] = 'C';
            res[arr[1].i] = 'J';
            for(int i=2; i < N; i++)
            {
               if(overlap(arr[i],arr[pc]) && overlap(arr[i],arr[pj]))
               {
                  sb.append("Case #"+qw+": IMPOSSIBLE\n");
                  continue outer;
               }
               if(overlap(arr[i],arr[pc]))
               {
                  res[arr[i].i] = 'J';
                  pj = i;
               }
               else
               {
                  res[arr[i].i] = 'C';
                  pc = i;
               }
            }
            sb.append("Case #"+qw+": ");
            for(char c: res)
               sb.append(c);
            sb.append("\n");
         }
         System.out.print(sb);
      }
      public static boolean overlap(Thing x, Thing y)
      {
         if(x.a >= y.b)
            return false;
         if(y.a >= x.b)
            return false;
         return true;
      }
   }
   class Thing implements Comparable<Thing>
   {
      public int a;
      public int b;
      public int i;
      
      public Thing(int x, int y, int z)
      {
         a = x;
         b = y;
         i = z;
      }
      public int compareTo(Thing oth)
      {
         if(a == oth.a)
            return b-oth.b;
         return a-oth.a;
      }
   }