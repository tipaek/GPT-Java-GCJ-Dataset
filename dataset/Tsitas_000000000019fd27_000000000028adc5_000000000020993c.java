
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * @author Eleftherios Chrysochoidis
 * Date 4/4/2020
 */
public class Solution {

   public static void main(String[] args) {

      Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.


      for (int c = 1; c <= t; ++c) { // testCases
         int n = in.nextInt(); // N is the size of the matrix

         List<HashSet<Integer>> cols = new ArrayList<>();
         List<Boolean> colOks = new ArrayList<>();
         int trace = 0, rr = 0, rc = 0;

         for (int i = 0; i < n; i++) {

            HashSet<Integer> curRow = new HashSet<>();
            for (int j = 0; j < n; j++) {
               cols.add(new HashSet<>());
               colOks.add(true);
            }
            boolean rowOk = true;
            for (int j = 0; j < n; j++) {
               int mij = in.nextInt();

               // Check trace
               if (i == j) {
                  trace += mij;
               }

               // Check repeated row
               if (!curRow.add(mij) && rowOk) {
                  rr++;
                  rowOk = false;
               }

               // Check repeated col
               if (!cols.get(j).add(mij) && colOks.get(j)) {
                  rc++;
                  colOks.set(j, false);
               }
            }
         }
         System.out.println(String.format("Case #%d: %d %d %d", c, trace, rr, rc));
      }
   }

}