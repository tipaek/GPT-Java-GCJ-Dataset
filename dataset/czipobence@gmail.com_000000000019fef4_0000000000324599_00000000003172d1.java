import java.util.*;
import java.io.*;
public class Solution {


   public static void main(String[] args) {
       Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
       int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
       for (int i = 1; i <= t; ++i) {
           int n = in.nextInt();
           int d = in.nextInt();
           Map<Long, Integer> slices = new HashMap<>();

           for (int slcCount = 0; slcCount < n; slcCount++) {
               long slice = in.nextLong();
               slices.put(slice, slices.getOrDefault(slice, 0) + 1);
           }

           int maxValue = Collections.max(slices.values());

           int cuts = d - 1; // can't get worse than this
           if (maxValue >= d || d == 1) {
               cuts = 0;
           } else if (d == 2 || maxValue == d -1) {
               cuts = 1;
           } else if (d == 3) {
               boolean hasDouble = false;
               for (long sliceSize: slices.keySet()) {
                   for (long otherSliceSize: slices.keySet()) {
                       if (sliceSize == 2 * otherSliceSize) {
                           hasDouble = true;
                       }
                   }
               }

               if (hasDouble) {
                   cuts = 1;
               } else {
                   cuts = 2;
               }
           }


           System.out.println("Case #" + i + ": " + cuts);
       }
    }
}