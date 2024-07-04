import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int numCases = in.nextInt();
        for (int i = 0; i < numCases; i++) {
            int numSlices = in.nextInt();
            int dinners = in.nextInt();
            ArrayList<Long> slices = new ArrayList<>();
            for (int j = 0; j < numSlices; j++) {
                slices.add(in.nextLong());
            }
            processCase(i + 1, dinners, convertAndSortArray(slices));
        }
    }

    private static long[] convertAndSortArray(ArrayList<Long> list) {
        long[] array = list.stream().mapToLong(Long::longValue).toArray();
        Arrays.sort(array);
        return array;
    }

    private static void processCase(int caseNum, int dinners, long[] slices) {
        int minCuts = dinners - 1;
        for (int i = slices.length; i >= 1; i--) {
            long[] frequencies = findFrequencies(i, slices);
            for (long freq : frequencies) {
                if (i == dinners) {
                    printResult(caseNum, 0);
                    return;
                }
                int needed = dinners - i;
                int possible = 0;
                int cuts = 0;
                for (long slice : slices) {
                    if (slice == freq) continue;
                    possible += slice / freq;
                    if (slice % freq == 0) {
                        if (slice / freq - 1 < needed) {
                            cuts += slice / freq - 1;
                            needed -= slice / freq;
                        } else {
                            cuts += needed;
                            needed = 0;
                            break;
                        }
                    }
                }
                if (possible >= needed) {
                    minCuts = Math.min(minCuts, cuts + needed);
                }
            }
        }
        printResult(caseNum, minCuts);
    }

    private static long[] findFrequencies(int n, long[] slices) {
        HashMap<Long, Integer> countMap = new HashMap<>();
        for (long slice : slices) {
            countMap.put(slice, countMap.getOrDefault(slice, 0) + 1);
        }

        ArrayList<Long> nTimesList = new ArrayList<>();
        for (long slice : slices) {
            if (countMap.get(slice) == n) {
                nTimesList.add(slice);
            }
        }

        return convertAndSortArray(nTimesList);
    }

    private static void printResult(int caseNum, int result) {
        System.out.printf("Case #%d: %d%n", caseNum, result);
    }
}