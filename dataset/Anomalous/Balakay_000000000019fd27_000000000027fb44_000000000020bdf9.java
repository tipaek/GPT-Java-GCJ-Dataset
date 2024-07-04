import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> results = new ArrayList<>();
        int numberOfCases = scanner.nextInt();

        for (int i = 0; i < numberOfCases; i++) {
            int numberOfActivities = scanner.nextInt();
            Activity[] activities = new Activity[numberOfActivities];
            List<Activity> cameronActivities = new ArrayList<>();
            List<Activity> jamieActivities = new ArrayList<>();
            StringBuilder result = new StringBuilder();

            for (int j = 0; j < numberOfActivities; j++) {
                activities[j] = new Activity(scanner.nextInt(), scanner.nextInt());

                if (j == 0) {
                    cameronActivities.add(activities[j]);
                    result.append("C");
                } else {
                    if (canBeAssigned(activities[j], cameronActivities)) {
                        cameronActivities.add(activities[j]);
                        result.append("C");
                    } else if (canBeAssigned(activities[j], jamieActivities)) {
                        jamieActivities.add(activities[j]);
                        result.append("J");
                    } else {
                        result = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                }
            }
            results.add(result.toString());
        }

        for (int i = 0; i < results.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + results.get(i));
        }
    }

    private static boolean canBeAssigned(Activity newActivity, List<Activity> assignedActivities) {
        for (Activity assignedActivity : assignedActivities) {
            if (isOverlapping(newActivity, assignedActivity)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isOverlapping(Activity a1, Activity a2) {
        return a1.start < a2.end && a1.end > a2.start;
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