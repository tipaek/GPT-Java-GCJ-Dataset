import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            processTestCase(i, scanner);
        }
    }

    private static void processTestCase(int testCaseNumber, Scanner scanner) {
        int numberOfActivities = scanner.nextInt();
        List<Activity> activities = new ArrayList<>();

        for (int i = 0; i < numberOfActivities; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            activities.add(new Activity(start, end, i));
        }

        String result = assignActivities(activities, numberOfActivities);
        System.out.println("Case #" + testCaseNumber + ": " + result);
    }

    private static String assignActivities(List<Activity> activities, int numberOfActivities) {
        char[] assignments = new char[numberOfActivities];
        activities.sort(Comparator.comparingInt(a -> a.start));

        int cEndTime = 0, jEndTime = 0;

        for (Activity activity : activities) {
            if (activity.start < cEndTime && activity.start < jEndTime) {
                return "IMPOSSIBLE";
            }
            if (activity.start >= cEndTime) {
                activity.assignee = 'C';
                cEndTime = activity.end;
            } else {
                activity.assignee = 'J';
                jEndTime = activity.end;
            }
            assignments[activity.originalIndex] = activity.assignee;
        }
        return new String(assignments);
    }

    private static class Activity {
        final int start;
        final int end;
        final int originalIndex;
        char assignee;

        Activity(int start, int end, int originalIndex) {
            this.start = start;
            this.end = end;
            this.originalIndex = originalIndex;
        }
    }
}