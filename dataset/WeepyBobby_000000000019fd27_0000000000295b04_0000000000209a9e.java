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
            System.out.println(i);
            System.out.flush();
            sol[i] = Integer.parseInt(st.readLine());
            System.out.println(n-i+1);
            System.out.flush();
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
                  System.out.println(typeb);
                  System.out.flush();
                  if(Integer.parseInt(st.readLine()) != bval)
                  {
                     for(int j = 1; j <= n/2; j++)
                     {
                        int temp = sol[j];
                        sol[j] = sol[n-j+1];
                        sol[n-j+1] = temp;
                     }
                  }
                  System.out.println(typeb);
                  System.out.flush();
                  Integer.parseInt(st.readLine());
               }
               else if(typeb == -1)
               {
                  System.out.println(typea);
                  System.out.flush();
                  if(Integer.parseInt(st.readLine()) != aval)
                     for(int j = 1; j <= n; j++)
                        sol[j] = 1-sol[j];
                  System.out.println(typea);
                  System.out.flush();
                  Integer.parseInt(st.readLine());
               }
               else
               {
                  System.out.println(typea);
                  System.out.flush();
                  int u = Integer.parseInt(st.readLine());
                  System.out.println(typeb);
                  System.out.flush();
                  int v = Integer.parseInt(st.readLine());
                  if(aval == u)
                  {
                     if(bval == v)
                     {

                     }
                     else
                     {
                        for(int j = 1; j <= n/2; j++)
                        {
                           int temp = sol[j];
                           sol[j] = sol[n-j+1];
                           sol[n-j+1] = temp;
                        }
                     }
                  }
                  else
                  {
                     if(bval == v)
                     {
                        for(int j = 1; j <= n; j++)
                           sol[j] = 1-sol[j];
                        for(int j = 1; j <= n/2; j++)
                        {
                           int temp = sol[j];
                           sol[j] = sol[n-j+1];
                           sol[n-j+1] = temp;
                        }
                     }
                     else
                     {
                        for(int j = 1; j <= n; j++)
                           sol[j] = 1-sol[j];
                     }
                  }
               }
            }
            else
            {
               System.out.println(unknown);
               System.out.flush();
               sol[unknown] = Integer.parseInt(st.readLine());
               System.out.println(n-unknown+1);
               System.out.flush();
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
         System.out.println(ans);
         System.out.flush();
      }
   }
}