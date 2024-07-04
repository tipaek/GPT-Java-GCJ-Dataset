import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseIndex = 0; caseIndex < testCases; ++caseIndex) {
            int activitiesCount = scanner.nextInt();
            int[][] activities = new int[activitiesCount][2];
            String[] assignedSchedules = new String[activitiesCount];
            String resultSchedule = "";

            for (int activityIndex = 0; activityIndex < activitiesCount; activityIndex++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[activityIndex][0] = start;
                activities[activityIndex][1] = end;

                assignedSchedules = assignSchedule(activities, assignedSchedules, activityIndex);

                if (assignedSchedules[activityIndex] == null) {
                    resultSchedule = "IMPOSSIBLE";
                    break;
                }
                resultSchedule += assignedSchedules[activityIndex];
            }
            System.out.println("Case #" + caseIndex + ": " + resultSchedule);
        }
    }

    private static String[] assignSchedule(int[][] activities, String[] assignedSchedules, int currentActivityIndex) {
        if (currentActivityIndex == 0) {
            assignedSchedules[currentActivityIndex] = "J";
            return assignedSchedules;
        }

        assignedSchedules[currentActivityIndex] = null;
        int currentStart = activities[currentActivityIndex][0];
        int currentEnd = activities[currentActivityIndex][1];
        boolean isJOccupied = false;

        for (int i = 0; i < currentActivityIndex; i++) {
            int start = activities[i][0];
            int end = activities[i][1];

            if (!(currentStart < start && currentEnd <= start) && !(currentStart >= end)) {
                if (isJOccupied) {
                    assignedSchedules[currentActivityIndex] = null;
                    return assignedSchedules;
                } else if ("J".equals(assignedSchedules[i])) {
                    isJOccupied = true;
                }
            }
        }

        if (isJOccupied) {
            assignedSchedules[currentActivityIndex] = "C";
        } else {
            assignedSchedules[currentActivityIndex] = "J";
        }

        return assignedSchedules;
    }
}