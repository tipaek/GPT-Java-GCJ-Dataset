import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int numActivities = scanner.nextInt();
            Activity[] activities = new Activity[numActivities];

            for (int i = 0; i < numActivities; i++) {
                activities[i] = new Activity(i, scanner.nextInt(), scanner.nextInt());
            }

            Scheduler scheduler = new Scheduler(numActivities, activities);
            System.out.println("Case #" + t + ": " + scheduler.scheduleActivities());
        }
    }

    public static class Scheduler {

        private Activity[] activities;
        private int numActivities;
        private ArrayDeque<Activity> cameronActivities = new ArrayDeque<>();
        private ArrayDeque<Activity> jamieActivities = new ArrayDeque<>();
        private ArrayDeque<Activity> assignedActivities = new ArrayDeque<>();

        public Scheduler(int numActivities, Activity[] activities) {
            this.numActivities = numActivities;
            this.activities = activities;
        }

        public String scheduleActivities() {
            Arrays.sort(this.activities);
            if (assignActivities(0)) {
                char[] result = new char[numActivities];
                for (Activity activity : assignedActivities) {
                    result[activity.index] = activity.assignedTo;
                }
                return new String(result);
            } else {
                return "IMPOSSIBLE";
            }
        }

        private boolean assignActivities(int activityIndex) {
            if (activityIndex == numActivities) {
                return true;
            }

            Activity currentActivity = activities[activityIndex];

            if (isValidAssignment(currentActivity, 'C', cameronActivities)) {
                currentActivity.assignedTo = 'C';
                cameronActivities.push(currentActivity);
                assignedActivities.push(currentActivity);

                if (assignActivities(activityIndex + 1)) {
                    return true;
                }

                cameronActivities.pop();
                assignedActivities.pop();
            }

            if (isValidAssignment(currentActivity, 'J', jamieActivities)) {
                currentActivity.assignedTo = 'J';
                jamieActivities.push(currentActivity);
                assignedActivities.push(currentActivity);

                if (assignActivities(activityIndex + 1)) {
                    return true;
                }

                jamieActivities.pop();
                assignedActivities.pop();
            }

            return false;
        }

        private boolean isValidAssignment(Activity activity, char assignee, ArrayDeque<Activity> assignedActivities) {
            for (Activity assignedActivity : assignedActivities) {
                if (activity.overlapsWith(assignedActivity)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static class Activity implements Comparable<Activity> {

        int index;
        int start;
        int end;
        char assignedTo;

        public Activity(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Activity other) {
            return Integer.compare(this.start, other.start);
        }

        public boolean overlapsWith(Activity other) {
            return this.start < other.end && other.start < this.end;
        }
    }
}