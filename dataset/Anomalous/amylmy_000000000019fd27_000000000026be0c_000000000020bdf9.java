import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseCount = scanner.nextInt();
        for (int caseIndex = 1; caseIndex <= caseCount; caseIndex++) {
            System.out.println(String.format("Case #%d: %s", caseIndex, new Solution().solve(scanner)));
        }
    }

    public String solve(Scanner scanner) {
        int activityCount = scanner.nextInt();
        int[][] activities = new int[activityCount][2];
        for (int i = 0; i < activityCount; i++) {
            activities[i][0] = scanner.nextInt();
            activities[i][1] = scanner.nextInt();
        }

        List<int[]> cSchedule = new ArrayList<>();
        List<int[]> jSchedule = new ArrayList<>();

        StringBuilder schedule = new StringBuilder("C");
        cSchedule.add(activities[0]);

        for (int i = 1; i < activityCount; i++) {
            boolean overlapsC = hasOverlap(activities[i], cSchedule);
            boolean overlapsJ = hasOverlap(activities[i], jSchedule);
            if (overlapsC && overlapsJ) return "IMPOSSIBLE";
            if (overlapsC) {
                schedule.append("J");
                jSchedule.add(activities[i]);
            } else {
                schedule.append("C");
                cSchedule.add(activities[i]);
            }
        }

        return schedule.toString();
    }

    private boolean hasOverlap(int[] activity, List<int[]> schedule) {
        for (int[] scheduledActivity : schedule) {
            if (hasOverlap(activity, scheduledActivity)) return true;
        }
        return false;
    }

    private boolean hasOverlap(int[] activity1, int[] activity2) {
        if (activity2[0] < activity1[0]) return hasOverlap(activity2, activity1);
        return activity1[1] > activity2[0];
    }
}