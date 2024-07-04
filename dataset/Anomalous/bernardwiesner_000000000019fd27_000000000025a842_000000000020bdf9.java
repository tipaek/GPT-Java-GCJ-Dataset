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
                    // result.append("C");
                } else if (jamie.canTakeActivity(activity)) {
                    // result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    impossible = true;
                }
            }
            
            if (!impossible) {
                List<Activity> cameronActivities = cameron.activities;
                List<Activity> jamieActivities = jamie.activities;
                
                for (int j = 0; j < activitiesCount; j++) {
                    if (cameronActivities.isEmpty()) {
                        for (Activity a : jamieActivities) {
                            result.append("J");
                        }
                        break;
                    }
                    if (jamieActivities.isEmpty()) {
                        for (Activity a : cameronActivities) {
                            result.append("C");
                        }
                        break;
                    }
                    if (cameronActivities.get(0).start < jamieActivities.get(0).start) {
                        result.append("C");
                        cameronActivities.remove(0);
                    } else {
                        result.append("J");
                        jamieActivities.remove(0);
                    }
                }
            }
            
            System.out.println("Case #" + i + ": " + result);
            System.out.flush();
        }
    }

    static class Activity implements Comparable<Activity> {
        final int start;
        final int end;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean inRange(Activity activity) {
            return (activity.start >= start && activity.start < end) || (activity.end > start && activity.end <= end);
        }

        @Override
        public int compareTo(Activity other) {
            return Integer.compare(this.start, other.start);
        }
    }

    static class Parent {
        List<Activity> activities = new ArrayList<>();

        boolean canTakeActivity(Activity activity) {
            for (Activity a : activities) {
                if (a.inRange(activity)) return false;
            }
            activities.add(activity);
            Collections.sort(activities);
            return true;
        }
    }
}