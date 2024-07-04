import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numCases = input.nextInt();
        for (int n = 0; n < numCases; n++) {
            String result = handleTestCase(input);
            System.out.printf("Case #%d: %s%n", n + 1, result);
        }
    }
    
    static String handleTestCase(Scanner input) {
        int activities = input.nextInt();
        List<Activity> cameron = new ArrayList<>(activities);
        List<Activity> jamie = new ArrayList<>(activities);

        StringBuilder schedule = new StringBuilder();
        boolean isImpossible = false;

        for (int i = 0; i < activities; i++) {
            int start = input.nextInt();
            int end = input.nextInt();
            if (!isImpossible) {
                Activity activity = new Activity(start, end);
                if (assignActivity(activity, cameron)) {
                    schedule.append('C');
                } else if (assignActivity(activity, jamie)) {
                    schedule.append('J');
                } else {
                    isImpossible = true;
                }
            }
        }

        return isImpossible ? "IMPOSSIBLE" : schedule.toString();
    }
    
    static boolean assignActivity(Activity activity, List<Activity> schedule) {
        for (Activity existingActivity : schedule) {
            if (activity.overlapsWith(existingActivity)) {
                return false;
            }
        }
        schedule.add(activity);
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
            return !(this.end <= other.start || this.start >= other.end);
        }
    }
}