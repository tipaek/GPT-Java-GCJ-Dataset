import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int[] cameronSchedule = new int[24 * 60];
        int[] jamieSchedule = new int[24 * 60];

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int activityCount = scanner.nextInt();
            StringBuilder scheduleBuilder = new StringBuilder();
            boolean isImpossible = false;

            Arrays.fill(cameronSchedule, 24 * 60);
            Arrays.fill(jamieSchedule, 24 * 60);

            for (int i = 0; i < activityCount; i++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();

                if (canScheduleActivity(cameronSchedule, startTime, endTime)) {
                    scheduleActivity(cameronSchedule, startTime, endTime);
                    scheduleBuilder.append("C");
                } else if (canScheduleActivity(jamieSchedule, startTime, endTime)) {
                    scheduleActivity(jamieSchedule, startTime, endTime);
                    scheduleBuilder.append("J");
                } else {
                    isImpossible = true;
                    break;
                }
            }

            String result = isImpossible ? "IMPOSSIBLE" : scheduleBuilder.toString();
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    private static boolean canScheduleActivity(int[] schedule, int startTime, int endTime) {
        return schedule[startTime] >= endTime - startTime;
    }

    private static void scheduleActivity(int[] schedule, int startTime, int endTime) {
        for (int i = startTime; i < endTime; i++) {
            schedule[i] = 0;
        }
        int temp = startTime - 1;
        int buffer = 1;
        while (temp >= 0 && schedule[temp] > 0) {
            schedule[temp] = buffer;
            buffer++;
            temp--;
        }
    }
}