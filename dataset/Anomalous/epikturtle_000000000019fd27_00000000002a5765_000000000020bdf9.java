import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = Integer.parseInt(scanner.nextLine());

        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            int numberOfActivities = Integer.parseInt(scanner.nextLine());
            Activity[] schedule = new Activity[numberOfActivities];

            for (int activityIndex = 0; activityIndex < numberOfActivities; activityIndex++) {
                StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine());
                int start = Integer.parseInt(tokenizer.nextToken());
                int end = Integer.parseInt(tokenizer.nextToken());
                schedule[activityIndex] = new Activity(start, end);
            }

            String result = assignActivities(schedule);
            System.out.println("Case #" + caseIndex + ": " + result);
        }
    }

    private static String assignActivities(Activity[] schedule) {
        ArrayList<Activity> cameronActivities = new ArrayList<>();
        ArrayList<Activity> jamieActivities = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        for (Activity activity : schedule) {
            if (canAssign(activity, cameronActivities)) {
                cameronActivities.add(activity);
                result.append("C");
            } else if (canAssign(activity, jamieActivities)) {
                jamieActivities.add(activity);
                result.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return result.toString();
    }

    private static boolean canAssign(Activity activity, ArrayList<Activity> personActivities) {
        for (Activity existingActivity : personActivities) {
            if (!(activity.start >= existingActivity.end || activity.end <= existingActivity.start)) {
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