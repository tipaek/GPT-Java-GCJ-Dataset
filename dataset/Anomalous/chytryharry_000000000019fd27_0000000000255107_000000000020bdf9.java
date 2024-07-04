import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

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

            String result = assignActivities(activities);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String assignActivities(List<Activity> activities) {
        StringBuilder result = new StringBuilder();
        List<Activity> cameronActivities = new ArrayList<>();
        List<Activity> jamieActivities = new ArrayList<>();

        Collections.sort(activities, Comparator.comparingInt(a -> a.start));

        for (Activity activity : activities) {
            if (canAddActivity(cameronActivities, activity)) {
                cameronActivities.add(activity);
                result.append("C");
            } else if (canAddActivity(jamieActivities, activity)) {
                jamieActivities.add(activity);
                result.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }
        return result.toString();
    }

    private static boolean canAddActivity(List<Activity> scheduledActivities, Activity newActivity) {
        for (Activity activity : scheduledActivities) {
            if ((newActivity.start < activity.stop && newActivity.start >= activity.start) ||
                (newActivity.stop > activity.start && newActivity.stop <= activity.stop)) {
                return false;
            }
        }
        return true;
    }

    private static class Activity {
        private final int start;
        private final int stop;

        Activity(int start, int stop) {
            this.start = start;
            this.stop = stop;
        }
    }
}