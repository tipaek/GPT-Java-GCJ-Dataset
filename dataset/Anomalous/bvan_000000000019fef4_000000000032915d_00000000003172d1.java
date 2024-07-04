import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        for (int t = 1; t <= testCases; t++) {
            String[] tokens = reader.readLine().split(" ");
            int slicesCount = Integer.parseInt(tokens[0]);
            int dinners = Integer.parseInt(tokens[1]);
            long[] sizes = parseLongArray(reader.readLine());
            int steps = calculateSteps(sizes, dinners);
            System.out.printf("Case #%d: %d%n", t, steps);
        }
    }

    private static long[] parseLongArray(String input) {
        return Stream.of(input.split(" ")).mapToLong(Long::parseLong).toArray();
    }

    private static int calculateSteps(long[] sizes, int dinners) {
        Arrays.sort(sizes);
        long maxSize = sizes[sizes.length - 1];
        TreeMap<Long, Integer> sizeToCumulativeCount = buildSizeToCumulativeCount(sizes);
        TreeMap<Integer, List<Long>> countToSizes = buildCountToSizes(sizeToCumulativeCount);
        List<Long> sizeQueue = countToSizes.values().stream().flatMap(Collection::stream).collect(Collectors.toList());

        for (long size : sizeQueue) {
            int totalCuts = 0;
            int totalCount = getCount(size, sizeToCumulativeCount);
            if (totalCount >= dinners) {
                return totalCuts;
            }
            int cuts = 1;
            int multiplier = 2;
            long newSize = size * multiplier;
            while (newSize <= maxSize) {
                Integer count = getCount(newSize, sizeToCumulativeCount);
                if (count != null) {
                    int newCount = count * multiplier;
                    if (totalCount + newCount >= dinners) {
                        int remainingDinners = dinners - totalCount;
                        return remainingDinners / multiplier * (multiplier - 1) + (remainingDinners % multiplier);
                    }
                }
                multiplier *= 2;
                newSize = size * multiplier;
                cuts += 2;
            }
        }
        return dinners - 1;
    }

    private static TreeMap<Integer, List<Long>> buildCountToSizes(TreeMap<Long, Integer> sizeToCumulativeCount) {
        TreeMap<Integer, List<Long>> countToSizes = new TreeMap<>((a, b) -> b - a);
        for (Entry<Long, Integer> entry : sizeToCumulativeCount.entrySet()) {
            long size = entry.getKey();
            int count = getCount(size, sizeToCumulativeCount);
            countToSizes.computeIfAbsent(count, k -> new ArrayList<>()).add(size);
        }
        return countToSizes;
    }

    private static Integer getCount(long size, TreeMap<Long, Integer> sizeToCumulativeCount) {
        Integer cumulativeCount = sizeToCumulativeCount.get(size);
        if (cumulativeCount == null) {
            return null;
        }
        Entry<Long, Integer> nextEntry = sizeToCumulativeCount.ceilingEntry(size + 1);
        return nextEntry == null ? cumulativeCount : cumulativeCount - nextEntry.getValue();
    }

    private static TreeMap<Long, Integer> buildSizeToCumulativeCount(long[] sizes) {
        TreeMap<Long, Integer> sizeToCumulativeCount = new TreeMap<>();
        int cumulativeCount = 1;
        for (int i = sizes.length - 1; i >= 0; i--) {
            sizeToCumulativeCount.put(sizes[i], cumulativeCount++);
        }
        return sizeToCumulativeCount;
    }
}