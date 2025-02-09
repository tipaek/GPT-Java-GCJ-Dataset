import java.util.*;
import java.io.*;

public class Solution {

    private boolean isTimeSlotFree(int[][] schedule, int start, int end) {
        for (int[] slot : schedule) {
            if (slot[0] == 0 && slot[1] == 0) continue;
            if ((slot[0] < start && slot[1] > start) || (slot[0] < end && slot[1] > end)) {
                return false;
            }
        }
        return true;
    }

    private String assignSchedules(int[][] timeSlots) {
        StringBuilder assignments = new StringBuilder();
        int[][] cSchedule = new int[timeSlots.length][2];
        int cCount = 0;
        int[][] jSchedule = new int[timeSlots.length][2];
        int jCount = 0;

        for (int i = 0; i < timeSlots.length; i++) {
            if (i == 0 || isTimeSlotFree(cSchedule, timeSlots[i][0], timeSlots[i][1])) {
                assignments.append("C");
                cSchedule[cCount][0] = timeSlots[i][0];
                cSchedule[cCount][1] = timeSlots[i][1];
                cCount++;
            } else if (i == 1 || isTimeSlotFree(jSchedule, timeSlots[i][0], timeSlots[i][1])) {
                assignments.append("J");
                jSchedule[jCount][0] = timeSlots[i][0];
                jSchedule[jCount][1] = timeSlots[i][1];
                jCount++;
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