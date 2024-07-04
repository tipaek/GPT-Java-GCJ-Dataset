import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int activityCount = scanner.nextInt();
            List<int[]> activities = new ArrayList<>();

            for (int i = 0; i < activityCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new int[]{start, end});
            }

            String result = assignActivities(activities);
            System.out.println("Case #" + caseNum + ": " + result);
        }
    }

    private static String assignActivities(List<int[]> activities) {
        List<int[]> cameron = new ArrayList<>();
        List<int[]> jamie = new ArrayList<>();
        StringBuilder schedule = new StringBuilder();

        for (int[] activity : activities) {
            if (canAssign(cameron, activity)) {
                cameron.add(activity);
                schedule.append('C');
            } else if (canAssign(jamie, activity)) {
                jamie.add(activity);
                schedule.append('J');
            } else {
                return "IMPOSSIBLE";
            }
        }

        return schedule.toString();
    }

    private static boolean canAssign(List<int[]> schedule, int[] activity) {
        for (int[] slot : schedule) {
            if (activity[0] < slot[1] && activity[1] > slot[0]) {
                return false;
            }
        }
        return true;
    }
}