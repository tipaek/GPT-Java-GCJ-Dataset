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
         boolean[] active = new boolean[n];
         Arrays.fill(active, true);
         int len = 0;
         for(int i = 0; i < n; i++)
         {
            data[i] = st.readLine();
            len = Math.max(data[i].length(), len);
         }
         int[] fix = new int[n];
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
                     fix[j] = i+1;
                     active[j] = false;
                  }
                  else
                  {
                     if(ch == '1')
                        ch = data[j].charAt(i);
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
            print("Case #"+curc+": *");
            continue;
         }
         StringBuilder mid = new StringBuilder();
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
                     active[j] = false;
                     for(int k = fix[j]; k < data[j].length()-1-i; k++)
                     {
                        if(data[j].charAt(k) != '*')
                           mid.append(data[j].charAt(k));
                     }  
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
            print("Case #"+curc+": *");
         }
         else
         {
            print("Case #"+curc+": "+(pre+mid.toString()+post));
         }
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
