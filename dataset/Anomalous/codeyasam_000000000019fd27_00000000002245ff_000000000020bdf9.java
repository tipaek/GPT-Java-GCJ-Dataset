import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int numActivities = scanner.nextInt();
            List<int[]> activities = getActivities(numActivities, scanner);
            String result = assignTasks(activities);
            System.out.println("Case #" + caseNum + ": " + result);
        }
    }

    private static List<int[]> getActivities(int numActivities, Scanner scanner) {
        List<int[]> activities = new ArrayList<>();
        for (int i = 0; i < numActivities; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            activities.add(new int[] { start, end });
        }
        return activities;
    }

    private static String assignTasks(List<int[]> activities) {
        StringBuilder assignments = new StringBuilder("C");
        int latestEndTime = activities.get(0)[1];
        int overlaps = 0;

        for (int i = 1; i < activities.size(); i++) {
            int[] current = activities.get(i);
            int[] previous = activities.get(i - 1);
            int currentStart = current[0];
            int previousEnd = previous[1];
            String nextAssignment = assignments.charAt(assignments.length() - 1) == 'J' ? "C" : "J";

            if (currentStart == previousEnd) {
                nextAssignment = String.valueOf(assignments.charAt(assignments.length() - 1));
            } else if (isOverlapping(current, latestEndTime)) {
                overlaps++;
            }

            assignments.append(nextAssignment);
            latestEndTime = Math.max(latestEndTime, current[1]);
        }

        return overlaps == activities.size() - 1 ? "IMPOSSIBLE" : assignments.toString();
    }

    private static boolean isOverlapping(int[] currentActivity, int latestEndTime) {
        return currentActivity[0] < latestEndTime;
    }
}