import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int activitiesCount = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int i = 0; i < activitiesCount; i++) {
                activities.add(new Activity(scanner.nextInt(), scanner.nextInt()));
            }

            String result = assignActivities(activities);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    private static String assignActivities(List<Activity> activities) {
        StringBuilder result = new StringBuilder();
        List<Activity> cameronActivities = new ArrayList<>();
        List<Activity> jamieActivities = new ArrayList<>();

        for (Activity activity : activities) {
            if (canBeScheduled(cameronActivities, activity)) {
                cameronActivities.add(activity);
                result.append("C");
            } else if (canBeScheduled(jamieActivities, activity)) {
                jamieActivities.add(activity);
                result.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return result.toString();
    }

    private static boolean canBeScheduled(List<Activity> scheduledActivities, Activity newActivity) {
        for (Activity scheduledActivity : scheduledActivities) {
            if (isOverlapping(scheduledActivity, newActivity)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isOverlapping(Activity activity1, Activity activity2) {
        return activity1.start < activity2.stop && activity2.start < activity1.stop;
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