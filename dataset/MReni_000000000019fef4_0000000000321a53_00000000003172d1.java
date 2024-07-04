
import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
          int N = in.nextInt(), D = in.nextInt();
          long[] pancakes = new long[N];
          for (int j = 0; j < N; j++) {
            pancakes[j] = in.nextLong();
          }
  
          int output = getOutput(N, D, pancakes);
          System.out.println("Case #" + i + ": " + output);
        }
    }

    private static int getOutput(int N, int D, long[] pancakes) {
        TreeMap<Long, Integer> pancakeCounter = new TreeMap<>(Collections.reverseOrder());

        // no need to cut
        for (long pancake : pancakes) {
            int counter = pancakeCounter.getOrDefault(pancake, 0) + 1;
            if (counter >= D) {
                return 0;
            }
            pancakeCounter.put(pancake, counter);
        }

        if (D <= 2) return 1;
        if (D <= 3) {
            // check if has two cakes or multipliable cakes, return 1
            boolean init = true;
            for (Map.Entry<Long, Integer> entry : pancakeCounter.entrySet()) {
                long p = entry.getKey();
                if (pancakeCounter.containsKey(p * 2) || (p%2==0 && pancakeCounter.containsKey(p/2))) return 1;
                int c = entry.getValue();
                if (init) {
                    init = false;
                    continue;
                }
                if (c >= 2) return 1;
            }
            // else return 2
            return 2;
        }

        // cut with common min

        // pancake sorted by count
        LinkedHashMap<Long, Integer> sortedPancake = new LinkedHashMap<>();
        pancakeCounter.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) 
            .forEachOrdered(x -> sortedPancake.put(x.getKey(), x.getValue()));

        // cut wiht divide to multiple?
        return D-1;
    }

}