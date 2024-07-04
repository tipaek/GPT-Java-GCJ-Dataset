import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numCases = input.nextInt();
        for (int n = 0; n < numCases; n++) {
            String result = processTestCase(input);
            System.out.printf("Case #%d: %s%n", n + 1, result);
        }
    }

    static String processTestCase(Scanner input) {
        int activities = input.nextInt();

        List<Activity> cameron = new ArrayList<>();
        List<Activity> jamie = new ArrayList<>();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < activities; i++) {
            int start = input.nextInt();
            int end = input.nextInt();

            Activity activity = new Activity(start, end);

            if (tryAddActivity(activity, cameron)) {
                result.append('C');
            } else if (tryAddActivity(activity, jamie)) {
                result.append('J');
            } else {
                return "IMPOSSIBLE";
            }
        }
        return result.toString();
    }

    static boolean tryAddActivity(Activity activity, List<Activity> activityList) {
        if (activityList.isEmpty()) {
            activityList.add(activity);
            return true;
        }

        for (int i = 0; i < activityList.size(); i++) {
            Activity current = activityList.get(i);
            if (activity.getStart() < current.getStart() && activity.getEnd() <= current.getStart()) {
                activityList.add(i, activity);
                return true;
            }
        }

        if (activityList.get(activityList.size() - 1).getEnd() <= activity.getStart()) {
            activityList.add(activity);
            return true;
        }
        return false;
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
    }
}