import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = scanner.nextInt();
        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            int numberOfActivities = scanner.nextInt();
            List<int[]> activityTimes = getActivityTimes(numberOfActivities, scanner);
            String result = assignTasks(activityTimes);
            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    private static String assignTasks(List<int[]> activityTimes) {
        StringBuilder assignment = new StringBuilder("C");
        int lastEndTime = activityTimes.get(0)[1];
        int overlapCounter = 0;
        int countC = 1;
        int countJ = 0;

        for (int i = 1; i < activityTimes.size(); i++) {
            int[] currentActivity = activityTimes.get(i);
            int[] previousActivity = activityTimes.get(i - 1);
            int currentStart = currentActivity[0];
            int previousEnd = previousActivity[1];
            String nextAssignment = countC <= countJ ? "C" : "J";

            if (currentStart == previousEnd) {
                nextAssignment = assignment.substring(assignment.length() - 1);
            } else if (isOverlapping(currentActivity, lastEndTime)) {
                overlapCounter++;
            }

            if (nextAssignment.equals("C")) countC++;
            else if (nextAssignment.equals("J")) countJ++;
            assignment.append(nextAssignment);
            lastEndTime = currentActivity[1];
        }
        return overlapCounter == activityTimes.size() - 1 ? "IMPOSSIBLE" : assignment.toString();
    }

    private static boolean isOverlapping(int[] currentActivity, int lastEndTime) {
        return currentActivity[0] < lastEndTime;
    }

    private static List<int[]> getActivityTimes(int numberOfActivities, Scanner scanner) {
        List<int[]> activityTimes = new ArrayList<>();
        for (int i = 0; i < numberOfActivities; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            activityTimes.add(new int[] {start, end});
        }
        return activityTimes;
    }
}