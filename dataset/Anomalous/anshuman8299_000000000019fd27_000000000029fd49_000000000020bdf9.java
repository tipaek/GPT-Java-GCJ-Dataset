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
        StringBuilder result = new StringBuilder();
        int[][] scheduleC = new int[timeSlots.length][2];
        int[][] scheduleJ = new int[timeSlots.length][2];
        int countC = 0, countJ = 0;

        for (int[] slot : timeSlots) {
            if (isTimeSlotFree(scheduleC, slot[0], slot[1])) {
                result.append("C");
                scheduleC[countC++] = slot;
            } else if (isTimeSlotFree(scheduleJ, slot[0], slot[1])) {
                result.append("J");
                scheduleJ[countJ++] = slot;
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

        for (int i = 1; i <= testCases; ++i) {
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