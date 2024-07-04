import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();
        for (int i = 0; i < numCases; i++) {
            String result = handleTestCase(scanner);
            System.out.printf("Case #%d: %s%n", i + 1, result);
        }
    }

    private static String handleTestCase(Scanner scanner) {
        int numActivities = scanner.nextInt();
        List<Activity> cameronSchedule = new ArrayList<>();
        List<Activity> jamieSchedule = new ArrayList<>();
        StringBuilder schedule = new StringBuilder();

        for (int i = 0; i < numActivities; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            Activity activity = new Activity(start, end);

            if (assignActivity(activity, cameronSchedule)) {
                schedule.append('C');
            } else if (assignActivity(activity, jamieSchedule)) {
                schedule.append('J');
            } else {
                return "IMPOSSIBLE";
            }
        }
        return schedule.toString();
    }

    private static boolean assignActivity(Activity activity, List<Activity> schedule) {
        for (Activity scheduledActivity : schedule) {
            if (activity.overlapsWith(scheduledActivity)) {
                return false;
            }
        }
        schedule.add(activity);
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
            return !(this.end <= other.start || this.start >= other.end);
        }
    }
}