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

    private String assignActivities(int[][] timeSlots) {
        StringBuilder schedule = new StringBuilder();
        int[][] cSchedule = new int[timeSlots.length][2];
        int[][] jSchedule = new int[timeSlots.length][2];
        int cCount = 0, jCount = 0;

        for (int[] timeSlot : timeSlots) {
            int start = timeSlot[0], end = timeSlot[1];
            if (isTimeSlotFree(cSchedule, start, end)) {
                schedule.append("C");
                cSchedule[cCount][0] = start;
                cSchedule[cCount][1] = end;
                cCount++;
            } else if (isTimeSlotFree(jSchedule, start, end)) {
                schedule.append("J");
                jSchedule[jCount][0] = start;
                jSchedule[jCount][1] = end;
                jCount++;
            } else {
                return "IMPOSSIBLE";
            }
        }
        return schedule.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Solution solution = new Solution();
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            int[][] timeSlots = new int[n][2];
            for (int j = 0; j < n; j++) {
                timeSlots[j][0] = scanner.nextInt();
                timeSlots[j][1] = scanner.nextInt();
            }
            String result = solution.assignActivities(timeSlots);
            System.out.println("Case #" + i + ": " + result);
        }
    }
}