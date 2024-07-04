import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int numActivities = scanner.nextInt();
            StringBuilder result = new StringBuilder();
            boolean impossible = false;
            
            Scheduler cameron = new Scheduler();
            Scheduler jamie = new Scheduler();
            
            for (int j = 0; j < numActivities; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                Activity activity = new Activity(start, end);
                
                if (impossible) continue;
                
                if (cameron.canSchedule(activity)) {
                    result.append("C");
                } else if (jamie.canSchedule(activity)) {
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    impossible = true;
                }
            }
            
            System.out.println("Case #" + caseNum + ": " + result);
        }
    }

    static class Activity {
        final int start;
        final int end;

        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        boolean overlapsWith(Activity other) {
            return (this.start < other.end && other.start < this.end);
        }
    }

    static class Scheduler {
        List<Activity> activities = new ArrayList<>();

        boolean canSchedule(Activity activity) {
            for (Activity scheduledActivity : activities) {
                if (scheduledActivity.overlapsWith(activity)) {
                    return false;
                }
            }
            activities.add(activity);
            return true;
        }
    }
}