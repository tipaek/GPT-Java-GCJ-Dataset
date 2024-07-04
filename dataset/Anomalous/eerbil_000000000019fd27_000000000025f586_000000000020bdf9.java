import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = Integer.parseInt(scanner.nextLine());
        String[] results = new String[numCases];

        for (int i = 0; i < numCases; i++) {
            int[] scheduleC = new int[1440];
            int[] scheduleJ = new int[1440];
            int numActivities = scanner.nextInt();
            int[] startTimes = new int[numActivities];
            int[] endTimes = new int[numActivities];

            for (int j = 0; j < numActivities; j++) {
                startTimes[j] = scanner.nextInt();
                endTimes[j] = scanner.nextInt();
            }

            StringBuilder result = new StringBuilder();
            boolean possible = true;

            for (int j = 0; j < numActivities && possible; j++) {
                if (isSlotAvailable(scheduleC, startTimes[j], endTimes[j])) {
                    fillSlot(scheduleC, startTimes[j], endTimes[j]);
                    result.append("C");
                } else if (isSlotAvailable(scheduleJ, startTimes[j], endTimes[j])) {
                    fillSlot(scheduleJ, startTimes[j], endTimes[j]);
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    possible = false;
                }
            }

            results[i] = result.toString();
        }

        for (int i = 0; i < numCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }

        scanner.close();
    }

    private static boolean isSlotAvailable(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i] > 0) {
                return false;
            }
        }
        return true;
    }

    private static void fillSlot(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i]++;
        }
    }
}