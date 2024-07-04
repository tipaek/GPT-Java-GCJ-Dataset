import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 0; testCase < testCases; ++testCase) {
            int numSlices = scanner.nextInt();
            int numDinners = scanner.nextInt();

            long[] slices = new long[numSlices];
            for (int i = 0; i < numSlices; i++) {
                slices[i] = scanner.nextLong();
            }

            if (numDinners <= 1) {
                System.out.printf("Case #%d: 0%n", testCase + 1);
                continue;
            }

            if (numSlices == 1) {
                int cutsNeeded = numDinners - 1;
                System.out.printf("Case #%d: %d%n", testCase + 1, cutsNeeded);
                continue;
            }

            HashMap<Long, Integer> sliceCountMap = new HashMap<>();
            long totalSlices = 0;
            for (long slice : slices) {
                totalSlices += slice;
                sliceCountMap.put(slice, sliceCountMap.getOrDefault(slice, 0) + 1);
            }

            boolean exactMatchFound = false;
            for (int count : sliceCountMap.values()) {
                if (count == numDinners) {
                    exactMatchFound = true;
                    break;
                }
            }

            if (exactMatchFound) {
                System.out.printf("Case #%d: 0%n", testCase + 1);
                continue;
            }

            if (numSlices < numDinners) {
                long neededSize = totalSlices / numDinners;
                int existingSlices = sliceCountMap.getOrDefault(neededSize, 0);
                int cutsNeeded = numDinners - 1 - existingSlices;
                System.out.printf("Case #%d: %d%n", testCase + 1, cutsNeeded);
                continue;
            }

            int maxExistingSlices = sliceCountMap.values().stream().max(Integer::compare).orElse(0);
            int cutsNeeded = numDinners - maxExistingSlices;
            System.out.printf("Case #%d: %d%n", testCase + 1, cutsNeeded);
        }
    }
}