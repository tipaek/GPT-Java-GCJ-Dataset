import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int activityCount = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int i = 0; i < activityCount; i++) {
                activities.add(new Activity(scanner.nextInt(), scanner.nextInt(), i));
            }

            String result = assignActivities(activities, activityCount);
            System.out.println("Case #" + testCase + ": " + result);
        }

        scanner.close();
    }

    private static String assignActivities(List<Activity> activities, int activityCount) {
        Collections.sort(activities);
        String[] assignments = new String[activityCount];
        List<Activity> cActivities = new LinkedList<>();
        List<Activity> jActivities = new LinkedList<>();

        for (Activity activity : activities) {
            if (canAssignActivity(cActivities, activity)) {
                cActivities.add(activity);
                assignments[activity.position] = "C";
            } else if (canAssignActivity(jActivities, activity)) {
                jActivities.add(activity);
                assignments[activity.position] = "J";
            } else {
                return "IMPOSSIBLE";
            }
        }

        return String.join("", assignments);
    }

    private static boolean canAssignActivity(List<Activity> assignedActivities, Activity newActivity) {
        return assignedActivities.isEmpty() || newActivity.start >= assignedActivities.get(assignedActivities.size() - 1).end;
    }

    static class Activity implements Comparable<Activity> {
        int start;
        int end;
        int position;

        Activity(int start, int end, int position) {
            this.start = start;
            this.end = end;
            this.position = position;
        }

        @Override
        public int compareTo(Activity other) {
            return Integer.compare(this.start, other.start);
        }
    }
}