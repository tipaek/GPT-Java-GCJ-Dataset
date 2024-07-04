import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(reader.readLine());

        for (int caseNum = 0; caseNum < numCases; caseNum++) {
            int numTests = Integer.parseInt(reader.readLine());
            int[][] intervals = new int[numTests][2];
            int[][] originalIntervals = new int[numTests][2];

            for (int i = 0; i < numTests; i++) {
                String[] times = reader.readLine().split(" ");
                intervals[i][0] = Integer.parseInt(times[0]);
                intervals[i][1] = Integer.parseInt(times[1]);
                originalIntervals[i][0] = intervals[i][0];
                originalIntervals[i][1] = intervals[i][1];
            }

            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

            HashSet<Integer> jSet = new HashSet<>();
            HashSet<Integer> cSet = new HashSet<>();
            String[] result = new String[numTests];
            boolean possible = true;

            for (int[] interval : intervals) {
                boolean jAvailable = isAvailable(jSet, interval);
                boolean cAvailable = !jAvailable && isAvailable(cSet, interval);

                if (jAvailable) {
                    markOccupied(jSet, interval);
                } else if (cAvailable) {
                    markOccupied(cSet, interval);
                } else {
                    possible = false;
                    break;
                }

                int index = findIndex(originalIntervals, interval);
                result[index] = jAvailable ? "J" : "C";
            }

            if (possible) {
                System.out.printf("Case #%d: %s\n", caseNum + 1, String.join("", result));
            } else {
                System.out.printf("Case #%d: IMPOSSIBLE\n", caseNum + 1);
            }
        }

        reader.close();
    }

    private static boolean isAvailable(HashSet<Integer> set, int[] interval) {
        for (int i = interval[0]; i < interval[1]; i++) {
            if (set.contains(i)) {
                return false;
            }
        }
        return true;
    }

    private static void markOccupied(HashSet<Integer> set, int[] interval) {
        for (int i = interval[0]; i < interval[1]; i++) {
            set.add(i);
        }
    }

    private static int findIndex(int[][] originalIntervals, int[] interval) {
        for (int i = 0; i < originalIntervals.length; i++) {
            if (Arrays.equals(originalIntervals[i], interval)) {
                originalIntervals[i] = null; // Mark as used
                return i;
            }
        }
        return -1; // Should never happen
    }
}