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
        int testCases = Integer.parseInt(reader.readLine());
        for (int testCase = 1; testCase <= testCases; testCase++) {
            String[] input = reader.readLine().split(" ");
            int sliceCount = Integer.parseInt(input[0]);
            int dinners = Integer.parseInt(input[1]);
            long[] sliceSizes = parseLongArray(reader.readLine());
            int result = calculateSteps(sliceSizes, dinners);
            System.out.println(String.format("Case #%d: %d", testCase, result));
        }
    }

    private static long[] parseLongArray(String input) {
        return Stream.of(input.split(" ")).mapToLong(Long::parseLong).toArray();
    }

    private static int calculateSteps(long[] sliceSizes, int dinners) {
        Arrays.sort(sliceSizes);
        long maxSize = sliceSizes[sliceSizes.length - 1];
        TreeMap<Long, Integer> sizeToCountMap = createSizeToCountMap(sliceSizes);
        TreeMap<Integer, List<Long>> countToSizeMap = createCountToSizeMap(sizeToCountMap);
        List<Long> sortedSizes = countToSizeMap.values().stream().flatMap(Collection::stream).collect(Collectors.toList());

        for (long size : sortedSizes) {
            int totalCuts = 0;
            int totalCount = getCount(size, sizeToCountMap);
            if (totalCount >= dinners) {
                return totalCuts;
            }
            int multiplier = 2;
            long currentSize = size * multiplier;
            while (currentSize <= maxSize) {
                Integer count = getCount(currentSize, sizeToCountMap);
                if (count != null) {
                    int newCount = count * multiplier;
                    if (totalCount + newCount >= dinners) {
                        int remainingDinners = dinners - totalCount;
                        return totalCuts + remainingDinners / multiplier * (multiplier - 1) + (remainingDinners % multiplier);
                    }
                    totalCount += newCount;
                    totalCuts += multiplier - 1;
                }
                multiplier *= 2;
                currentSize = size * multiplier;
            }
        }
        return dinners - 1;
    }

    private static TreeMap<Integer, List<Long>> createCountToSizeMap(TreeMap<Long, Integer> sizeToCountMap) {
        TreeMap<Integer, List<Long>> countToSizeMap = new TreeMap<>(Comparator.reverseOrder());
        for (Entry<Long, Integer> entry : sizeToCountMap.entrySet()) {
            long size = entry.getKey();
            int count = getCount(size, sizeToCountMap);

            countToSizeMap.computeIfAbsent(count, k -> new ArrayList<>()).add(size);
        }
        return countToSizeMap;
    }

    private static Integer getCount(long size, TreeMap<Long, Integer> sizeToCountMap) {
        Integer count = sizeToCountMap.get(size);
        if (count == null) {
            return null;
        }
        Entry<Long, Integer> nextEntry = sizeToCountMap.ceilingEntry(size + 1);
        return nextEntry == null ? count : count - nextEntry.getValue();
    }

    private static TreeMap<Long, Integer> createSizeToCountMap(long[] sliceSizes) {
        TreeMap<Long, Integer> sizeToCountMap = new TreeMap<>();
        int count = 1;
        for (int i = sliceSizes.length - 1; i >= 0; i--) {
            sizeToCountMap.put(sliceSizes[i], count++);
        }
        return sizeToCountMap;
    }
}