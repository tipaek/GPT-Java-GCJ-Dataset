import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int activitiesCount = scanner.nextInt();
            List<int[]> activities = new ArrayList<>();

            for (int i = 0; i < activitiesCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new int[]{start, end});
            }

            String result = assignActivities(activities);
            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static String assignActivities(List<int[]> activities) {
        List<int[]> cameron = new ArrayList<>();
        List<int[]> jamie = new ArrayList<>();
        StringBuilder schedule = new StringBuilder();

        for (int i = 0; i < activities.size(); i++) {
            int[] currentActivity = activities.get(i);
            if (canBeAssigned(cameron, currentActivity)) {
                cameron.add(currentActivity);
                schedule.append('C');
            } else if (canBeAssigned(jamie, currentActivity)) {
                jamie.add(currentActivity);
                schedule.append('J');
            } else {
                return "IMPOSSIBLE";
            }
        }

        return schedule.toString();
    }

    private static boolean canBeAssigned(List<int[]> assignee, int[] activity) {
        for (int[] assignedActivity : assignee) {
            if (!(activity[1] <= assignedActivity[0] || activity[0] >= assignedActivity[1])) {
                return false;
            }
        }
        return true;
    }
}