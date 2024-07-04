import java.util.*;
import java.io.*;

public class Solution {

    private boolean isTimeSlotFree(int[][] schedule, int start, int end) {
        for (int[] timeSlot : schedule) {
            if (timeSlot[0] == 0 && timeSlot[1] == 0) continue;
            if ((timeSlot[0] <= start && timeSlot[1] >= start) || (timeSlot[0] <= end && timeSlot[1] >= end)) {
                return false;
            }
        }
        return true;
    }

    private String assignSchedules(int[][] timeSlots) {
        StringBuilder schedule = new StringBuilder();
        int[][] cSchedule = new int[timeSlots.length][2];
        int cCount = 0;
        int[][] jSchedule = new int[timeSlots.length][2];
        int jCount = 0;

        for (int i = 0; i < timeSlots.length; i++) {
            if (i == 0 || isTimeSlotFree(cSchedule, timeSlots[i][0], timeSlots[i][1])) {
                schedule.append("C");
                cSchedule[cCount][0] = timeSlots[i][0];
                cSchedule[cCount][1] = timeSlots[i][1];
                cCount++;
            } else if (i == 1 || isTimeSlotFree(jSchedule, timeSlots[i][0], timeSlots[i][1])) {
                schedule.append("J");
                jSchedule[jCount][0] = timeSlots[i][0];
                jSchedule[jCount][1] = timeSlots[i][1];
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

        for (int i = 1; i <= testCases; ++i) {
            int numTimeSlots = scanner.nextInt();
            int[][] timeSlots = new int[numTimeSlots][2];

            for (int j = 0; j < numTimeSlots; j++) {
                timeSlots[j][0] = scanner.nextInt();
                timeSlots[j][1] = scanner.nextInt();
            }

            String result = solution.assignSchedules(timeSlots);
            System.out.println("Case #" + i + ": " + result);
        }
    }
}