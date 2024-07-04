import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> results = new ArrayList<>();
        int cases = scanner.nextInt();

        for (int i = 0; i < cases; i++) {
            int activitiesCount = scanner.nextInt();
            Activity[] activities = new Activity[activitiesCount];
            List<Activity> cameronActivities = new ArrayList<>();
            List<Activity> jamieActivities = new ArrayList<>();
            boolean noOverlap = true;
            String result = "";

            for (int j = 0; j < activitiesCount; j++) {
                activities[j] = new Activity(scanner.nextInt(), scanner.nextInt());
            }

            cameronActivities.add(activities[0]);
            result += "C";
            result += allocateActivities(noOverlap, cameronActivities, jamieActivities, activities);

            if (result.contains("IMPOSSIBLE")) {
                result = "";
                cameronActivities.clear();
                jamieActivities.clear();
                jamieActivities.add(activities[0]);
                result += "J";
                result += allocateActivities(noOverlap, cameronActivities, jamieActivities, activities);

                if (result.contains("IMPOSSIBLE")) {
                    result = "IMPOSSIBLE";
                }
            }

            results.add(result);
        }

        for (int i = 0; i < results.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + results.get(i));
        }
    }

    private static boolean hasOverlap(Activity a1, Activity a2) {
        return (a1.start < a2.end && a1.end > a2.start);
    }

    private static String allocateActivities(boolean noOverlap, List<Activity> cameronActivities, List<Activity> jamieActivities, Activity[] activities) {
        String result = "";
        for (int j = 1; j < activities.length; j++) {
            noOverlap = true;

            for (Activity cameronActivity : cameronActivities) {
                if (hasOverlap(activities[j], cameronActivity)) {
                    noOverlap = false;
                    break;
                }
            }

            if (noOverlap) {
                cameronActivities.add(activities[j]);
                result += "C";
                continue;
            }

            noOverlap = true;
            for (Activity jamieActivity : jamieActivities) {
                if (hasOverlap(activities[j], jamieActivity)) {
                    noOverlap = false;
                    break;
                }
            }

            if (noOverlap) {
                jamieActivities.add(activities[j]);
                result += "J";
            } else {
                return "IMPOSSIBLE";
            }
        }
        return result;
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