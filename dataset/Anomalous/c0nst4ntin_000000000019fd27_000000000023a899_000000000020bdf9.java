import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int activityCount = scanner.nextInt();
            List<int[]> activities = new ArrayList<>();
            
            for (int i = 0; i < activityCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new int[]{start, end});
            }
            
            StringBuilder result = new StringBuilder();
            List<int[]> jActivities = new ArrayList<>();
            List<int[]> cActivities = new ArrayList<>();
            
            for (int[] activity : activities) {
                if (canFit(jActivities, activity)) {
                    jActivities.add(activity);
                    result.append('J');
                } else if (canFit(cActivities, activity)) {
                    cActivities.add(activity);
                    result.append('C');
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            
            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    private static boolean canFit(List<int[]> schedule, int[] activity) {
        for (int[] scheduledActivity : schedule) {
            if (isOverlapping(scheduledActivity, activity)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isOverlapping(int[] activity1, int[] activity2) {
        return activity1[0] < activity2[1] && activity2[0] < activity1[1];
    }
}