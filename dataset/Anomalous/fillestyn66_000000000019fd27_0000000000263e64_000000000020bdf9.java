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
            return currentActivity == null || currentActivity.stop <= activity.start;
        }

        @Override
        public String toString() {
            return initial + " A: " + currentActivity;
        }
    }

    private static String processResult(List<Activity> activities) {
        StringBuilder result = new StringBuilder();
        Collections.sort(activities);

        Person cameron = new Person();
        cameron.initial = "C";
        Person jamie = new Person();
        jamie.initial = "J";

        for (Activity activity : activities) {
            if (cameron.canTakeActivity(activity)) {
                cameron.currentActivity = activity;
                result.append(cameron.initial);
            } else if (jamie.canTakeActivity(activity)) {
                jamie.currentActivity = activity;
                result.append(jamie.initial);
            } else {
                return "IMPOSSIBLE";
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int numActivities = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int j = 0; j < numActivities; j++) {
                Activity activity = new Activity();
                activity.start = scanner.nextInt();
                activity.stop = scanner.nextInt();
                activities.add(activity);
            }

            String result = processResult(activities);
            System.out.println("Case #" + i + ": " + result);
        }
    }
}