import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int d = in.nextInt();
            Map<Long, Integer> slices = new HashMap<>();
            Set<Long> slicesRadius = new TreeSet<>();
            for (int j = 0; j < n; j++) {
                long radius = in.nextLong();
                if (slices.containsKey(radius)) {
                    slices.put(radius, slices.get(radius) + 1);
                } else {
                    slices.put(radius, 1);
                }
                slicesRadius.add(radius);
            }
            List<Map.Entry<Long, Integer>> list =
                    new LinkedList<>(slices.entrySet());

            list.sort((o1, o2) -> {
                int diff = (o1.getValue()).compareTo(o2.getValue());
                if (diff == 0) {
                    return (o1.getKey()).compareTo(o2.getKey());
                } else {
                    return (0-diff);
                }
            });

            Map<Long, Integer> sortedSlices = new LinkedHashMap<>();
            for (Map.Entry<Long, Integer> entry : list) {
                sortedSlices.put(entry.getKey(), entry.getValue());
            }

            Integer cutsTot = null;
            boolean noCutIsNeeded = false;

            for (Map.Entry<Long, Integer> entry : sortedSlices.entrySet()) {
                long radius = entry.getKey();
                int persons = entry.getValue();
                if (persons >= d) {
                    noCutIsNeeded = true;
                    break;
                }
                AtomicInteger cuts = new AtomicInteger(0);
                AtomicInteger personsToServe = new AtomicInteger(persons);
                slicesRadius.stream().filter(aLong -> aLong > radius).sorted((o1, o2) -> {
                    int compare = Long.compare(o1 % radius, o2 % radius);
                    if (compare == 0) {
                        return o1.compareTo(o2);
                    }
                    return compare;
                }).forEach(aLong -> {
                    long r = aLong;
                    while (r > radius && personsToServe.get() < d) {
                        cuts.addAndGet(1);
                        personsToServe.addAndGet(1);
                        r -= radius;
                    }
                    if (r == radius) {
                        personsToServe.addAndGet(1);
                    }
                });
                if (personsToServe.get() >= d) {
                    cutsTot = cuts.get();
                    break;
                }
            }

            if (noCutIsNeeded) {
                System.out.println("Case #" + i + ": " + 0);
            } else if (cutsTot != null) {
                System.out.println("Case #" + i + ": " + cutsTot);
            } else {
                System.out.println("Case #" + i + ": " + (d - 1));
            }
        }
    }
}