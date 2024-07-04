import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int numCases = scanner.nextInt();
        for (int i = 0; i < numCases; i++) {
            int numSlices = scanner.nextInt();
            int dinners = scanner.nextInt();
            ArrayList<Long> slices = new ArrayList<>();
            for (int j = 0; j < numSlices; j++) {
                slices.add(scanner.nextLong());
            }
            processCase(i + 1, dinners, convertAndSortToLongArray(slices));
        }
    }

    private static long[] convertAndSortToLongArray(ArrayList<Long> list) {
        long[] array = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        Arrays.sort(array);
        return array;
    }

    private static void processCase(int caseNum, int dinners, long[] slices) {
        int minCuts = dinners - 1;
        for (int i = slices.length; i >= 1; i--) {
            long[] nTimesSlices = findSlicesAppearingNTimes(i, slices);
            for (long nTimeSlice : nTimesSlices) {
                if (i == dinners) {
                    printResult(caseNum, 0);
                    return;
                }
                int needed = dinners - i;
                int cuts = 0;
                for (long slice : slices) {
                    if (slice == nTimeSlice) continue;
                    if (slice % nTimeSlice == 0) {
                        int sliceCount = (int) (slice / nTimeSlice);
                        if (sliceCount - 1 < needed) {
                            cuts += sliceCount - 1;
                            needed -= sliceCount;
                        } else {
                            cuts += needed;
                            needed = 0;
                            break;
                        }
                    }
                }
                minCuts = Math.min(minCuts, cuts + needed);
            }
        }
        printResult(caseNum, minCuts);
    }

    private static long[] findSlicesAppearingNTimes(int n, long[] slices) {
        HashMap<Long, Integer> sliceCountMap = new HashMap<>();
        for (long slice : slices) {
            sliceCountMap.put(slice, sliceCountMap.getOrDefault(slice, 0) + 1);
        }

        ArrayList<Long> nTimesSlices = new ArrayList<>();
        for (long slice : slices) {
            if (sliceCountMap.get(slice) == n) {
                nTimesSlices.add(slice);
            }
        }

        return convertAndSortToLongArray(nTimesSlices);
    }

    private static void printResult(int caseNum, int result) {
        System.out.printf("Case #%d: %d%n", caseNum, result);
    }
}