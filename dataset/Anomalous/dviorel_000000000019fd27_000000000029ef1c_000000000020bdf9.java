import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int activitiesCount = scanner.nextInt();
            StringBuilder result = new StringBuilder();
            List<Activity> cActivities = new ArrayList<>();
            List<Activity> jActivities = new ArrayList<>();
            boolean isImpossible = false;
            
            for (int i = 0; i < activitiesCount; i++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                Activity activity = new Activity(startTime, endTime);
                
                if (activity.canBeScheduled(cActivities)) {
                    cActivities.add(activity);
                    result.append("C");
                } else if (activity.canBeScheduled(jActivities)) {
                    jActivities.add(activity);
                    result.append("J");
                } else {
                    isImpossible = true;
                }
            }
            
            if (isImpossible) {
                result = new StringBuilder("IMPOSSIBLE");
            }
            
            System.out.printf("Case #%d: %s%n", caseNumber, result.toString());
        }
        
        scanner.close();
    }

    static class Activity {
        int start;
        int end;

        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        boolean canBeScheduled(List<Activity> activities) {
            for (Activity activity : activities) {
                if (this.overlapsWith(activity)) {
                    return false;
                }
            }
            return true;
        }

        private boolean overlapsWith(Activity other) {
            return this.start < other.end && this.end > other.start;
        }
    }
}