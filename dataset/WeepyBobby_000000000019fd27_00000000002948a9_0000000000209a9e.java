import java.util.*;
import java.math.*;
import java.io.*;
class Solution
{
   static int n;
   public static void main(String args[]) throws IOException
   {
      BufferedReader st = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer s = new StringTokenizer(st.readLine());
      int cases = Integer.parseInt(s.nextToken());
      n = Integer.parseInt(s.nextToken());
      int curc = 0;
      nextcase:
      while(curc++ < cases)
      {
         int[] sol = new int[n+1];
         int typea = -1;
         int aval = 0;
         int typeb = -1;
         int bval = 0;
         for(int i = 1; i <= 5; i++)
         {
            print(i);
            sol[i] = Integer.parseInt(st.readLine());
            print(n-i+1);
            sol[n-i+1] = Integer.parseInt(st.readLine());
            if(sol[i] == sol[n-i+1])
            {
               typea = i;
               aval = sol[i];
            }
            else
            {
               typeb = i;
               bval = sol[i];
            }
         }
         int unknown = 6;
         for(int i = 6; i <= 75 && unknown <= n/2; i++)
         {
            if((2*i)%10 == 2)
            {
               if(typea == -1)
               {
                  print(typeb);
                  if(Integer.parseInt(st.readLine()) != bval)
                     reverse(sol);
                  print(typeb);
                  Integer.parseInt(st.readLine());
               }
               else if(typeb == -1)
               {
                  print(typea);
                  if(Integer.parseInt(st.readLine()) != aval)
                     flip(sol);
                  print(typea);
                  Integer.parseInt(st.readLine());
               }
               else
               {
                  print(typea);
                  int u = Integer.parseInt(st.readLine());
                  print(typeb);
                  int v = Integer.parseInt(st.readLine());
                  if(aval == u)
                  {
                     if(bval == v)
                     {

                     }
                     else
                     {
                        reverse(sol);
                     }
                  }
                  else
                  {
                     if(bval == v)
                     {
                        flip(sol);
                        reverse(sol);
                     }
                     else
                     {
                        flip(sol);
                     }
                  }
               }
            }
            else
            {
               print(unknown);
               sol[unknown] = Integer.parseInt(st.readLine());
               print(n-unknown+1);
               sol[n-unknown+1] = Integer.parseInt(st.readLine());
               if(sol[unknown] == sol[n-unknown+1])
               {
                  typea = unknown;
                  aval = sol[unknown];
               }
               else
               {
                  typeb = unknown;  
                  bval = sol[unknown];
               }
               unknown++;
            }
         }
         String ans = "";
         for(int i = 1; i <= n; i++)
            ans += sol[i];
         print(ans);
      }
   }
   public static void print(String str)
   {
      System.out.println(str);
      System.out.flush();
   }
   public static void print(int str)
   {
      System.out.println(str);
      System.out.flush();
   }
   public static void reverse(int[] data)
   {
      for(int i = 1; i <= n/2; i++)
      {
         int temp = data[i];
         data[i] = data[n-i+1];
         data[n-i+1] = temp;
      }
   }
   public static void flip(int[] data)
   {
      for(int i = 1; i <= n; i++)
         data[i] = 1-data[i];
   }
}
