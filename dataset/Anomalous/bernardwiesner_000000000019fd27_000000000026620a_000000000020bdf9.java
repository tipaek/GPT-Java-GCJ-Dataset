import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            StringBuilder result = new StringBuilder();
            int activitiesCount = scanner.nextInt();
            Parent parentJ = new Parent();
            Parent parentC = new Parent();
            boolean isImpossible = false;
            
            for (int activityIndex = 0; activityIndex < activitiesCount; activityIndex++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                Activity activity = new Activity(start, end);
                
                if (isImpossible) {
                    continue;
                }
                
                if (parentJ.canTakeActivity(activity)) {
                    result.append("C");
                } else if (parentC.canTakeActivity(activity)) {
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    isImpossible = true;
                }
            }
            
            System.out.println("Case #" + caseNumber + ": " + result);
            System.out.flush();
        }
    }

    static class Activity {
        final int start;
        final int end;

        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        boolean conflictsWith(Activity other) {
            return (this.start < other.end && other.start < this.end);
        }
    }

    static class Parent {
        List<Activity> activities = new ArrayList<>();

        boolean canTakeActivity(Activity activity) {
            for (Activity existingActivity : activities) {
                if (existingActivity.conflictsWith(activity)) {
                    return false;
                }
            }
            activities.add(activity);
            return true;
        }
    }
}