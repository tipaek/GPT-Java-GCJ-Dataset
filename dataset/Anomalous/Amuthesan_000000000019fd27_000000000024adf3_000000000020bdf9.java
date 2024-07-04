import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            int numberOfActivities = scanner.nextInt();
            float[][] cameronSchedule = new float[numberOfActivities][2];
            float[][] jamieSchedule = new float[numberOfActivities][2];
            StringBuilder scheduleBuilder = new StringBuilder();

            for (int j = 0; j < numberOfActivities; j++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();

                if (isAvailable(cameronSchedule, startTime, endTime)) {
                    scheduleBuilder.append('C');
                    assignSchedule(cameronSchedule, j, startTime, endTime);
                } else if (isAvailable(jamieSchedule, startTime, endTime)) {
                    scheduleBuilder.append('J');
                    assignSchedule(jamieSchedule, j, startTime, endTime);
                } else {
                    scheduleBuilder = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + scheduleBuilder.toString());
        }
    }

    private static void assignSchedule(float[][] scheduleArray, int index, int startTime, int endTime) {
        scheduleArray[index][0] = startTime;
        scheduleArray[index][1] = endTime;
    }

    private static boolean isAvailable(float[][] scheduleArray, int startTime, int endTime) {
        for (float[] timeSlot : scheduleArray) {
            float existingStartTime = timeSlot[0];
            float existingEndTime = timeSlot[1];

            if (existingEndTime != 0) {
                if ((startTime < existingEndTime && startTime >= existingStartTime) ||
                    (endTime > existingStartTime && endTime <= existingEndTime) ||
                    (startTime <= existingStartTime && endTime >= existingEndTime) ||
                    (startTime >= existingStartTime && endTime <= existingEndTime)) {
                    return false;
                }
            }
        }
        return true;
    }
}