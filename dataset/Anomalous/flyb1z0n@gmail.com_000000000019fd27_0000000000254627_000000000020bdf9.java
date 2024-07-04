import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCaseCount = sc.nextInt();
            for (int t = 1; t <= testCaseCount; t++) {
                int activityCount = sc.nextInt();
                int[][] activities = new int[activityCount][2];
                for (int i = 0; i < activityCount; i++) {
                    activities[i][0] = sc.nextInt();
                    activities[i][1] = sc.nextInt();
                }
                String result = assignActivities(activities);
                System.out.println("Case #" + t + ": " + result);
            }
        }
    }

    private static String assignActivities(int[][] activities) {
        boolean[] cameronSchedule = new boolean[1441];
        boolean[] jamesSchedule = new boolean[1441];
        StringBuilder schedule = new StringBuilder();

        for (int[] activity : activities) {
            if (tryAssignActivity(cameronSchedule, activity[0], activity[1])) {
                schedule.append("C");
            } else if (tryAssignActivity(jamesSchedule, activity[0], activity[1])) {
                schedule.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }
        return schedule.toString();
    }

    private static boolean tryAssignActivity(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i]) {
                return false;
            }
        }
        for (int i = start; i < end; i++) {
            schedule[i] = true;
        }
        return true;
    }
}