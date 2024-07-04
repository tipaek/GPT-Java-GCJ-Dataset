import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int activitiesCount = scanner.nextInt();
            Activity[] activities = new Activity[activitiesCount];

            for (int i = 0; i < activitiesCount; i++) {
                activities[i] = new Activity(scanner.nextInt(), scanner.nextInt());
            }

            Scheduler scheduler = new Scheduler(activitiesCount, activities);
            System.out.println("Case #" + t + ": " + scheduler.schedule());
        }
    }

    static class Scheduler {
        private final Activity[] activities;
        private final int numberOfActivities;
        private final ArrayDeque<Activity> cameronActivities = new ArrayDeque<>();
        private final ArrayDeque<Activity> jamieActivities = new ArrayDeque<>();

        public Scheduler(int numberOfActivities, Activity[] activities) {
            this.numberOfActivities = numberOfActivities;
            this.activities = activities;
        }

        public String schedule() {
            char[] assignments = new char[numberOfActivities];
            return findSchedule(0, assignments) ? new String(assignments) : "IMPOSSIBLE";
        }

        private boolean findSchedule(int currentIndex, char[] assignments) {
            if (currentIndex == numberOfActivities) {
                return true;
            }

            assignments[currentIndex] = 'C';
            if (isValidAssignment(currentIndex, 'C')) {
                cameronActivities.push(activities[currentIndex]);
                if (findSchedule(currentIndex + 1, assignments)) {
                    return true;
                }
                cameronActivities.pop();
            }

            assignments[currentIndex] = 'J';
            if (isValidAssignment(currentIndex, 'J')) {
                jamieActivities.push(activities[currentIndex]);
                if (findSchedule(currentIndex + 1, assignments)) {
                    return true;
                }
                jamieActivities.pop();
            }

            return false;
        }

        private boolean isValidAssignment(int activityIndex, char assignee) {
            Activity currentActivity = activities[activityIndex];
            ArrayDeque<Activity> selectedActivities = (assignee == 'C') ? cameronActivities : jamieActivities;
            return !isOverlapping(currentActivity, selectedActivities);
        }

        private boolean isOverlapping(Activity currentActivity, ArrayDeque<Activity> selectedActivities) {
            for (Activity activity : selectedActivities) {
                if (activity.s < currentActivity.e && currentActivity.s < activity.e) {
                    return true;
                }
            }
            return false;
        }
    }

    static class Activity {
        int s, e;

        public Activity(int start, int end) {
            this.s = start;
            this.e = end;
        }
    }
}