import java.util.*;
import java.io.*;

public class Solution {
    private static final int MAX_TIME = 1440;

    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = input.nextInt();
        for (int i = 1; i <= T; i++) {
            String result = processTestCase(input);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String processTestCase(Scanner input) {
        boolean[] c = new boolean[MAX_TIME + 1];
        boolean[] j = new boolean[MAX_TIME + 1];
        int n = input.nextInt();
        int[][] intervals = new int[n][2];
        char[] result = new char[n];
        
        for (int i = 0; i < n; i++) {
            intervals[i][0] = input.nextInt();
            intervals[i][1] = input.nextInt();
        }

        intervals = sortIntervals(intervals);
        if (intervals == null) return "IMPOSSIBLE";
        
        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (canAssign(c, start, end)) {
                result[i] = 'C';
            } else if (canAssign(j, start, end)) {
                result[i] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }

        return new String(result);
    }

    private static int[][] sortIntervals(int[][] intervals) {
        int n = intervals.length;
        int[][] sortedIntervals = new int[n][2];
        int[][] mapping = new int[n][2];
        boolean[] startFlag = new boolean[MAX_TIME + 1];
        boolean[] shadowFlag = new boolean[MAX_TIME + 1];
        int[] startIndex = new int[MAX_TIME + 1];
        int[] shadowIndex = new int[MAX_TIME + 1];

        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            if (!startFlag[start]) {
                startIndex[start] = i;
                startFlag[start] = true;
            } else if (!shadowFlag[start]) {
                shadowIndex[start] = i;
                shadowFlag[start] = true;
            } else {
                return null;
            }
        }

        int p = 0;
        for (int i = 0; i <= MAX_TIME; i++) {
            if (startFlag[i]) {
                int index = startIndex[i];
                sortedIntervals[p] = intervals[index];
                mapping[p][0] = p;
                mapping[p][1] = index;
                p++;
                if (shadowFlag[i]) {
                    index = shadowIndex[i];
                    sortedIntervals[p] = intervals[index];
                    mapping[p][0] = p;
                    mapping[p][1] = index;
                    p++;
                }
            }
        }

        return sortedIntervals;
    }

    private static boolean canAssign(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i]) {
                Arrays.fill(schedule, start, i, false);
                return false;
            }
        }
        Arrays.fill(schedule, start, end, true);
        return true;
    }
}