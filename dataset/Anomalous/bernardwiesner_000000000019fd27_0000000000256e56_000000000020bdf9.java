import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            StringBuilder result = new StringBuilder();
            int activitiesCount = scanner.nextInt();
            Parent cameron = new Parent();
            Parent jamie = new Parent();
            boolean impossible = false;

            for (int j = 0; j < activitiesCount; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                Activity activity = new Activity(start, end);

                if (impossible) continue;

                if (cameron.canTakeActivity(activity)) {
                    result.append("C");
                } else if (jamie.canTakeActivity(activity)) {
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    impossible = true;
                }
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }

    static class Activity {
        final int start;
        final int end;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean overlapsWith(Activity other) {
            return (other.start < end && other.end > start);
        }
    }

    static class Parent {
        List<Activity> activities = new ArrayList<>();

        public boolean canTakeActivity(Activity activity) {
            for (Activity a : activities) {
                if (a.overlapsWith(activity)) {
                    return false;
                }
            }
            activities.add(activity);
            return true;
        }
    }
}