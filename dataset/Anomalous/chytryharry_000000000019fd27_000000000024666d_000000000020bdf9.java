import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseIndex = 1; caseIndex <= testCases; caseIndex++) {
            int numberOfActivities = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            
            for (int activityIndex = 0; activityIndex < numberOfActivities; activityIndex++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new Activity(start, end));
            }
            
            String result = scheduleActivities(activities);
            System.out.println("Case #" + caseIndex + ": " + result);
        }
    }

    private static String scheduleActivities(List<Activity> activities) {
        StringBuilder schedule = new StringBuilder();
        List<Activity> cameronActivities = new ArrayList<>();
        List<Activity> jamieActivities = new ArrayList<>();

        for (Activity activity : activities) {
            if (isSchedulable(cameronActivities, activity)) {
                cameronActivities.add(activity);
                schedule.append("C");
            } else if (isSchedulable(jamieActivities, activity)) {
                jamieActivities.add(activity);
                schedule.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }
        return schedule.toString();
    }

    private static boolean isSchedulable(List<Activity> existingActivities, Activity newActivity) {
        for (Activity activity : existingActivities) {
            if (newActivity.start < activity.end && newActivity.end > activity.start) {
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
    }
}