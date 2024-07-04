import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public final static Scanner in = new Scanner(System.in);

    public static long[] toSortedLongArr(ArrayList<Long> al) {
        long[] ret = new long[al.size()];
        for (int i = 0; i < al.size(); i++) {
            ret[i] = al.get(i);
        }
        Arrays.sort(ret);
        return ret;
    }

    public static void main(String[] args) {
        int numCases = in.nextInt();
        for (int i = 0; i < numCases; i++) {
            int numSlices = in.nextInt();
            int dinners = in.nextInt();
            ArrayList<Long> slices = new ArrayList<>();
            for (int j = 0; j < numSlices; j++) {
                slices.add(in.nextLong());
            }
            runCase(i + 1, dinners, toSortedLongArr(slices));
        }
    }

    private static void runCase(int caseNum, int dinners, long[] slices) {
        int minCuts = dinners - 1;
        for (int i = slices.length; i >= 1; i--) {
            long[] ntimes = appearsN(i, slices);
            for (long ntime : ntimes) {
                if (i == dinners) {
                    printCaseResult(caseNum, 0);
                    return;
                }
                int needed = dinners - i;
                int cuts = 0;
                for (long slice : slices) {
                    if (slice == ntime) continue;
                    if (slice % ntime == 0) {
                        if (slice / ntime - 1 < needed) {
                            cuts += slice / ntime - 1;
                            needed -= slice / ntime;
                        } else {
                            cuts += needed;
                            needed = 0;
                        }
                        minCuts = Math.min(minCuts, cuts + needed);
                    }
                }
            }
        }

        printCaseResult(caseNum, minCuts);
    }

    private static long[] appearsN(int n, long[] slices) {
        HashMap<Long, Integer> counts = new HashMap<>();
        for (long m : slices) {
            if (counts.containsKey(m)) {
                counts.put(m, counts.get(m) + 1);
            } else {
                counts.put(m, 1);
            }
        }

        ArrayList<Long> nTimes = new ArrayList<>();
        for (long m : slices) {
            if (counts.get(m) == n) {
                nTimes.add(m);
            }
        }

        return toSortedLongArr(nTimes);
    }

    public static void printCaseResult(int caseNum, int result) {
        System.out.printf("Case #%d: %d%n", caseNum, result);
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
