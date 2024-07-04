import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            int numActivities = scanner.nextInt();
            int[][] cameronSchedule = new int[numActivities][2];
            int[][] jamieSchedule = new int[numActivities][2];
            StringBuilder scheduleBuilder = new StringBuilder();

            for (int activityIndex = 0; activityIndex < numActivities; activityIndex++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();

                if (isTimeSlotAvailable(cameronSchedule, startTime, endTime)) {
                    scheduleBuilder.append('C');
                    assignTimeSlot(cameronSchedule, activityIndex, startTime, endTime);
                } else if (isTimeSlotAvailable(jamieSchedule, startTime, endTime)) {
                    scheduleBuilder.append('J');
                    assignTimeSlot(jamieSchedule, activityIndex, startTime, endTime);
                } else {
                    scheduleBuilder = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + scheduleBuilder.toString());
        }
    }

    private static void assignTimeSlot(int[][] schedule, int index, int startTime, int endTime) {
        schedule[index][0] = startTime;
        schedule[index][1] = endTime;
    }

    private static boolean isTimeSlotAvailable(int[][] schedule, int startTime, int endTime) {
        for (int[] timeSlot : schedule) {
            int slotStart = timeSlot[0];
            int slotEnd = timeSlot[1];

            if (startTime < slotEnd && endTime > slotStart) {
                return false;
            }
        }
        return true;
    }
}