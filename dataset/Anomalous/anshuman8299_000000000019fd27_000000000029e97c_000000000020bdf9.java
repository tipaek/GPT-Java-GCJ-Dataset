import java.util.*;
import java.io.*;

public class Solution {

    private boolean isTimeSlotFree(int[][] schedule, int start, int end) {
        if (start > 1440 || end > 1440) return false;

        for (int[] timeSlot : schedule) {
            if (timeSlot[0] == 0 && timeSlot[1] == 0) continue;

            if ((timeSlot[0] < start && timeSlot[1] > start) || (timeSlot[0] < end && timeSlot[1] > end)) {
                return false;
            } else if ((start < timeSlot[0] && end > timeSlot[0]) || (start < timeSlot[1] && end > timeSlot[1])) {
                return false;
            } else if (timeSlot[0] == start && timeSlot[1] == end) {
                return false;
            }
        }
        return true;
    }

    private String assignSchedules(int[][] intervals) {
        StringBuilder assignment = new StringBuilder();
        int[][] cameronSchedule = new int[intervals.length][2];
        int[][] jamieSchedule = new int[intervals.length][2];
        int cameronCount = 0;
        int jamieCount = 0;

        for (int[] interval : intervals) {
            if (isTimeSlotFree(cameronSchedule, interval[0], interval[1])) {
                assignment.append("C");
                cameronSchedule[cameronCount++] = interval;
            } else if (isTimeSlotFree(jamieSchedule, interval[0], interval[1])) {
                assignment.append("J");
                jamieSchedule[jamieCount++] = interval;
            } else {
                return "IMPOSSIBLE";
            }
        }
        return assignment.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Solution solution = new Solution();
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];

            for (int j = 0; j < n; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
            }

            String result = solution.assignSchedules(intervals);
            System.out.println("Case #" + i + ": " + result);
        }
    }
}