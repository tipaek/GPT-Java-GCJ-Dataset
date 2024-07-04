import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; ++i) {
            int numActivities = scanner.nextInt();
            ActivityManager cameron = new ActivityManager();
            ActivityManager jamie = new ActivityManager();
            StringBuilder schedule = new StringBuilder();
            boolean impossible = false;

            for (int j = 0; j < numActivities; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                Activity activity = new Activity(start, end);

                if (impossible) continue;

                if (cameron.addActivity(activity)) {
                    schedule.append("C");
                } else if (jamie.addActivity(activity)) {
                    schedule.append("J");
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    impossible = true;
                }
            }

            System.out.println("Case #" + i + ": " + schedule);
        }
    }

    static class Activity {
        final int start;
        final int end;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean overlaps(Activity other) {
            return (this.start < other.end && other.start < this.end);
        }
    }

    static class ActivityManager {
        List<Activity> activities = new ArrayList<>();

        public boolean addActivity(Activity activity) {
            for (Activity existingActivity : activities) {
                if (existingActivity.overlaps(activity)) {
                    return false;
                }
            }
            activities.add(activity);
            return true;
        }
    }
}