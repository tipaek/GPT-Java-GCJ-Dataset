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

            List<Activity> james = new ArrayList<>();
            List<Activity> cameron = new ArrayList<>();
            StringBuilder taskAssignment = new StringBuilder();

            for (Activity activity : activities) {
                boolean assigned = false;

                if (canAssignActivity(james, activity)) {
                    james.add(activity);
                    taskAssignment.append("J");
                    assigned = true;
                } else if (canAssignActivity(cameron, activity)) {
                    cameron.add(activity);
                    taskAssignment.append("C");
                    assigned = true;
                }

                if (!assigned) {
                    taskAssignment = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.printf("Case #%d: %s%n", i + 1, taskAssignment);
        }

        scanner.close();
    }

    private static boolean canAssignActivity(List<Activity> assignedActivities, Activity newActivity) {
        for (Activity activity : assignedActivities) {
            if (!(newActivity.endTime <= activity.startTime || newActivity.startTime >= activity.endTime)) {
                return false;
            }
        }
        return true;
    }
}