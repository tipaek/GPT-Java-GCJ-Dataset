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
            if(X < 0)   east = false;
            if(Y < 0)   north = false;
            X = Math.max(X, -1*X);
            Y = Math.max(Y, -1*Y);
            int x = X;  int y = Y;
            //edge cases
            if((X%2+Y%2) != 1)
               sb.append("IMPOSSIBLE\n");
            else
            {
               //solve it
               char first = '?';
               ArrayList<Character> moves = null;//new ArrayList<Character>();
               if(X%2 == 1)
               {
                  if(solve(x-1,y) != null)
                  {
                     first = 'E';
                     moves = solve(x-1,y);
                  }
                  ArrayList<Character> temp = solve(x+1,y);
                  if(temp != null && (moves == null || moves.size() > temp.size()))
                  {
                     first = 'W';
                     moves = temp;
                  }
               }
               else
               {
                  if(solve(x,y-1) != null)
                  {
                     first = 'N';
                     moves = solve(x,y-1);
                  }
                  ArrayList<Character> temp = solve(x,y+1);
                  if(temp != null && (moves == null || moves.size() > temp.size()))
                  {
                     first = 'S';
                     moves = temp;
                  }
               }
               if(first == '?')
                  sb.append("IMPOSSIBLE\n");
               else
               {
                  ArrayList<Character> res = new ArrayList<Character>();
                  res.add(change(first, north, east));
                  for(char thing: moves)
                     res.add(change(thing, north, east));
                  for(char c: res)
                     sb.append(c);
                  sb.append("\n");
               }
            }
         }
         System.out.print(sb);
      }
      public static char change(char c, boolean north, boolean east)
      {
         if(!north && (c == 'N' || c == 'S'))
         {
            if(c == 'N')
               return 'S';
            else
               return 'N';
         }
         if(!east && (c == 'W' || c == 'E'))
         {
            if(c == 'W')
               return 'E';
            else
               return 'W';
         }
         return c;
      }
      public static ArrayList<Character> solve(int X, int Y)
      {
         ArrayList<Character> ls = new ArrayList<Character>();
         for(int b=1; b < 31; b++)
         {
            if((X&(1<<b)) > 0 && (Y&(1<<b)) > 0)
               return null;
            if(X == 0 && Y == 0)
               break;
               
            if((X&(1<<b)) > 0)
            {
               X -= 1<<b;
               ls.add('E');
            }
            else if((Y&(1<<b)) > 0)
            {
               Y -= 1<<b;
               ls.add('N');
            }
            else
               return null;
         }
         return ls;
      }
   }