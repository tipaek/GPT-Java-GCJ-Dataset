import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
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

            StringBuilder result = new StringBuilder();
            boolean isPossible = true;

            for (int j = 0; j < numActivities && isPossible; j++) {
                if (isTimeSlotAvailable(scheduleJ, startTimes[j], endTimes[j])) {
                    markTimeSlot(scheduleJ, startTimes[j], endTimes[j]);
                    result.append("J");
                } else if (isTimeSlotAvailable(scheduleC, startTimes[j], endTimes[j])) {
                    markTimeSlot(scheduleC, startTimes[j], endTimes[j]);
                    result.append("C");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    isPossible = false;
                }
            }
            results[i] = result.toString();
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

    private static void markTimeSlot(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i]++;
        }
    }
}