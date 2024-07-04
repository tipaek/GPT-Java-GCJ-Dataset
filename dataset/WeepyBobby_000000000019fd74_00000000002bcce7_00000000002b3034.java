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
         //StringTokenizer s = new StringTokenizer(st.readLine());
         int n = Integer.parseInt(st.readLine());
         String[] data = new String[n];
         int len = 0;
         for(int i = 0; i < n; i++)
         {
            data[i] = st.readLine();
         }
         System.out.println(solve(n, data));
      }
   }
   public static String solve(int n, String[] data)
   {
      int len = 0;
      for(int i = 0; i < n; i++)
      {
         len = Math.max(data[i].length(), len);
      }
      int[][] fix = new int[n][2];
      boolean[] active = new boolean[n];
      Arrays.fill(active, true);
      String pre = "";
      boolean success = true;
      everything:
      for(int i = 0; i < len; i++)
      {
         char ch = '1';
         for(int j = 0; j < n; j++)
         {
            if(!active[j]) continue;
            else
            {
               if(data[j].charAt(i) == '*')
               {
                  fix[j][0] = i;
                  active[j] = false;
               }
               else
               {
                  if(ch == '1')
                  {
                     ch = data[j].charAt(i);
                  }
                  else if(ch != data[j].charAt(i))
                  {
                     success = false;
                     break everything;
                  }
               }
            }
         }
         if(ch != '1') pre = pre+ch;
      }
      if(!success)
      {
         return "*";
      }
      String[] new_data = new String[n];
      String post = "";
      Arrays.fill(active, true);
      everything_else:
      for(int i = 0; i < len; i++)
      {
         char ch = '1';
         for(int j = 0; j < n; j++)
         {
            if(!active[j]) continue;
            else
            {
               if(data[j].charAt(data[j].length()-1-i) == '*')
               {
                  new_data[j] = data[j].substring(fix[j][0], data[j].length()-i);
                  active[j] = false;
               }
               else
               {
                  if(ch == '1')
                     ch = data[j].charAt(data[j].length()-1-i);
                  else if(ch != data[j].charAt(data[j].length()-1-i))
                  {
                     success = false;
                     break everything_else;
                  }
               }
            }
         }
         if(ch != '1')
         {
            post = ch+post;
         }
      }

      if(!success)
      {
         return "*";
      }
      else
      {
         boolean doit = false;
         String sss = "";
         for(int i = 0; i < n; i++)
         {
            for(int j = 0; j < new_data[i].length(); j++)
            {
               if(new_data[i].charAt(j) != '*')
                  doit = true;
            }
         }
         if(doit) sss = solve(n, new_data);
         if(sss == "*")
            return "*";
         else
            return pre+sss+post;
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
