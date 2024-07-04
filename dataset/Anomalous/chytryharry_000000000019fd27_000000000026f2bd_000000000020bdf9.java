import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int numActivities = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int j = 0; j < numActivities; j++) {
                activities.add(new Activity(scanner.nextInt(), scanner.nextInt(), j));
            }

            String result = assignSchedules(activities);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String assignSchedules(List<Activity> activities) {
        List<Activity> cameronActivities = new ArrayList<>();
        List<Activity> jamieActivities = new ArrayList<>();
        List<Assignment> assignments = new ArrayList<>();
        Map<Activity, Integer> activityIndexMap = new HashMap<>();

        for (int i = 0; i < activities.size(); i++) {
            activityIndexMap.put(activities.get(i), i);
        }

        activities.sort(Comparator.comparingInt(a -> a.start));

        for (Activity activity : activities) {
            if (canAssign(cameronActivities, activity)) {
                cameronActivities.add(activity);
                assignments.add(new Assignment(activity, 'C'));
            } else if (canAssign(jamieActivities, activity)) {
                jamieActivities.add(activity);
                assignments.add(new Assignment(activity, 'J'));
            } else {
                return "IMPOSSIBLE";
            }
        }

        char[] result = new char[activities.size()];
        for (Assignment assignment : assignments) {
            result[activityIndexMap.get(assignment.activity)] = assignment.assignee;
        }

        return new String(result);
    }

    private static boolean canAssign(List<Activity> assignedActivities, Activity newActivity) {
        for (Activity activity : assignedActivities) {
            if (newActivity.start < activity.end && newActivity.end > activity.start) {
                return false;
            }
        }
        return true;
    }

    private static class Activity {
        int start;
        int end;
        int index;

        Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Activity activity = (Activity) obj;
            return start == activity.start && end == activity.end && index == activity.index;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end, index);
        }
    }

    private static class Assignment {
        Activity activity;
        char assignee;

        Assignment(Activity activity, char assignee) {
            this.activity = activity;
            this.assignee = assignee;
        }
    }
}