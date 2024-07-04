import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

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
         Set<Item> items = new TreeSet<>();
         int lc = 0, lj = 0;

         for (int i = 0; i < n; i++) {
            int start = in.nextInt();
            int end = in.nextInt();

            items.add(new Item(i, start, end));
         }

         for (Item item : items) {

            int start = item.start;
            int end = item.end;

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

   static class Item implements Comparable<Item> {
      int key;
      int start;
      int end;

      public Item(int key, int start, int end) {
         this.key = key;
         this.start = start;
         this.end = end;
      }

      @Override
      public int compareTo(Item o) {
         return start - o.start;
      }
   }
}