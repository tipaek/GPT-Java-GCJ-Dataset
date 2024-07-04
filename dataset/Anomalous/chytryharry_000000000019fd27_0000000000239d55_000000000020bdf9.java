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
            int activitiesCount = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            
            for (int j = 0; j < activitiesCount; j++) {
                activities.add(new Activity(scanner.nextInt(), scanner.nextInt()));
            }
            
            String result = analyzeActivities(activities);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String analyzeActivities(List<Activity> activities) {
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

    private static boolean isSchedulable(List<Activity> scheduledActivities, Activity newActivity) {
        for (Activity scheduledActivity : scheduledActivities) {
            if (overlaps(scheduledActivity, newActivity)) {
                return false;
            }
        }
        return true;
    }

    private static boolean overlaps(Activity a1, Activity a2) {
        return a1.start < a2.stop && a2.start < a1.stop;
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