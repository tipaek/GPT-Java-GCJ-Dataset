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
      while(curc++ < cases)
      {
         String str = st.readLine();
         int opened = 0;
         StringBuilder builder = new StringBuilder();
         for(int i = 0; i < str.length(); i++)
         {
            int x = (int)str.charAt(i)-'0';
            if(x == opened)
            {
               builder.append(x);
            }
            else if(x < opened)
            {
               for(int j = 0; j < opened-x; j++)
                  builder.append(')');
               builder.append(x);
               opened = x;
            }
            else
            {
               for(int j = 0; j < x-opened; j++)
                  builder.append('(');
               builder.append(x);
               opened = x;   
            }
         }
         for(int i = 0; i < opened; i++)
            builder.append(')');
         System.out.println("Case #"+curc+": "+builder.toString());
      }
   }
}