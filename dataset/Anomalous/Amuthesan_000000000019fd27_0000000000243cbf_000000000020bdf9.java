import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int activityCount = scanner.nextInt();
            int[][] cameronSchedule = new int[activityCount][2];
            int[][] jamieSchedule = new int[activityCount][2];
            StringBuilder scheduleBuilder = new StringBuilder();

            for (int activityIndex = 0; activityIndex < activityCount; activityIndex++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();

                if (isAvailable(cameronSchedule, startTime, endTime)) {
                    scheduleBuilder.append('C');
                    assignActivity(cameronSchedule, activityIndex, startTime, endTime);
                } else if (isAvailable(jamieSchedule, startTime, endTime)) {
                    scheduleBuilder.append('J');
                    assignActivity(jamieSchedule, activityIndex, startTime, endTime);
                } else {
                    scheduleBuilder.setLength(0);
                    scheduleBuilder.append("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + scheduleBuilder.toString());
        }
    }

    private static void assignActivity(int[][] schedule, int index, int startTime, int endTime) {
        schedule[index][0] = startTime;
        schedule[index][1] = endTime;
    }

    private static boolean isAvailable(int[][] schedule, int startTime, int endTime) {
        for (int[] activity : schedule) {
            int activityStart = activity[0];
            int activityEnd = activity[1];
            if ((startTime < activityEnd && startTime >= activityStart) ||
                (endTime > activityStart && endTime <= activityEnd)) {
                return false;
            }
        }
        return true;
    }
}