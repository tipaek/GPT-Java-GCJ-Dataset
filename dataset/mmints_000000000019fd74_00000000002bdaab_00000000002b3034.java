import java.io.*;
import java.util.*;



public class Solution
{

   public static void main(String[] args) throws IOException
   {
      BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(input.readLine());
      loop:
      for(int t = 1; t <= T; t++)
      {
         System.out.printf("Case #%d: ", t);
         int N = Integer.parseInt(input.readLine());
         String[] patterns = new String[N];
         int[] index = new int[N];
         for(int i = 0; i < N; i++)
         {
            patterns[i] = input.readLine();
         }
         String result = "";
         while(true)
         {
            char first = 0;
            for(int i = 0; i < N; i++)
            {
               if(index[i] >= patterns[i].length()) continue;
               char c = patterns[i].charAt(index[i]);
               if(c != '*')
               {
                  if(c != first && first != 0)
                  {
                     System.out.println("*");
                     continue loop;
                  }
                  first = c;
               }
            }
            if(first == 0) break;
            result += first;
            for(int i = 0; i < N; i++)
            {
               if(patterns[i].charAt(index[i]) != '*') index[i]++;
            }
         }
         int max = 0;
         for(int i = 0; i < N; i++)
         {
            if(patterns[i].length() - index[i] > patterns[max].length() - index[max]) max = i;
         }
         for(int i = 0; i < N; i++)
         {
            if(!patterns[i].substring(index[i] + 1).equals(
            patterns[max].substring(patterns[max].length() - 
            patterns[i].length() + index[i] + 1)))
            {
               System.out.println("*");
               continue loop;
            }
         }
         result += patterns[max].substring(index[max] + 1);
         System.out.println(result);
      }
   }

}