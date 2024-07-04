import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static final Scanner in = new Scanner(System.in);

    public static long[] toSortedLongArray(ArrayList<Long> list) {
        long[] array = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        Arrays.sort(array);
        return array;
    }

    public static void main(String[] args) {
        int testCases = in.nextInt();
        for (int i = 0; i < testCases; i++) {
            int sliceCount = in.nextInt();
            int dinerCount = in.nextInt();
            ArrayList<Long> slices = new ArrayList<>();
            for (int j = 0; j < sliceCount; j++) {
                slices.add(in.nextLong());
            }
            processCase(i + 1, dinerCount, toSortedLongArray(slices));
        }
    }

    private static void processCase(int caseNumber, int diners, long[] slices) {
        int minimumCuts = diners - 1;
        for (int i = slices.length; i >= 1; i--) {
            long[] nTimes = getAppearancesN(i, slices);
            for (long nTime : nTimes) {
                if (i == diners) {
                    printCaseResult(caseNumber, 0);
                    return;
                }
                int required = diners - i;
                int possibleSlices = 0;
                int cuts = 0;
                for (long slice : slices) {
                    if (slice == nTime) continue;
                    possibleSlices += slice / nTime;
                    if (slice % nTime == 0) {
                        if (slice / nTime - 1 < required) {
                            cuts += slice / nTime - 1;
                            required -= slice / nTime;
                        } else {
                            cuts += required;
                            required = 0;
                            break;
                        }
                    }
                }
                if (possibleSlices >= diners - i) {
                    minimumCuts = Math.min(minimumCuts, cuts + required);
                }
            }
        }
        printCaseResult(caseNumber, minimumCuts);
    }

    private static long[] getAppearancesN(int n, long[] slices) {
        HashMap<Long, Integer> countMap = new HashMap<>();
        for (long slice : slices) {
            countMap.put(slice, countMap.getOrDefault(slice, 0) + 1);
        }

        ArrayList<Long> nTimes = new ArrayList<>();
        for (long slice : slices) {
            if (countMap.get(slice) == n) {
                nTimes.add(slice);
            }
        }

        return toSortedLongArray(nTimes);
    }

    public static void printCaseResult(int caseNumber, int result) {
        System.out.printf("Case #%d: %d%n", caseNumber, result);
    }
}