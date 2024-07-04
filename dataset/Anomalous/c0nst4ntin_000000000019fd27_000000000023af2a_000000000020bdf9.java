import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int activitiesCount = scanner.nextInt();
            List<int[]> activities = new ArrayList<>();
            for (int i = 0; i < activitiesCount; i++) {
                int[] activity = {scanner.nextInt(), scanner.nextInt()};
                activities.add(activity);
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

    private static boolean canFit(List<int[]> scheduledActivities, int[] newActivity) {
        for (int[] scheduledActivity : scheduledActivities) {
            if (isColliding(scheduledActivity, newActivity)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isColliding(int[] activity1, int[] activity2) {
        return (activity1[0] < activity2[1] && activity1[1] > activity2[0]);
    }
}