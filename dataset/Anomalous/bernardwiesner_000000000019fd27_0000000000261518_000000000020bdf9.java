import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; ++testCase) {
            int activitiesCount = scanner.nextInt();
            Parent parentC = new Parent();
            Parent parentJ = new Parent();
            boolean impossible = false;
            StringBuilder result = new StringBuilder();
            
            for (int activityIndex = 0; activityIndex < activitiesCount; activityIndex++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                Activity activity = new Activity(start, end);
                
                if (impossible) continue;
                
                if (parentC.canTakeActivity(activity)) {
                    result.append("C");
                } else if (parentJ.canTakeActivity(activity)) {
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    impossible = true;
                }
            }
            
            System.out.println("Case #" + testCase + ": " + result);
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
            return (this.start < other.end && this.end > other.start);
        }
    }

    static class Parent {
        List<Activity> activities = new ArrayList<>();

        public boolean canTakeActivity(Activity activity) {
            for (Activity existingActivity : activities) {
                if (existingActivity.overlapsWith(activity)) {
                    return false;
                }
            }
            activities.add(activity);
            return true;
        }
    }
}