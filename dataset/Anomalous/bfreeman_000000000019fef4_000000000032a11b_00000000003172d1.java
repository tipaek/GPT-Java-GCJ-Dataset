package CJ2020.Round1C.Problem3;

import java.util.*;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int numCases = scanner.nextInt();
        for (int i = 0; i < numCases; i++) {
            int numSlices = scanner.nextInt();
            int diners = scanner.nextInt();
            ArrayList<Long> slicesList = new ArrayList<>();
            for (int j = 0; j < numSlices; j++) {
                slicesList.add(scanner.nextLong());
            }
            long[] sortedSlices = convertToSortedArray(slicesList);
            processCase(i + 1, diners, sortedSlices);
        }
    }

    private static long[] convertToSortedArray(ArrayList<Long> list) {
        long[] array = list.stream().mapToLong(Long::longValue).toArray();
        Arrays.sort(array);
        return array;
    }

    private static void processCase(int caseNum, int diners, long[] sortedSlices) {
        int minCuts = diners - 1;
        for (int i = sortedSlices.length; i >= 1; i--) {
            long[] nTimes = findNTimesOccurrences(i, sortedSlices);
            for (long nTime : nTimes) {
                if (i >= diners) {
                    printResult(caseNum, 0);
                    return;
                }
                int needed = diners - i;
                int possible = 0;
                int cuts = 0;
                for (long slice : sortedSlices) {
                    if (slice == nTime) continue;
                    possible += slice / nTime;
                    if (slice / nTime - 1 < needed) {
                        cuts += slice / nTime - 1;
                        needed -= slice / nTime;
                    } else {
                        cuts += needed;
                        needed = 0;
                        break;
                    }
                }
                if (possible >= diners - i) {
                    minCuts = Math.min(minCuts, cuts + needed);
                }
            }
        }
        printResult(caseNum, minCuts);
    }

    private static long[] findNTimesOccurrences(int n, long[] sortedSlices) {
        Map<Long, Integer> counts = new HashMap<>();
        for (long slice : sortedSlices) {
            counts.put(slice, counts.getOrDefault(slice, 0) + 1);
        }
        ArrayList<Long> nTimesList = new ArrayList<>();
        for (long slice : sortedSlices) {
            if (counts.get(slice) == n) {
                nTimesList.add(slice);
            }
        }
        return convertToSortedArray(nTimesList);
    }

    private static void printResult(int caseNum, int result) {
        System.out.printf("Case #%d: %d%n", caseNum, result);
    }
}