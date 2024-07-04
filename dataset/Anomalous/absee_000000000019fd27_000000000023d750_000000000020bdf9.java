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
                activities[i] = new Activity(scanner.nextInt(), scanner.nextInt());
            }

            Scheduler scheduler = new Scheduler(numActivities, activities);
            System.out.println("Case #" + t + ": " + scheduler.schedule());
        }
    }

    static class Scheduler {

        private Activity[] activities;
        private int numActivities;

        public Scheduler(int numActivities, Activity[] activities) {
            this.numActivities = numActivities;
            this.activities = activities;
        }

        public String schedule() {
            char[] assignments = new char[numActivities];
            return assignActivities(0, assignments) ? new String(assignments) : "IMPOSSIBLE";
        }

        private ArrayDeque<Activity> cameronActivities = new ArrayDeque<>();
        private ArrayDeque<Activity> jamieActivities = new ArrayDeque<>();

        private boolean isValidAssignment(int index, char assignee) {
            Activity activity = activities[index];
            return assignee == 'C' ? canAssign(activity, cameronActivities) : canAssign(activity, jamieActivities);
        }

        private boolean canAssign(Activity activity, ArrayDeque<Activity> assignedActivities) {
            for (Activity assigned : assignedActivities) {
                if (isOverlapping(activity, assigned)) {
                    return false;
                }
            }
            return true;
        }

        private boolean isOverlapping(Activity a1, Activity a2) {
            return (a1.s < a2.e && a2.s < a1.e);
        }

        private boolean assignActivities(int index, char[] assignments) {
            if (index == numActivities) {
                return true;
            }

            assignments[index] = 'C';
            if (isValidAssignment(index, 'C')) {
                cameronActivities.push(activities[index]);
                if (assignActivities(index + 1, assignments)) {
                    return true;
                }
                cameronActivities.pop();
            }

            assignments[index] = 'J';
            if (isValidAssignment(index, 'J')) {
                jamieActivities.push(activities[index]);
                if (assignActivities(index + 1, assignments)) {
                    return true;
                }
                jamieActivities.pop();
            }

            return false;
        }
    }

    static class Activity {
        int s;
        int e;

        public Activity(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
}