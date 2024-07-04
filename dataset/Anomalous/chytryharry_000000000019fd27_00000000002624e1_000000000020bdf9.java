import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt(); // Reading the number of test cases
        for (int i = 1; i <= testCases; ++i) {
            int numberOfActivities = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            for (int j = 0; j < numberOfActivities; j++) {
                activities.add(new Activity(scanner.nextInt(), scanner.nextInt()));
            }
            System.out.println("Case #" + i + ": " + assignActivities(activities));
        }
    }

    private static String assignActivities(List<Activity> activities) {
        Stack<String> assignments = new Stack<>();
        Stack<Activity> cameronActivities = new Stack<>();
        Stack<Activity> jamieActivities = new Stack<>();

        for (int i = 0; i < activities.size(); i++) {
            Activity currentActivity = activities.get(i);
            if (isSchedulable(cameronActivities, currentActivity)) {
                cameronActivities.push(currentActivity);
                assignments.push("C");
            } else if (isSchedulable(jamieActivities, currentActivity)) {
                jamieActivities.push(currentActivity);
                assignments.push("J");
            } else {
                if (!assignments.isEmpty() && assignments.peek().equals("C")) {
                    Activity lastCameronActivity = cameronActivities.pop();
                    assignments.pop();
                    if (isSchedulable(jamieActivities, lastCameronActivity)) {
                        assignments.push("J");
                        i--;
                        continue;
                    }
                } else if (!assignments.isEmpty() && assignments.peek().equals("J")) {
                    Activity lastJamieActivity = jamieActivities.pop();
                    assignments.pop();
                    if (isSchedulable(cameronActivities, lastJamieActivity)) {
                        assignments.push("C");
                        i--;
                        continue;
                    }
                }
                return "IMPOSSIBLE";
            }
        }

        StringBuilder result = new StringBuilder();
        while (!assignments.isEmpty()) {
            result.append(assignments.pop());
        }
        return result.reverse().toString();
    }

    private static boolean isSchedulable(List<Activity> activities, Activity newActivity) {
        for (Activity activity : activities) {
            if ((newActivity.start < activity.stop && newActivity.start >= activity.start) ||
                (newActivity.stop > activity.start && newActivity.stop <= activity.stop) ||
                (newActivity.start <= activity.start && newActivity.stop >= activity.stop)) {
                return false;
            }
        }
        return true;
    }

    private static class Activity {
        private final int start;
        private final int stop;

        Activity(int start, int stop) {
            this.start = start;
            this.stop = stop;
        }
    }
}