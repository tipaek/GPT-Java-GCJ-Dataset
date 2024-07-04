import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            if (!scanner.hasNext()) {
                return;
            }
            int scheduleCount = Integer.parseInt(scanner.nextLine());

            int[] cameronSchedule = new int[24 * 60];
            int[] jamieSchedule = new int[24 * 60];
            StringBuilder result = new StringBuilder();

            for (int j = 0; j < scheduleCount; j++) {
                if (!scanner.hasNext()) {
                    return;
                }
                String[] timeInterval = scanner.nextLine().trim().split(" ");
                if (timeInterval.length < 2) {
                    return;
                }

                int startTime = Integer.parseInt(timeInterval[0]);
                int endTime = Integer.parseInt(timeInterval[1]);

                if (startTime > endTime) {
                    int temp = endTime;
                    endTime = startTime;
                    startTime = temp;
                }

                if (isTimeSlotFree(cameronSchedule, startTime, endTime)) {
                    occupyTimeSlot(cameronSchedule, startTime, endTime);
                    result.append("C");
                } else if (isTimeSlotFree(jamieSchedule, startTime, endTime)) {
                    occupyTimeSlot(jamieSchedule, startTime, endTime);
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    private static boolean isTimeSlotFree(int[] schedule, int start, int end) {
        if (end > schedule.length) {
            return false;
        }
        for (int i = start; i < end; i++) {
            if (schedule[i] != 0) {
                return false;
            }
        }
        return true;
    }

    private static void occupyTimeSlot(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i] = 1;
        }
    }
}