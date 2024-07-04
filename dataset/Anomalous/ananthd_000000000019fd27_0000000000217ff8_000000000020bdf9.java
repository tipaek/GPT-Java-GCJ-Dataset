import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            int numActivities = scanner.nextInt();
            Activity[] activities = new Activity[numActivities];

            for (int j = 0; j < numActivities; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[j] = new Activity(start, end);
            }

            List<Activity> sortedActivities = Arrays.asList(activities);
            sortedActivities.sort(Comparator.comparingInt(activity -> activity.start));

            Activity jActivity = null;
            Activity cActivity = null;
            boolean impossible = false;

            for (Activity activity : sortedActivities) {
                int start = activity.start;

                if (jActivity != null && jActivity.end <= start) {
                    jActivity = null;
                }
                if (cActivity != null && cActivity.end <= start) {
                    cActivity = null;
                }

                if (jActivity != null && cActivity != null) {
                    impossible = true;
                    break;
                } else if (jActivity != null) {
                    activity.assigned = 'C';
                    cActivity = activity;
                } else if (cActivity != null) {
                    activity.assigned = 'J';
                    jActivity = activity;
                } else {
                    activity.assigned = 'J';
                    jActivity = activity;
                }
            }

            if (impossible) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                StringBuilder result = new StringBuilder();
                for (Activity activity : activities) {
                    result.append(activity.assigned);
                }
                System.out.println("Case #" + i + ": " + result.toString());
            }
        }
    }

    private static class Activity {
        int start, end;
        char assigned;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}