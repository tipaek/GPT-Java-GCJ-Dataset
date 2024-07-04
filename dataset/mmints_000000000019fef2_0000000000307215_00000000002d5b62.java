import java.io.*;
import java.util.*;



public class Solution
{

   public static void main(String[] args) throws IOException
   {
      BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(input.readLine());
      for(int t = 1; t <= T; t++)
      {
         StringTokenizer st = new StringTokenizer(input.readLine());
         int x = Integer.parseInt(st.nextToken());
         int y = Integer.parseInt(st.nextToken());
         if(x == 0 && y == 0)
         {
            System.out.printf("Case #%d: \n", t);
            continue;
         }
         char n = (y >= 0) ? 'N' : 'S';
         char s = (y >= 0) ? 'S' : 'N';
         char e = (x >= 0) ? 'E' : 'W';
         char w = (x >= 0) ? 'W' : 'E';
         String s1 = Integer.toBinaryString(Math.abs(x));
         String s2 = Integer.toBinaryString(Math.abs(y));
         while(s1.length() < s2.length()) s1 = '0' + s1;
         while(s2.length() < s1.length()) s2 = '0' + s2;
         if(s1.charAt(0) == '1' && s2.charAt(0) == '1')
         {
            s1 = '0' + s1;
            s2 = '0' + s2;
         }
         int N = s1.length();
         String result = "";
         boolean impossible = false;
         int overshot = 0;
         for(int i = 0; i < N; i++)
         {
            if(s1.charAt(i) == '1' && s2.charAt(i) == '0')
            {
               if(overshot == 0)
               {
                  impossible = true;
                  break;
               }
               if(overshot == 1)
               {
                  overshot = 0;
                  result += w;
               }
               else if(overshot == 2)
               {
                  result += e;
               }
            }
            else if(s1.charAt(i) == '0' && s2.charAt(i) == '1')
            {
               if(overshot == 0)
               {
                  impossible = true;
                  break;
               }
               if(overshot == 2)
               {
                  overshot = 0;
                  result += s;
               }
               else if(overshot == 1)
               {
                  result += n;
               }
            }
            else if(s1.charAt(i) == '0' && s2.charAt(i) == '0')
            {
               int trail1 = 0;
               int trail2 = 0;
               int j = i + 1;
               while(j < N && s1.charAt(j) == '1')
               {
                  trail1++;
                  j++;
               }
               j = i + 1;
               while(j < N && s2.charAt(j) == '1')
               {
                  trail2++;
                  j++;
               }
               if(trail1 == 0 || trail2 == 0 || trail1 == trail2)
               {
                  impossible = true;
                  break;
               }
               if(trail1 > trail2)
               {
                  result += e;
                  overshot = 1;
               }
               else
               {
                  result += n;
                  overshot = 2;
               }
            }
            else
            {
               if(overshot == 0)
               {
                  impossible = true;
                  break;
               }
               if(overshot == 1)
               {
                  result += n;
               }
               else
               {
                  result += e;
               }
            }
         }
         result = reverse(result);
         if(impossible)
         {
            System.out.printf("Case #%d: IMPOSSIBLE\n", t);
         }
         else
         {
            System.out.printf("Case #%d: %s\n", t, result);
         }
      }
   }
   
   public static String reverse(String s)
   {
      String result = "";
      for(int i = s.length() - 1; i >= 0; i--)
      {
         result += s.charAt(i);
      }
      return result;
   }

}