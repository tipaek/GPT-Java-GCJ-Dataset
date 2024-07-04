import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = Integer.parseInt(scanner.nextLine());
        String[] results = new String[numCases];

        for (int i = 0; i < numCases; i++) {
            results[i] = "";
            int[] scheduleC = new int[1440];
            int[] scheduleJ = new int[1440];
            int numActivities = scanner.nextInt();
            int[] startTimes = new int[numActivities];
            int[] endTimes = new int[numActivities];

            for (int j = 0; j < numActivities; j++) {
                startTimes[j] = scanner.nextInt();
                endTimes[j] = scanner.nextInt();
            }

            for (int j = 0; j < numActivities; j++) {
                if (isTimeSlotAvailable(scheduleC, startTimes[j], endTimes[j])) {
                    updateSchedule(scheduleC, startTimes[j], endTimes[j]);
                    results[i] += "C";
                } else if (isTimeSlotAvailable(scheduleJ, startTimes[j], endTimes[j])) {
                    updateSchedule(scheduleJ, startTimes[j], endTimes[j]);
                    results[i] += "J";
                } else {
                    results[i] = "IMPOSSIBLE";
                    break;
                }
            }
        }

        for (int i = 0; i < numCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }

        scanner.close();
    }

    private static boolean isTimeSlotAvailable(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i] > 0) {
                return false;
            }
        }
        return true;
    }

    private static void updateSchedule(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i] = 1;
        }
    }
}