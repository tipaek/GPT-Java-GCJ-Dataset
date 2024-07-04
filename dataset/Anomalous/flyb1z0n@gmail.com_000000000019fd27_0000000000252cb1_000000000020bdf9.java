import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        for (int t = 1; t <= testCaseCount; t++) {
            int activityCount = scanner.nextInt();
            int[][] activities = new int[activityCount][2];
            for (int i = 0; i < activityCount; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
            }
            String result = assignActivities(activities);
            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static String assignActivities(int[][] activities) {
        byte[] cameronSchedule = new byte[1441];
        byte[] jamesSchedule = new byte[1441];
        StringBuilder schedule = new StringBuilder();

        for (int[] activity : activities) {
            if (canAssign(cameronSchedule, activity[0], activity[1])) {
                schedule.append("C");
            } else if (canAssign(jamesSchedule, activity[0], activity[1])) {
                schedule.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }
        return schedule.toString();
    }

    private static boolean canAssign(byte[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i] != 0) {
                return false;
            }
        }
        for (int i = start; i < end; i++) {
            schedule[i] = 1;
        }
        return true;
    }
}