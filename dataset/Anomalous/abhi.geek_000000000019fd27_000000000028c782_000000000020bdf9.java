import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalTestCases = Integer.parseInt(scanner.nextLine().trim());

        for (int testCase = 1; testCase <= totalTestCases; testCase++) {
            int totalActivities = Integer.parseInt(scanner.nextLine().trim());
            Activity[] activities = new Activity[totalActivities];

            for (int i = 0; i < totalActivities; i++) {
                String[] timeTokens = scanner.nextLine().trim().split(" ");
                activities[i] = new Activity(Integer.parseInt(timeTokens[0]), Integer.parseInt(timeTokens[1]));
            }

            String result = allotActivities(activities);
            System.out.println("Case #" + testCase + ": " + result);
        }
        scanner.close();
    }

    private static String allotActivities(Activity[] activities) {
        StringBuilder result = new StringBuilder();
        List<Activity> jamieActivities = new ArrayList<>();
        List<Activity> cameronActivities = new ArrayList<>();

        for (Activity activity : activities) {
            if (canAddActivity(jamieActivities, activity)) {
                jamieActivities.add(activity);
                result.append("J");
            } else if (canAddActivity(cameronActivities, activity)) {
                cameronActivities.add(activity);
                result.append("C");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return result.toString();
    }

    private static boolean canAddActivity(List<Activity> activities, Activity newActivity) {
        for (Activity activity : activities) {
            if (newActivity.startTime < activity.endTime && newActivity.endTime > activity.startTime) {
                return false;
            }
        }
        return true;
    }

    private static class Activity {
        int startTime;
        int endTime;

        Activity(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}