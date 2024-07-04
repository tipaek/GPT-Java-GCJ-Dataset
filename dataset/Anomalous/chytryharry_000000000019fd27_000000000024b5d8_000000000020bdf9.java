import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int activitiesCount = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            
            for (int i = 0; i < activitiesCount; i++) {
                activities.add(new Activity(scanner.nextInt(), scanner.nextInt()));
            }
            
            String result = assignActivities(activities);
            System.out.println("Case #" + caseNum + ": " + result);
        }
    }

    private static String assignActivities(List<Activity> activities) {
        StringBuilder result = new StringBuilder();
        List<Activity> cameronActivities = new ArrayList<>();
        List<Activity> jamieActivities = new ArrayList<>();
        
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

    private static boolean canAddActivity(List<Activity> schedule, Activity newActivity) {
        for (Activity existingActivity : schedule) {
            if (newActivity.overlaps(existingActivity)) {
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
            return !(this.end <= other.start || this.start >= other.end);
        }
    }
}