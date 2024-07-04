
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author Eleftherios Chrysochoidis
 * Date 4/4/2020
 */
public class Solution {

   public static void main(String[] args) {

      Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.


      String lp="(", rp=")";
      for (int c = 1; c <= t; ++c) { // testCases
         String s = in.next();
         String ss = "";

         char[] chars = s.toCharArray();
         int pCount = 0;
         for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            int num = Character.getNumericValue(aChar);

            if (ss.isEmpty()){
               ss += addNPar(num, lp) + num;
               pCount = num;
            }
            else if (pCount - num > 0){
               ss += addNPar(pCount - num, rp) + num;
               pCount -= (pCount -num);
            } else {
               ss += addNPar(num - pCount, lp) + num;
               pCount += num -pCount;
            }

            if (i == chars.length-1){
               ss += addNPar(pCount, rp);
            }
         }

         System.out.println(String.format("Case #%d: %s", c, ss));

      }
   }

   private static String addNPar(int num, String p) {
      String s = "";
      for (int i = 0; i < num; i++) {
         s+=p;
      }
      return s;
   }

}
