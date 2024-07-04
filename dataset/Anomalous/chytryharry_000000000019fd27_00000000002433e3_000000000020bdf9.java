import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int numberOfActivities = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            for (int j = 0; j < numberOfActivities; j++) {
                activities.add(new Activity(scanner.nextInt(), scanner.nextInt()));
            }
            System.out.println("Case #" + i + ": " + assignSchedules(activities));
        }
        scanner.close();
    }

    private static String assignSchedules(List<Activity> activities) {
        StringBuilder result = new StringBuilder();
        List<Activity> cameronActivities = new ArrayList<>();
        List<Activity> jamieActivities = new ArrayList<>();

        for (Activity activity : activities) {
            if (isSchedulable(cameronActivities, activity)) {
                cameronActivities.add(activity);
                result.append("C");
            } else if (isSchedulable(jamieActivities, activity)) {
                jamieActivities.add(activity);
                result.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }
        return result.toString();
    }

    private static boolean isSchedulable(List<Activity> scheduledActivities, Activity newActivity) {
        for (Activity activity : scheduledActivities) {
            if (activity.overlaps(newActivity)) {
                return false;
            }
        }
        return true;
    }

    private static class Activity {
        private final int start;
        private final int end;

        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        boolean overlaps(Activity other) {
            return this.start < other.end && this.end > other.start;
        }
    }
}