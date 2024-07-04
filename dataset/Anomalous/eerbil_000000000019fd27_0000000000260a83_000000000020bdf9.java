import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = Integer.parseInt(scanner.nextLine());
        String[] results = new String[numCases];

        for (int i = 0; i < numCases; i++) {
            int[] scheduleJ = new int[24 * 60];
            int[] scheduleC = new int[24 * 60];
            int numActivities = scanner.nextInt();
            int[] startTimes = new int[numActivities];
            int[] endTimes = new int[numActivities];

            for (int j = 0; j < numActivities; j++) {
                startTimes[j] = scanner.nextInt();
                endTimes[j] = scanner.nextInt();
            }

            StringBuilder resultBuilder = new StringBuilder();
            for (int j = 0; j < numActivities; j++) {
                if (!resultBuilder.toString().equals("IMPOSSIBLE")) {
                    if (isTimeSlotAvailable(scheduleJ, startTimes[j], endTimes[j])) {
                        updateSchedule(scheduleJ, startTimes[j], endTimes[j]);
                        resultBuilder.append("J");
                    } else if (isTimeSlotAvailable(scheduleC, startTimes[j], endTimes[j])) {
                        updateSchedule(scheduleC, startTimes[j], endTimes[j]);
                        resultBuilder.append("C");
                    } else {
                        resultBuilder = new StringBuilder("IMPOSSIBLE");
                    }
                }
            }
            results[i] = resultBuilder.toString();
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
            schedule[i]++;
        }
    }
}