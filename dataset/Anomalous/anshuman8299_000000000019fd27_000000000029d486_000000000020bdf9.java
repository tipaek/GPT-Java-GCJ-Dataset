import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    private boolean isTimeSlotFree(int[][] schedule, int start, int end) {
        if (start > 1440 || end > 1440) return false;

        for (int[] time : schedule) {
            if (time[0] == 0 && time[1] == 0) continue;

            if ((time[0] < start && time[1] > start) || (time[0] < end && time[1] > end) ||
                (start < time[0] && end > time[0]) || (start < time[1] && end > time[1])) {
                return false;
            }
        }
        return true;
    }

    private String assignSchedules(int[][] timeSlots) {
        StringBuilder assignments = new StringBuilder();
        int[][] cSchedule = new int[timeSlots.length][2];
        int[][] jSchedule = new int[timeSlots.length][2];
        int cCount = 0, jCount = 0;

        for (int i = 0; i < timeSlots.length; i++) {
            if (i == 1) {
                assignments.append("J");
                jSchedule[jCount++] = timeSlots[i];
            } else if (i == 0 || isTimeSlotFree(cSchedule, timeSlots[i][0], timeSlots[i][1])) {
                assignments.append("C");
                cSchedule[cCount++] = timeSlots[i];
            } else if (i == 1 || isTimeSlotFree(jSchedule, timeSlots[i][0], timeSlots[i][1])) {
                assignments.append("J");
                jSchedule[jCount++] = timeSlots[i];
            } else {
                return "IMPOSSIBLE";
            }

            if (timeSlots[i][0] > 1440 || timeSlots[i][1] > 1440) {
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
            int[][] timeSlots = new int[n][2];

            for (int j = 0; j < n; j++) {
                timeSlots[j][0] = scanner.nextInt();
                timeSlots[j][1] = scanner.nextInt();
            }

            String result = solution.assignSchedules(timeSlots);
            System.out.println("Case #" + i + ": " + result);
        }

        scanner.close();
    }
}