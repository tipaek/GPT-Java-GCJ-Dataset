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

            int numSchedules = Integer.parseInt(scanner.nextLine());
            int[] scheduleC = new int[60 * 24];
            int[] scheduleJ = new int[60 * 24];
            StringBuilder result = new StringBuilder();

            for (int j = 0; j < numSchedules; j++) {
                if (!scanner.hasNext()) {
                    return;
                }

                String[] scheduleTimes = scanner.nextLine().trim().split(" ");
                if (scheduleTimes.length < 2) {
                    return;
                }

                int startTime = Integer.parseInt(scheduleTimes[0]);
                int endTime = Integer.parseInt(scheduleTimes[1]);

                if (isTimeSlotFree(scheduleC, startTime, endTime)) {
                    fillTimeSlot(scheduleC, startTime, endTime);
                    result.append("C");
                } else if (isTimeSlotFree(scheduleJ, startTime, endTime)) {
                    fillTimeSlot(scheduleJ, startTime, endTime);
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

    private static void fillTimeSlot(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i] = 1;
        }
    }
}