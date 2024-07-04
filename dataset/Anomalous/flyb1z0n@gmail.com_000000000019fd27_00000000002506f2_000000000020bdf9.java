import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCaseCount = scanner.nextInt();
            for (int t = 1; t <= testCaseCount; t++) {
                int activityCount = scanner.nextInt();
                int[][] activities = new int[activityCount][2];
                for (int i = 0; i < activityCount; i++) {
                    activities[i][0] = scanner.nextInt();
                    activities[i][1] = scanner.nextInt();
                }
                String result = scheduleActivities(activities);
                System.out.println("Case #" + t + ": " + result);
            }
        }
    }

    private static String scheduleActivities(int[][] activities) {
        byte[] cameronSchedule = new byte[1441];
        byte[] jamesSchedule = new byte[1441];
        StringBuilder schedule = new StringBuilder();
        
        for (int[] activity : activities) {
            if (assignActivity(cameronSchedule, activity[0], activity[1])) {
                schedule.append("C");
            } else if (assignActivity(jamesSchedule, activity[0], activity[1])) {
                schedule.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }
        return schedule.toString();
    }

    private static boolean assignActivity(byte[] schedule, int start, int end) {
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