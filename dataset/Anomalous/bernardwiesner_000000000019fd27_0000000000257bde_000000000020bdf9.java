import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; ++i) {
            int numActivities = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            
            for (int j = 0; j < numActivities; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new Activity(start, end));
            }

            Collections.sort(activities);

            StringBuilder schedule = new StringBuilder();
            Parent cameron = new Parent();
            Parent jamie = new Parent();

            boolean isPossible = true;
            for (Activity activity : activities) {
                if (cameron.canTakeActivity(activity)) {
                    schedule.append("C");
                } else if (jamie.canTakeActivity(activity)) {
                    schedule.append("J");
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + schedule);
        }
    }

    static class Activity implements Comparable<Activity> {
        final int start;
        final int end;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Activity other) {
            return Integer.compare(this.start, other.start);
        }

        public boolean overlapsWith(Activity other) {
            return (this.start < other.end && other.start < this.end);
        }
    }

    static class Parent {
        private final List<Activity> assignedActivities = new ArrayList<>();

        public boolean canTakeActivity(Activity activity) {
            for (Activity assigned : assignedActivities) {
                if (assigned.overlapsWith(activity)) {
                    return false;
                }
            }
            assignedActivities.add(activity);
            return true;
        }
    }
}