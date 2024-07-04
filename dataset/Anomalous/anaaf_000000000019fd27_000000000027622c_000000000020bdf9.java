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

            String result = scheduleActivities(activities);
            System.out.println("Case #" + caseNum + ": " + result);
        }
    }

    private static String scheduleActivities(List<int[]> activities) {
        List<int[]> cameronSchedule = new ArrayList<>();
        List<int[]> jamieSchedule = new ArrayList<>();
        StringBuilder assignment = new StringBuilder();

        for (int[] activity : activities) {
            if (canBeScheduled(cameronSchedule, activity)) {
                cameronSchedule.add(activity);
                assignment.append("C");
            } else if (canBeScheduled(jamieSchedule, activity)) {
                jamieSchedule.add(activity);
                assignment.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return assignment.toString();
    }

    private static boolean canBeScheduled(List<int[]> schedule, int[] activity) {
        for (int[] scheduledActivity : schedule) {
            if (scheduledActivity[1] > activity[0] && scheduledActivity[0] < activity[1]) {
                return false;
            }
        }
        return true;
    }
}