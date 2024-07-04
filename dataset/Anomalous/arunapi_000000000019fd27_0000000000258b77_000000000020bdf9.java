import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            int activitiesCount = scanner.nextInt();
            StringBuilder schedule = new StringBuilder();
            int[][] cSchedule = new int[activitiesCount][2];
            int[][] jSchedule = new int[activitiesCount][2];

            boolean possible = true;

            for (int activityIndex = 0; activityIndex < activitiesCount; activityIndex++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();

                if (!isTimeSlotOccupied(startTime, endTime, cSchedule, activityIndex)) {
                    schedule.append("C");
                    cSchedule[activityIndex][0] = startTime;
                    cSchedule[activityIndex][1] = endTime;
                    jSchedule[activityIndex][0] = -1;
                    jSchedule[activityIndex][1] = -1;
                } else if (!isTimeSlotOccupied(startTime, endTime, jSchedule, activityIndex)) {
                    schedule.append("J");
                    jSchedule[activityIndex][0] = startTime;
                    jSchedule[activityIndex][1] = endTime;
                    cSchedule[activityIndex][0] = -1;
                    cSchedule[activityIndex][1] = -1;
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + schedule.toString());
        }
    }

    private static boolean isTimeSlotOccupied(int start, int end, int[][] schedule, int activityCount) {
        for (int i = 0; i < activityCount; i++) {
            int scheduledStart = schedule[i][0];
            int scheduledEnd = schedule[i][1];

            if (!((start < scheduledStart && end <= scheduledStart) || (start >= scheduledEnd))) {
                return true;
            }
        }
        return false;
    }
}