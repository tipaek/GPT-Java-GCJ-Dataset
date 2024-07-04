/*
ID: brianch4
LANG: JAVA
TASK: parenting
*/
import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("parenting.in"));
        int numCases = Integer.parseInt(reader.readLine());

        for (int caseNum = 0; caseNum < numCases; caseNum++) {
            int numTests = Integer.parseInt(reader.readLine());
            int[][] intervals = new int[numTests][2];
            int[][] originalIntervals = new int[numTests][2];
            boolean isPossible = true;
            String[] results = new String[numTests];

            for (int i = 0; i < numTests; i++) {
                String[] times = reader.readLine().split(" ");
                intervals[i][0] = Integer.parseInt(times[0]);
                intervals[i][1] = Integer.parseInt(times[1]);
                originalIntervals[i][0] = intervals[i][0];
                originalIntervals[i][1] = intervals[i][1];
            }

            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

            Set<Integer> jSet = new HashSet<>();
            Set<Integer> cSet = new HashSet<>();

            for (int[] interval : intervals) {
                boolean jAvailable = isAvailable(jSet, interval);
                boolean cAvailable = !jAvailable && isAvailable(cSet, interval);

                int originalIndex = findOriginalIndex(originalIntervals, interval);
                if (jAvailable) {
                    markInterval(jSet, interval);
                    results[originalIndex] = "J";
                } else if (cAvailable) {
                    markInterval(cSet, interval);
                    results[originalIndex] = "C";
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                System.out.printf("Case #%d: %s\n", caseNum + 1, String.join("", results));
            } else {
                System.out.printf("Case #%d: IMPOSSIBLE\n", caseNum + 1);
            }
        }

        reader.close();
    }

    private static boolean isAvailable(Set<Integer> set, int[] interval) {
        for (int i = interval[0]; i < interval[1]; i++) {
            if (set.contains(i)) {
                return false;
            }
        }
        return true;
    }

    private static void markInterval(Set<Integer> set, int[] interval) {
        for (int i = interval[0]; i < interval[1]; i++) {
            set.add(i);
        }
    }

    private static int findOriginalIndex(int[][] originalIntervals, int[] interval) {
        for (int i = 0; i < originalIntervals.length; i++) {
            if (Arrays.equals(originalIntervals[i], interval)) {
                originalIntervals[i] = null; // Mark as used
                return i;
            }
        }
        return -1; // Should not happen
    }
}