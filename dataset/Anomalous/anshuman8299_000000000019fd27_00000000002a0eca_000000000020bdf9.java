import java.util.*;
import java.io.*;

public class Solution {

    private boolean isTimeSlotFree(int[][] schedule, int start, int end) {
        for (int[] slot : schedule) {
            if (slot[0] == 0 && slot[1] == 0) continue;
            if ((slot[0] < start && slot[1] > start) || (slot[0] < end && slot[1] > end) ||
                (start < slot[0] && end > slot[0]) || (start < slot[1] && end > slot[1]) ||
                (slot[0] == start && slot[1] == end)) {
                return false;
            }
        }
        return true;
    }

    private String assignSchedule(int[][] intervals) {
        StringBuilder assignments = new StringBuilder();
        int[][] cSchedule = new int[intervals.length][2];
        int[][] jSchedule = new int[intervals.length][2];
        int cCount = 0, jCount = 0;

        for (int[] interval : intervals) {
            if (isTimeSlotFree(cSchedule, interval[0], interval[1])) {
                assignments.append("C");
                cSchedule[cCount++] = interval;
            } else if (isTimeSlotFree(jSchedule, interval[0], interval[1])) {
                assignments.append("J");
                jSchedule[jCount++] = interval;
            } else {
                return "IMPOSSIBLE";
            }
        }

        return assignments.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Solution solution = new Solution();
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            for (int j = 0; j < n; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
            }
            String result = solution.assignSchedule(intervals);
            System.out.println("Case #" + i + ": " + result);
        }
    }
}