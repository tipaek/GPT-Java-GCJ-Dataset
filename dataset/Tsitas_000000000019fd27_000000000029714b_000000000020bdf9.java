import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author Eleftherios Chrysochoidis
 * Date 5/4/2020
 */
public class Solution {

   public static void main(String[] args) {

      Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

      for (int c = 1; c <= t; ++c) { // testCases
         int n = in.nextInt();
         String schedule = "";
         boolean imp = false;
         Map<Integer, Integer> actData = new TreeMap<>();
         int lc = 0, lj = 0;

         for (int i = 0; i < n; i++) {
            int start = in.nextInt();
            int end = in.nextInt();

            actData.put(start, end);
         }

         for (Map.Entry<Integer, Integer> entry : actData.entrySet()) {

            int start = entry.getKey();
            int end = entry.getValue();

            if (start >=lc){
               schedule += "C";
               lc = end;
            } else if (start >= lj){
               schedule += "J";
               lj = end;
            } else {
               imp = true;
               schedule = "IMPOSSIBLE";
            }
         }

         System.out.println(String.format("Case #%d: %s", c, imp ? "IMPOSSIBLE" : schedule));

      }
   }
}