import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        for (int i = 0; i < numberOfCases; i++) {
            String result = handleTestCase(scanner);
            System.out.printf("Case #%d: %s%n", i + 1, result);
        }
    }

    static String handleTestCase(Scanner scanner) {
        int numberOfActivities = scanner.nextInt();
        List<Activity> cameronActivities = new ArrayList<>(numberOfActivities);
        List<Activity> jamieActivities = new ArrayList<>(numberOfActivities);

        StringBuilder schedule = new StringBuilder();
        boolean impossible = false;

        for (int i = 0; i < numberOfActivities; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            if (!impossible) {
                Activity activity = new Activity(start, end);
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

    static boolean assignActivity(Activity activity, List<Activity> activities) {
        if (activities.isEmpty()) {
            activities.add(activity);
            return true;
        }

        for (int i = 0; i < activities.size(); i++) {
            Activity existingActivity = activities.get(i);
            if (activity.getStart() == existingActivity.getStart()) {
                return false;
            }
            if (activity.getStart() < existingActivity.getStart()) {
                if (i > 0 && activity.getStart() < activities.get(i - 1).getEnd()) {
                    return false;
                }
                if (activity.getEnd() <= existingActivity.getStart()) {
                    activities.add(i, activity);
                    return true;
                } else {
                    return false;
                }
            }
        }

        if (activities.get(activities.size() - 1).getEnd() <= activity.getStart()) {
            activities.add(activity);
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