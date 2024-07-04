import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();
        for (int p = 1; p <= testCases; p++) {
            int n = sc.nextInt();
            int[][] intervals = new int[n][2];
            int[][] originalIntervals = new int[n][2];

            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                intervals[i][0] = start;
                intervals[i][1] = end;
                originalIntervals[i][0] = start;
                originalIntervals[i][1] = end;
            }

            Arrays.sort(intervals, (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                } else {
                    return Integer.compare(a[1], b[1]);
                }
            });

            char[] result = new char[n];
            int lastC = -1;
            int lastJ = -1;
            boolean possible = true;

            for (int[] interval : intervals) {
                int start = interval[0];
                int end = interval[1];
                int originalIndex = findOriginalIndex(originalIntervals, start, end);

                if (start >= lastC) {
                    result[originalIndex] = 'C';
                    lastC = end;
                } else if (start >= lastJ) {
                    result[originalIndex] = 'J';
                    lastJ = end;
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println("Case #" + p + ": " + new String(result));
            } else {
                System.out.println("Case #" + p + ": IMPOSSIBLE");
            }
        }
    }

    private static int findOriginalIndex(int[][] originalIntervals, int start, int end) {
        for (int i = 0; i < originalIntervals.length; i++) {
            if (originalIntervals[i][0] == start && originalIntervals[i][1] == end) {
                originalIntervals[i][0] = -1; // Mark as used
                originalIntervals[i][1] = -1; // Mark as used
                return i;
            }
        }
        return -1; // Should never reach here if input is valid
    }
}