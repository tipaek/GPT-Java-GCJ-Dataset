import java.util.*;
import java.io.*;

public class Solution {

    public static class Activity {
        int start, end;
        public Activity() {
        }
    }

    public static Comparator<Activity> activityComparator = new Comparator<Activity>() {
        public int compare(Activity a1, Activity a2) {
            return Integer.compare(a1.start, a2.start);
        }
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int t = 0; t < testCases; t++) {
            int activityCount = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            for (int i = 0; i < activityCount; i++) {
                Activity activity = new Activity();
                activity.start = scanner.nextInt();
                activity.end = scanner.nextInt();
                activities.add(activity);
            }
            Collections.sort(activities, activityComparator);
            StringBuilder result = new StringBuilder();
            int cEnd = -1, jEnd = -1;
            boolean impossible = false;
            for (Activity activity : activities) {
                if (activity.start >= cEnd) {
                    cEnd = activity.end;
                    result.append("C");
                } else if (activity.start >= jEnd) {
                    jEnd = activity.end;
                    result.append("J");
                } else {
                    impossible = true;
                    break;
                }
            }
            String output = "Case #" + (t + 1) + ": " + (impossible ? "IMPOSSIBLE" : result.toString());
            System.out.println(output);
        }
        scanner.close();
    }
}