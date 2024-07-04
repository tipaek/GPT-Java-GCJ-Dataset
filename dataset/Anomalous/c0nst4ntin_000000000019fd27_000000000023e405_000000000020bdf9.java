import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; ++testCase) {
            int activitiesCount = scanner.nextInt();
            List<int[]> activities = new ArrayList<>();
            
            for (int i = 0; i < activitiesCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new int[]{start, end});
            }
            
            String result = assignActivities(activities);
            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    private static String assignActivities(List<int[]> activities) {
        List<int[]> jActivities = new ArrayList<>();
        List<int[]> cActivities = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        
        for (int[] activity : activities) {
            if (canFit(jActivities, activity)) {
                jActivities.add(activity);
                result.append('J');
            } else if (canFit(cActivities, activity)) {
                cActivities.add(activity);
                result.append('C');
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        return result.toString();
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