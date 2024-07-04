import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    static class Activity {
        int startTime;
        int endTime;

        public Activity(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalTestCases = scanner.nextInt();

        for (int i = 0; i < totalTestCases; i++) {
            int n = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                activities.add(new Activity(scanner.nextInt(), scanner.nextInt()));
            }

            String result = assignActivities(activities);
            System.out.printf("Case #%d: %s%n", i + 1, result);
        }
    }

    private static String assignActivities(List<Activity> activities) {
        List<Activity> james = new ArrayList<>();
        List<Activity> cameron = new ArrayList<>();
        StringBuilder taskAssignments = new StringBuilder();

        for (Activity activity : activities) {
            if (canAssignActivity(james, activity)) {
                james.add(activity);
                taskAssignments.append("J");
            } else if (canAssignActivity(cameron, activity)) {
                cameron.add(activity);
                taskAssignments.append("C");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return taskAssignments.toString();
    }

    private static boolean canAssignActivity(List<Activity> assignedActivities, Activity newActivity) {
        for (Activity assignedActivity : assignedActivities) {
            if (!(newActivity.endTime <= assignedActivity.startTime || newActivity.startTime >= assignedActivity.endTime)) {
                return false;
            }
        }
        return true;
    }
}