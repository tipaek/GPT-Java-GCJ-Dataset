import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int activityCount = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            
            for (int j = 0; j < activityCount; j++) {
                activities.add(new Activity(scanner.nextInt(), scanner.nextInt()));
            }
            
            String result = assignActivities(activities);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String assignActivities(List<Activity> activities) {
        StringBuilder assignment = new StringBuilder();
        List<Activity> cameronActivities = new ArrayList<>();
        List<Activity> jamieActivities = new ArrayList<>();
        
        for (Activity activity : activities) {
            if (isScheduleAvailable(cameronActivities, activity)) {
                cameronActivities.add(activity);
                assignment.append("C");
            } else if (isScheduleAvailable(jamieActivities, activity)) {
                jamieActivities.add(activity);
                assignment.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        return assignment.toString();
    }

    private static boolean isScheduleAvailable(List<Activity> activities, Activity newActivity) {
        for (Activity activity : activities) {
            if ((newActivity.start < activity.stop && newActivity.stop > activity.start)) {
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