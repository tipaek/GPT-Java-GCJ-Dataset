import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int caseCount = Integer.parseInt(scanner.nextLine());

        for (int caseIndex = 1; caseIndex <= caseCount; caseIndex++) {
            int activityCount = Integer.parseInt(scanner.nextLine());
            Activity[] activities = new Activity[activityCount];

            for (int activityIndex = 0; activityIndex < activityCount; activityIndex++) {
                StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine());
                int start = Integer.parseInt(tokenizer.nextToken());
                int end = Integer.parseInt(tokenizer.nextToken());
                activities[activityIndex] = new Activity(start, end);
            }

            String result = assignActivities(activities);
            System.out.println("Case #" + caseIndex + ": " + result);
        }
    }

    private static String assignActivities(Activity[] activities) {
        List<Activity> cameronActivities = new ArrayList<>();
        List<Activity> jamieActivities = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        for (Activity activity : activities) {
            if (isNonOverlapping(activity, cameronActivities)) {
                cameronActivities.add(activity);
                result.append("C");
            } else if (isNonOverlapping(activity, jamieActivities)) {
                jamieActivities.add(activity);
                result.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }
        return result.toString();
    }

    private static boolean isNonOverlapping(Activity newActivity, List<Activity> existingActivities) {
        for (Activity existingActivity : existingActivities) {
            if (!(newActivity.start >= existingActivity.end || newActivity.end <= existingActivity.start)) {
                return false;
            }
        }
        return true;
    }
}

class Activity {
    int start;
    int end;

    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }
}