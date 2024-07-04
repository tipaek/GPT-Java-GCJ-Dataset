import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    static class Activity {
        int startTime;
        int endTime;

        Activity(int startTime, int endTime) {
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

            List<Activity> jamesActivities = new ArrayList<>();
            List<Activity> cameronActivities = new ArrayList<>();
            StringBuilder taskAssignment = new StringBuilder();

            for (Activity activity : activities) {
                boolean canAssignToJames = canAssignActivity(jamesActivities, activity);
                boolean canAssignToCameron = canAssignActivity(cameronActivities, activity);

                if (canAssignToJames) {
                    jamesActivities.add(activity);
                    taskAssignment.append("J");
                } else if (canAssignToCameron) {
                    cameronActivities.add(activity);
                    taskAssignment.append("C");
                } else {
                    taskAssignment = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.printf("Case #%d: %s%n", i + 1, taskAssignment);
        }
        scanner.close();
    }

    private static boolean canAssignActivity(List<Activity> activities, Activity newActivity) {
        for (Activity activity : activities) {
            if (!(newActivity.endTime <= activity.startTime || activity.endTime <= newActivity.startTime)) {
                return false;
            }
        }
        return true;
    }
}