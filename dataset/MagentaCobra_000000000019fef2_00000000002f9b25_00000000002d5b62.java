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
            st = new StringTokenizer(infile.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            sb.append("Case #"+qw+": ");
            boolean north = true;
            boolean east = true;
            if(X < 0)
               east = false;
            if(Y < 0)
               north = false;
            X = Math.max(X, -1*X); 
            Y = Math.max(Y, -1*Y);
            //solve
            if(X == 0 && Y == 0)
            {
               sb.append("\n");
               continue;
            }
            if(X%2 == Y%2)
            {
               sb.append("IMPOSSIBLE\n");
               continue;
            }
            ArrayList<Character> ls = null;
            char premove = '?';
            if(X%2 == 1)
            {
               ArrayList<Character> temp = solve(X-1, Y, north, east);
               if(temp != null && (ls == null || ls.size() > temp.size()))
               {
                  premove = 'E';
                  ls = temp;
               }
               ArrayList<Character> temp2 = solve(X+1, Y, north, east);
               if(temp2 != null && (ls == null || ls.size() > temp2.size()))
               {
                  premove = 'W';
                  ls = temp2;
               }
            }
            else
            {
               ArrayList<Character> temp = solve(X, Y-1, north, east);
               if(temp != null && (ls == null || ls.size() > temp.size()))
               {
                  premove = 'N';
                  ls = temp;
               }
               ArrayList<Character> temp2 = solve(X, Y+1, north, east);
               if(temp2 != null && (ls == null || ls.size() > temp2.size()))
               {
                  premove = 'S';
                  ls = temp2;
               }
            }
            //output
            if(ls == null)
               sb.append("IMPOSSIBLE\n");
            else
            {
               ArrayList<Character> res = new ArrayList<Character>();
               res.add(check(premove, north, east));
               for(char c: ls)
                  res.add(check(c, north, east));
               for(char c: res)
                  sb.append(c);
               sb.append("\n");
            }
         }
         System.out.print(sb);
      }
      public static char check(char c, boolean north, boolean east)
      {
         if(c == 'W' || c == 'E')
         {
            char temp = c;
            if(!east)
            {
               if(c == 'E')   temp = 'W';
               else  temp = 'E';
            }
            return temp;
         }
         char temp = c;
         if(!north)
         {
            if(c == 'N')   temp = 'S';
            else  temp = 'N';
         }
         return temp;
      }
      public static ArrayList<Character> solve(int X, int Y, boolean north, boolean east)
      {
         ArrayList<Character> ls = new ArrayList<Character>();
         boolean pos = true;
         for(int b=1; b < 30; b++)
         {
            if((X&(1<<b)) > 0)
            {
               X -= (1<<b);
               ls.add('E');
            }
            else if((Y&(1<<b)) > 0)
            {
               Y -= (1<<b);
               ls.add('N');
            }
            else if(X == 0 && Y == 0)
               break;
            else
               pos = false;
         }
         if(X > 0 || Y > 0)
            pos = false;
         if(!pos)
            return null;
         else
            return ls;
      }
   }