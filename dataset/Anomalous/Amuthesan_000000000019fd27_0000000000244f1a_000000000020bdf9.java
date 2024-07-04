import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int numActivities = scanner.nextInt();
            int[][] cameronSchedule = new int[numActivities][2];
            int[][] jamieSchedule = new int[numActivities][2];
            StringBuilder schedule = new StringBuilder();

            for (int i = 0; i < numActivities; i++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();

                if (isTimeSlotAvailable(cameronSchedule, startTime, endTime)) {
                    schedule.append('C');
                    assignTimeSlot(cameronSchedule, i, startTime, endTime);
                } else if (isTimeSlotAvailable(jamieSchedule, startTime, endTime)) {
                    schedule.append('J');
                    assignTimeSlot(jamieSchedule, i, startTime, endTime);
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + t + ": " + schedule);
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

            if ((startTime < slotEnd && startTime >= slotStart) ||
                (endTime > slotStart && endTime <= slotEnd) ||
                (startTime <= slotStart && endTime >= slotEnd) ||
                (startTime >= slotStart && endTime <= slotEnd)) {
                return false;
            }
        }
        return true;
    }
}