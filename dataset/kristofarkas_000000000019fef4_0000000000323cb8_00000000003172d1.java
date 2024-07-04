import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int d = in.nextInt();

            HashMap<Long, Integer> counts = new HashMap<>(d);

            for (int j = 0; j < n; j++) {
                long s = in.nextLong();
                if (counts.containsKey(s)) {
                    counts.put(s, counts.get(s) + 1);
                } else {
                    counts.put(s, 1);
                }
            }


            System.out.println("Case #" + i + ": " + slice(counts, d));
            
        }
    }

    public static int slice(HashMap<Long, Integer> counts, int d) {
            // Counts how many doubles a number has
            HashMap<Long, Integer> doubleCount = new HashMap<>(d);

            for (Long slice : counts.keySet()) {
                if (counts.containsKey(slice + slice)) {
                    if (doubleCount.containsKey(slice)) {
                        doubleCount.put(slice, doubleCount.get(slice) + 1);
                    } else {
                        doubleCount.put(slice, 1);
                    }
                }
            }

            int sliced = d - 1;

            for (Long slice : counts.keySet()) {

                if (counts.get(slice) >= d) {
                    sliced = 0;
                    break;
                }

                if (counts.get(slice) + doubleCount.getOrDefault(slice, 0) * 2 == d) {
                    sliced = d - 1 - doubleCount.getOrDefault(slice, 0);
                }
            }

            return sliced;
        }
}