import java.util.*;
import java.io.*;

public class Solution
{
    private static String openingPar[] = {
    "", "(", "((", "(((", "((((", "(((((",
    "((((((",
    "(((((((",
    "((((((((",
    "((((((((("};
    
    private static String closingPar[] = {
    "", ")", "))", ")))", "))))", ")))))",
    "))))))",
    ")))))))",
    "))))))))",
    ")))))))))"};
    
    
   public static void main(String[] args)
   {
      Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
              
      int t = in.nextInt();
      for (int i = 1; i <= t; ++i)
      {
         String S = in.next() + "0";
         
         StringBuilder result = new StringBuilder();
         int curNum = 0;
         int nextNum = 0;

         for (int j = 0; j < S.length(); ++j)
         {
            nextNum = S.charAt(j) - '0';
            if (nextNum > curNum)
                result.append(openingPar[nextNum - curNum]);
            else if (nextNum < curNum)
                result.append(closingPar[curNum - nextNum]);
                
            result.append(S.charAt(j));
            curNum = nextNum;
         }
         
         result.deleteCharAt(result.length() - 1);

         
         System.out.println("Case #" + i + ": " + result);
      }
   }
}
