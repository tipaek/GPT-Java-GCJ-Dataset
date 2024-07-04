import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int activitiesCount = scanner.nextInt();
            StringBuilder schedule = new StringBuilder();
            List<Activity> cameronActivities = new ArrayList<>();
            List<Activity> jamieActivities = new ArrayList<>();
            boolean isImpossible = false;

            for (int i = 0; i < activitiesCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                Activity activity = new Activity(start, end);

                if (activity.canBeScheduled(cameronActivities)) {
                    cameronActivities.add(activity);
                    schedule.append("C");
                } else if (activity.canBeScheduled(jamieActivities)) {
                    jamieActivities.add(activity);
                    schedule.append("J");
                } else {
                    isImpossible = true;
                }
            }

            if (isImpossible) {
                schedule = new StringBuilder("IMPOSSIBLE");
            }

            System.out.printf("Case #%d: %s%n", caseNumber, schedule.toString());
        }
    }

    static class Activity {
        int start;
        int end;

        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        boolean canBeScheduled(List<Activity> activities) {
            for (Activity activity : activities) {
                if (this.overlapsWith(activity)) {
                    return false;
                }
            }
            return true;
        }

        private boolean overlapsWith(Activity other) {
            return !(this.end <= other.start || this.start >= other.end);
        }
    }
}