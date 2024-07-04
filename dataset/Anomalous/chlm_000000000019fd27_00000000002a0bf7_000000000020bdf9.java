import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int activityCount = scanner.nextInt();
            ArrayList<Activity> activities = new ArrayList<>();
            String result = "";
            boolean isImpossible = false;

            for (int j = 0; j < activityCount; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new Activity(j, start, end));
            }

            ArrayList<Activity> activitiesC = new ArrayList<>();
            ArrayList<Activity> activitiesJ = new ArrayList<>();

            for (Activity activity : activities) {
                if (canBeAssigned(activity, activitiesC)) {
                    activitiesC.add(activity);
                    activity.owner = 'C';
                } else if (canBeAssigned(activity, activitiesJ)) {
                    activitiesJ.add(activity);
                    activity.owner = 'J';
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                result = "IMPOSSIBLE";
            } else {
                StringBuilder sb = new StringBuilder();
                for (Activity activity : activities) {
                    sb.append(activity.owner);
                }
                result = sb.toString();
            }

            System.out.format("Case #%d: %s\n", i, result);
        }
        scanner.close();
    }

    private static boolean canBeAssigned(Activity activity, ArrayList<Activity> assignedActivities) {
        for (Activity assignedActivity : assignedActivities) {
            if (!(activity.end <= assignedActivity.start || activity.start >= assignedActivity.end)) {
                return false;
            }
        }
        return true;
    }

    private static class Activity {
        int index;
        int start;
        int end;
        char owner;

        Activity(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
            this.owner = 'X';
        }
    }
}