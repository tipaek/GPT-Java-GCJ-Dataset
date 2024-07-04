import java.util.*;
import java.io.*;

public class Solution {

    private static class Activity implements Comparable<Activity> {
        int start;
        int stop;

        @Override
        public int compareTo(Activity other) {
            return Integer.compare(this.start, other.start);
        }

        @Override
        public String toString() {
            return start + " " + stop;
        }
    }

    private static class Person {
        String initial;
        Activity currentActivity;

        boolean canTakeActivity(Activity activity) {
            return currentActivity == null || activity.stop <= currentActivity.start || activity.start >= currentActivity.stop;
        }

        @Override
        public String toString() {
            return initial + " A: " + currentActivity;
        }
    }

    private static boolean isImpossible(List<Activity> activities) {
        List<Activity> sortedActivities = new ArrayList<>(activities);
        sortedActivities.sort(Activity::compareTo);

        Person C = new Person();
        C.initial = "C";
        Person J = new Person();
        J.initial = "J";

        for (Activity activity : sortedActivities) {
            if (C.currentActivity == null || C.canTakeActivity(activity)) {
                C.currentActivity = activity;
            } else if (J.currentActivity == null || J.canTakeActivity(activity)) {
                J.currentActivity = activity;
            } else {
                return true;
            }
        }
        return false;
    }

    private static String processResult(List<Activity> activities) {
        if (isImpossible(activities)) {
            return "IMPOSSIBLE";
        }

        StringBuilder result = new StringBuilder();
        Person C = new Person();
        C.initial = "C";
        Person J = new Person();
        J.initial = "J";

        for (Activity activity : activities) {
            if (C.currentActivity == null || C.canTakeActivity(activity)) {
                C.currentActivity = activity;
                result.append(C.initial);
            } else if (J.currentActivity == null || J.canTakeActivity(activity)) {
                J.currentActivity = activity;
                result.append(J.initial);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            for (int j = 0; j < n; ++j) {
                Activity activity = new Activity();
                activity.start = scanner.nextInt();
                activity.stop = scanner.nextInt();
                activities.add(activity);
            }
            System.out.println("Case #" + i + ": " + processResult(activities));
        }
    }
}