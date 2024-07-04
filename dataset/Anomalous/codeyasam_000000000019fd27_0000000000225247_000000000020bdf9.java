import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = scanner.nextInt();
        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            int activityCount = scanner.nextInt();
            List<int[]> activities = getActivities(activityCount, scanner);
            String result = assignTasks(activities);
            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    private static List<int[]> getActivities(int activityCount, Scanner scanner) {
        List<int[]> activities = new ArrayList<>();
        for (int i = 0; i < activityCount; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            activities.add(new int[] {start, end});
        }
        return activities;
    }

    private static String assignTasks(List<int[]> activities) {
        StringBuilder schedule = new StringBuilder("C");
        int maxEndTime = activities.get(0)[1];
        int overlapCount = 0;
        int cCount = 1;
        int jCount = 0;

        for (int i = 1; i < activities.size(); i++) {
            int[] currentActivity = activities.get(i);
            int[] previousActivity = activities.get(i - 1);
            int currentStart = currentActivity[0];
            int previousEnd = previousActivity[1];
            String assignment = cCount <= jCount ? "C" : "J";

            if (currentStart == previousEnd) {
                assignment = schedule.substring(schedule.length() - 1);
            } else if (overlaps(currentActivity, maxEndTime)) {
                overlapCount++;
            }

            if (assignment.equals("C")) {
                cCount++;
            } else {
                jCount++;
            }
            schedule.append(assignment);
            maxEndTime = Math.max(maxEndTime, currentActivity[1]);
        }
        return overlapCount == activities.size() - 1 ? "IMPOSSIBLE" : schedule.toString();
    }

    private static boolean overlaps(int[] currentActivity, int maxEndTime) {
        return currentActivity[0] < maxEndTime;
    }
}