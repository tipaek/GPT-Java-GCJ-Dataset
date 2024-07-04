import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

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
         Set<Item> itemsS = new TreeSet<>();
         List<Item> items = new ArrayList<>();
         int lc = 0, lj = 0;

         for (int i = 0; i < n; i++) {
            int start = in.nextInt();
            int end = in.nextInt();

            items.add(new Item(i, start, end));
         }
         items.sort(Comparator.comparingInt(Item::getStart));

         for (Item item : items) {

            int start = item.start;
            int end = item.end;

            if (start >= lc) {
               item.r = "C";
               lc = end;
            } else if (start >= lj) {
               item.r = "J";
               lj = end;
            } else {
               imp = true;
            }
         }

         items.sort(Comparator.comparingInt(Item::getKey));
         schedule = imp ? "IMPOSSIBLE" : items.stream().map(Item::toString).collect(Collectors.joining(""));

         System.out.println(String.format("Case #%d: %s", c, imp ? "IMPOSSIBLE" : schedule));

      }
   }

   static class Item implements Comparable<Item> {
      int key;
      int start;
      int end;
      String r;

      public Item(int key, int start, int end) {
         this.key = key;
         this.start = start;
         this.end = end;
      }

      public int getKey() {
         return key;
      }

      public int getStart() {
         return start;
      }

      @Override
      public String toString() {
         return r;
      }

      @Override
      public int compareTo(Item o) {
         return start - o.start;
      }
   }
}