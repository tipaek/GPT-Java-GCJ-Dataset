import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numCases = input.nextInt();
        for (int caseIndex = 1; caseIndex <= numCases; caseIndex++) {
            String result = processTestCase(input);
            System.out.printf("Case #%d: %s%n", caseIndex, result);
        }
    }

    static String processTestCase(Scanner input) {
        int numActivities = input.nextInt();
        List<Activity> cameronActivities = new ArrayList<>();
        List<Activity> jamieActivities = new ArrayList<>();
        StringBuilder schedule = new StringBuilder();

        boolean isImpossible = false;

        for (int i = 0; i < numActivities; i++) {
            int start = input.nextInt();
            int end = input.nextInt();
            Activity activity = new Activity(start, end);

            if (!isImpossible) {
                if (assignActivity(activity, cameronActivities)) {
                    schedule.append('C');
                } else if (assignActivity(activity, jamieActivities)) {
                    schedule.append('J');
                } else {
                    isImpossible = true;
                }
            }
        }

        return isImpossible ? "IMPOSSIBLE" : schedule.toString();
    }

    static boolean assignActivity(Activity activity, List<Activity> activities) {
        for (Activity existingActivity : activities) {
            if (activity.overlapsWith(existingActivity)) {
                return false;
            }
        }
        activities.add(activity);
        Collections.sort(activities, Comparator.comparingInt(Activity::getStart));
        return true;
    }

    static class Activity {
        private final int start;
        private final int end;

        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        int getStart() {
            return start;
        }

        int getEnd() {
            return end;
        }

        boolean overlapsWith(Activity other) {
            return this.start < other.end && other.start < this.end;
        }
    }
}