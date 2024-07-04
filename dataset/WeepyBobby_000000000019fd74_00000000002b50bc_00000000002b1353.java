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
         if(n <= 500)
         {
            System.out.println("Case #"+curc+":");
            for(int i = 1; i <= n; i++)
            {
               System.out.println(i+" 1");
            }
         }
         else if(n <= 501)
         {
            System.out.println("Case #"+curc+":\n1 1\n2 1\n3 2");
            for(int i = 3; i <= 499; i++)
            {
               System.out.println(i+" 1");
            }   
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
