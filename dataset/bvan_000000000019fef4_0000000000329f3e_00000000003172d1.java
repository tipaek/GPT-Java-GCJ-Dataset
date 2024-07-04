import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        for (int t = 1; t <= tests; t++) {
            String[] tokens = reader.readLine().split(" ");
            int slicesCount = Integer.parseInt(tokens[0]);
            int dinners = Integer.parseInt(tokens[1]);
            long[] sizes = toLongArray(reader.readLine());
            int steps = solve(sizes, dinners);
            System.out.println(String.format("Case #%d: %d", t, steps));
        }
    }

    private static long[] toLongArray(String s) {
        return Stream.of(s.split(" ")).mapToLong(Long::parseLong).toArray();
    }

    private static int solve(long[] sizes, int dinners) {
        Arrays.sort(sizes); // N logN
        long maxSize = sizes[sizes.length - 1];
        TreeMap<Long, Integer> sizeToAgrCount = buildSizeToAgrCount(sizes);
        TreeMap<Integer, List<Long>> countToSize = buildCountToSizes(sizeToAgrCount);
        List<Long> sizesQueue = countToSize.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
        for (long size : sizesQueue) {
            int totalCuts = 0;
            int totalCount = getCount(size, sizeToAgrCount);
            if (totalCount >= dinners) {
                return totalCuts;
            }
            int mult = 2;
            long s = size * mult;
            while (s <= maxSize) {
                Integer c = getCount(s, sizeToAgrCount);
                if (c != null) {
                    int newCount = c * mult;
                    if (totalCount + newCount >= dinners) {
                        int newDinners = dinners - totalCount;
                        return newDinners / mult * (mult - 1) + (newDinners % mult);
                    }
                    totalCount += newCount;
                    totalCuts += mult - 1;
                }
                mult *= 2;
                s = size * mult;
            }
        }
        return dinners - 1;
    }

    private int countCuts(long big, long small, int pieces) {
        if (pieces == big / small) {
            return pieces - 1;
        }
        return pieces;
    }

    private static TreeMap<Integer, List<Long>> buildCountToSizes(TreeMap<Long, Integer> sizeToAgrCount) {
        TreeMap<Integer, List<Long>> countToSize = new TreeMap<>(Comparator.reverseOrder());
        for (long size : sizeToAgrCount.keySet()) {
            int count = getCount(size, sizeToAgrCount);

            List<Long> s = countToSize.get(count);
            if (s == null) {
                s = new ArrayList<>();
            }
            s.add(size);
            countToSize.put(count, s);
        }
        return countToSize;
    }

    private static Integer getCount(long size, TreeMap<Long, Integer> sizeToAgrCount) {
        Integer agrCount = sizeToAgrCount.get(size);
        if (agrCount == null) {
            return null;
        }
        Entry<Long, Integer> ceiling = sizeToAgrCount.ceilingEntry(size + 1);
        return ceiling == null ? agrCount : agrCount - ceiling.getValue();
    }

    private static TreeMap<Long, Integer> buildSizeToAgrCount(long[] sizes) {
        TreeMap<Long, Integer> sizeToAgrCount = new TreeMap<>();
        int argCount = 1;
        for (int i = sizes.length - 1; i >= 0; i--) {
            sizeToAgrCount.put(sizes[i], argCount++);
        }
        return sizeToAgrCount;
    }
}
