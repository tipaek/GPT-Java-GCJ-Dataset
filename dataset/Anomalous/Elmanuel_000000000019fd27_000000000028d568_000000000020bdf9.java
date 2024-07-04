import java.util.*;

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
        activities.sort(Comparator.comparingInt(a -> a.start));

        String[] assignments = new String[activityCount];
        List<Activity> cameronActivities = new ArrayList<>();
        List<Activity> jamieActivities = new ArrayList<>();

        for (Activity activity : activities) {
            if (canAssign(cameronActivities, activity)) {
                cameronActivities.add(activity);
                assignments[activity.position] = "C";
            } else if (canAssign(jamieActivities, activity)) {
                jamieActivities.add(activity);
                assignments[activity.position] = "J";
            } else {
                return "IMPOSSIBLE";
            }
        }

        return String.join("", assignments);
    }

    private static boolean canAssign(List<Activity> assignedActivities, Activity newActivity) {
        return assignedActivities.isEmpty() || newActivity.start >= assignedActivities.get(assignedActivities.size() - 1).end;
    }

    static class Activity {
        int start;
        int end;
        int position;

        Activity(int start, int end, int position) {
            this.start = start;
            this.end = end;
            this.position = position;
        }
    }
}