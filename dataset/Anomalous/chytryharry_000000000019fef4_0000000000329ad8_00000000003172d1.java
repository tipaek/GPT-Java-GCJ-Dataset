import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            long slices = scanner.nextLong();
            long dinners = scanner.nextLong();
            LinkedList<Long> sliceList = new LinkedList<>();
            TreeMap<Long, Long> sliceMap = new TreeMap<>();

            for (int j = 0; j < slices; j++) {
                long sliceSize = scanner.nextLong();
                sliceList.add(sliceSize);
                sliceMap.merge(sliceSize, 1L, Long::sum);
            }

            System.out.println("Case #" + i + ": " + calculateCuts(slices, dinners, sliceList, sliceMap));
        }
    }

    public static long calculateCuts(long slices, long dinners, LinkedList<Long> sliceList, TreeMap<Long, Long> sliceMap) {
        LinkedHashMap<Long, Long> sortedMapByValue = new LinkedHashMap<>();

        sliceMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(entry -> sortedMapByValue.put(entry.getKey(), entry.getValue()));

        for (Long count : sortedMapByValue.values()) {
            if (count >= dinners) {
                return 0;
            }
        }

        if (slices == 1L) {
            return dinners - 1L;
        }

        long totalCuts = 0L;
        while (true) {
            Long smallestSlice = sliceMap.firstKey();

            for (Map.Entry<Long, Long> entry : sliceMap.entrySet()) {
                Long sliceSize = entry.getKey();
                if (sliceSize % smallestSlice == 0 && !sliceSize.equals(smallestSlice)) {
                    sortedMapByValue.merge(smallestSlice, 2L, Long::sum);
                } else {
                    totalCuts += sliceSize / smallestSlice;
                    sortedMapByValue.merge(smallestSlice, totalCuts, Long::sum);
                }

                for (Long count : sortedMapByValue.values()) {
                    if (count >= dinners) {
                        return totalCuts;
                    }
                }
            }
            sliceMap.remove(smallestSlice);
        }
    }
}