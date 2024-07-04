import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numCases = input.nextInt();
        for (int i = 0; i < numCases; i++) {
            String result = handleTestCase(input);
            System.out.printf("Case #%d: %s%n", i + 1, result);
        }
    }

    private static String handleTestCase(Scanner input) {
        int numActivities = input.nextInt();
        List<Activity> cameronActivities = new ArrayList<>(numActivities);
        List<Activity> jamieActivities = new ArrayList<>(numActivities);
        StringBuilder schedule = new StringBuilder();
        boolean impossible = false;

        for (int i = 0; i < numActivities; i++) {
            int start = input.nextInt();
            int end = input.nextInt();
            Activity activity = new Activity(start, end);

            if (!impossible) {
                if (assignActivity(activity, cameronActivities)) {
                    schedule.append('C');
                } else if (assignActivity(activity, jamieActivities)) {
                    schedule.append('J');
                } else {
                    impossible = true;
                }
            }
        }

        return impossible ? "IMPOSSIBLE" : schedule.toString();
    }

    private static boolean assignActivity(Activity activity, List<Activity> activities) {
        for (Activity existingActivity : activities) {
            if (activity.overlapsWith(existingActivity)) {
                return false;
            }
        }
        activities.add(activity);
        return true;
    }

    private static class Activity {
        private final int start;
        private final int end;

        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        boolean overlapsWith(Activity other) {
            return this.start < other.end && other.start < this.end;
        }
    }
}