import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseCount = scanner.nextInt();
        for (int caseIndex = 1; caseIndex <= caseCount; caseIndex++) {
            System.out.printf("Case #%d: %s%n", caseIndex, new Solution().solve(scanner));
        }
    }

    public String solve(Scanner scanner) {
        int activityCount = scanner.nextInt();
        int[][] activities = new int[activityCount][2];
        for (int i = 0; i < activityCount; i++) {
            activities[i][0] = scanner.nextInt();
            activities[i][1] = scanner.nextInt();
        }

        List<Integer> cActivities = new ArrayList<>();
        List<Integer> jActivities = new ArrayList<>();

        StringBuilder schedule = new StringBuilder("C");
        cActivities.add(0);

        for (int i = 1; i < activityCount; i++) {
            if (!hasOverlap(activities[i], cActivities, activities)) {
                schedule.append("C");
                cActivities.add(i);
            } else if (!hasOverlap(activities[i], jActivities, activities)) {
                schedule.append("J");
                jActivities.add(i);
            } else {
                return "IMPOSSIBLE";
            }
        }

        return schedule.toString();
    }

    private boolean hasOverlap(int[] currentActivity, List<Integer> assignedActivities, int[][] allActivities) {
        for (int index : assignedActivities) {
            if (isOverlap(currentActivity, allActivities[index])) {
                return true;
            }
        }
        return false;
    }

    private boolean isOverlap(int[] activity1, int[] activity2) {
        return activity1[0] < activity2[1] && activity2[0] < activity1[1];
    }
}