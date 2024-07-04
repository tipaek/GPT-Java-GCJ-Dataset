import java.util.*;
import java.math.*;
import java.io.*;
class Solution
{
   public static void main(String args[]) throws IOException
   {
      BufferedReader st = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer s = new StringTokenizer(st.readLine());
      int cases = Integer.parseInt(s.nextToken());
      int n = Integer.parseInt(s.nextToken());
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
                  int u = Integer.parseInt(st.readLine());
                  if(u != bval)
                  {
                     sol = reverse(sol);
                     bval = sol[typeb];
                  }
                  print(typeb);
                  Integer.parseInt(st.readLine());
               }
               else if(typeb == -1)
               {
                  print(typea);
                  if(Integer.parseInt(st.readLine()) != aval)
                  {
                     sol = flip(sol);
                     aval = sol[typea];
                  }
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
                        sol = reverse(sol);
                     }
                  }
                  else
                  {
                     if(bval == v)
                     {
                        sol = flip(sol);
                        sol = reverse(sol);
                     }
                     else
                     {
                        sol = flip(sol);
                     }
                  }
                  aval = sol[typea];
                  bval = sol[typeb];
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
         st.readLine();
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
   public static int[] reverse(int[] data)
   {
      int n = data.length-1;
      for(int i = 1; i <= n/2; i++)
      {
         int temp = data[i];
         data[i] = data[n-i+1];
         data[n-i+1] = temp;
      }
      return data;
   }
   public static int[] flip(int[] data)
   {
      int n = data.length-1;
      for(int i = 1; i <= n; i++)
         data[i] = 1-data[i];
      return data;
   }
}
