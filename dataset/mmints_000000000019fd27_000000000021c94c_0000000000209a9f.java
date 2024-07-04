import java.io.*;
import java.util.*;



public class Solution
{

   public static void main(String[] args) throws IOException
   {
      BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(input.readLine());
      for(int t = 0; t < T; t++)
      {
         String s = input.readLine();
         String p = calcParens(s, 0);
         System.out.printf("Case #%d: %s\n", t + 1, p);
      }
   }
   
   public static String calcParens(String s, int depth)
   {
      String result = "";
      for(String sub : s.split(String.format("((?<=%d)|(?=%d))", depth, depth)))
      {
         if(sub.equals("") || sub.equals(String.format("%d", depth))) result += sub;
         else result += "(" + calcParens(sub, depth + 1) + ")";
      }
      return result;
   }
   

}