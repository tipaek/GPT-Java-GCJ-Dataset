import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int caseNum = 1; caseNum <= testCases; ++caseNum) {
            int numActivities = scanner.nextInt();
            List<int[]> activities = new ArrayList<>();
            for (int i = 0; i < numActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new int[]{start, end});
            }
            String result = assignActivities(activities);
            System.out.println("Case #" + caseNum + ": " + result);
        }
    }

    private static String assignActivities(List<int[]> activities) {
        StringBuilder result = new StringBuilder();
        List<int[]> cameron = new ArrayList<>();
        List<int[]> jamie = new ArrayList<>();
        
        for (int[] activity : activities) {
            if (canFit(cameron, activity)) {
                cameron.add(activity);
                result.append('C');
            } else if (canFit(jamie, activity)) {
                jamie.add(activity);
                result.append('J');
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