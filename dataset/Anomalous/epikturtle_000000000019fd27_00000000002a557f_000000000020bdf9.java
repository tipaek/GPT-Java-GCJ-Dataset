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
            Activity[] activities = new Activity[numberOfActivities];

            for (int activityIndex = 0; activityIndex < numberOfActivities; activityIndex++) {
                StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine());
                int start = Integer.parseInt(tokenizer.nextToken());
                int end = Integer.parseInt(tokenizer.nextToken());
                activities[activityIndex] = new Activity(start, end);
            }

            ArrayList<Activity> cameron = new ArrayList<>();
            ArrayList<Activity> jamie = new ArrayList<>();
            StringBuilder schedule = new StringBuilder();

            for (Activity activity : activities) {
                if (isSchedulable(activity, cameron)) {
                    schedule.append("C");
                    cameron.add(activity);
                } else if (isSchedulable(activity, jamie)) {
                    schedule.append("J");
                    jamie.add(activity);
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + caseIndex + ": " + schedule.toString());
        }
    }

    private static boolean isSchedulable(Activity activity, ArrayList<Activity> person) {
        for (Activity scheduledActivity : person) {
            if (!(activity.start >= scheduledActivity.end || activity.end <= scheduledActivity.start)) {
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