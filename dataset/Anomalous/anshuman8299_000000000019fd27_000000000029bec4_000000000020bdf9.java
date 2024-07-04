import java.util.*;
import java.io.*;

public class Solution {

    private boolean isTimeSlotFree(int[][] schedule, int start, int end) {
        if (start > 1440 || end > 1440) return false;
        for (int[] slot : schedule) {
            if (slot[0] == 0 && slot[1] == 0) continue;
            if ((slot[0] <= start && slot[1] >= start) || (slot[0] <= end && slot[1] >= end)) {
                return false;
            }
        }
        return true;
    }

    private String determineSchedule(int[][] intervals) {
        StringBuilder result = new StringBuilder();
        int[][] cameronSchedule = new int[intervals.length][2];
        int[][] jamieSchedule = new int[intervals.length][2];
        int cameronCount = 0;
        int jamieCount = 0;

        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (isTimeSlotFree(cameronSchedule, start, end)) {
                result.append("C");
                cameronSchedule[cameronCount][0] = start;
                cameronSchedule[cameronCount][1] = end;
                cameronCount++;
            } else if (isTimeSlotFree(jamieSchedule, start, end)) {
                result.append("J");
                jamieSchedule[jamieCount][0] = start;
                jamieSchedule[jamieCount][1] = end;
                jamieCount++;
            } else {
                return "IMPOSSIBLE";
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Solution solution = new Solution();
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int numIntervals = scanner.nextInt();
            int[][] intervals = new int[numIntervals][2];

            for (int j = 0; j < numIntervals; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
            }

            String schedule = solution.determineSchedule(intervals);
            System.out.println("Case #" + i + ": " + schedule);
        }
    }
}