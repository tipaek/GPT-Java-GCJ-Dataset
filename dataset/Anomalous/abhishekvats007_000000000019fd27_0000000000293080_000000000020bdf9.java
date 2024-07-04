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

            List<Activity> jamesActivities = new ArrayList<>();
            List<Activity> cameronActivities = new ArrayList<>();
            StringBuilder schedule = new StringBuilder();

            for (Activity activity : activities) {
                boolean assignedToJames = canAssignActivity(jamesActivities, activity);

                if (assignedToJames) {
                    jamesActivities.add(activity);
                    schedule.append("J");
                } else {
                    boolean assignedToCameron = canAssignActivity(cameronActivities, activity);

                    if (assignedToCameron) {
                        cameronActivities.add(activity);
                        schedule.append("C");
                    } else {
                        schedule = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                }
            }

            System.out.printf("Case #%d: %s%n", i + 1, schedule);
        }
    }

    private static boolean canAssignActivity(List<Activity> activities, Activity newActivity) {
        for (Activity activity : activities) {
            if (!(newActivity.endTime <= activity.startTime || newActivity.startTime >= activity.endTime)) {
                return false;
            }
        }
        return true;
    }
}