import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static final Scanner scanner = new Scanner(System.in);

    public static long[] toSortedLongArray(ArrayList<Long> arrayList) {
        long[] array = new long[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            array[i] = arrayList.get(i);
        }
        Arrays.sort(array);
        return array;
    }

    public static void main(String[] args) {
        int numCases = scanner.nextInt();
        for (int caseIndex = 0; caseIndex < numCases; caseIndex++) {
            int numSlices = scanner.nextInt();
            int numDinners = scanner.nextInt();
            ArrayList<Long> slices = new ArrayList<>();
            for (int sliceIndex = 0; sliceIndex < numSlices; sliceIndex++) {
                slices.add(scanner.nextLong());
            }
            processCase(caseIndex + 1, numDinners, toSortedLongArray(slices));
        }
    }

    private static void processCase(int caseNumber, int dinners, long[] slices) {
        int minimumCuts = dinners - 1;
        for (int i = slices.length; i >= 1; i--) {
            long[] nTimes = findOccurrences(i, slices);
            for (long nTime : nTimes) {
                if (i == dinners) {
                    printResult(caseNumber, 0);
                    return;
                }
                int needed = dinners - i;
                int cuts = 0;
                for (long slice : slices) {
                    if (slice == nTime) continue;
                    if (slice % nTime == 0) {
                        int quotient = (int) (slice / nTime);
                        if (quotient - 1 < needed) {
                            cuts += quotient - 1;
                            needed -= quotient;
                        } else {
                            cuts += needed;
                            needed = 0;
                        }
                        minimumCuts = Math.min(minimumCuts, cuts + needed);
                    }
                }
            }
        }
        printResult(caseNumber, minimumCuts);
    }

    private static long[] findOccurrences(int count, long[] slices) {
        HashMap<Long, Integer> frequencyMap = new HashMap<>();
        for (long slice : slices) {
            frequencyMap.put(slice, frequencyMap.getOrDefault(slice, 0) + 1);
        }

        ArrayList<Long> occurrences = new ArrayList<>();
        for (long slice : slices) {
            if (frequencyMap.get(slice) == count) {
                occurrences.add(slice);
            }
        }

        return toSortedLongArray(occurrences);
    }

    public static void printResult(int caseNumber, int result) {
        System.out.printf("Case #%d: %d%n", caseNumber, result);
    }
}

/*
4
1 3
1
5 2
10 5 359999999999 123456789 10
2 3
8 4
3 2
1 2 3
 */