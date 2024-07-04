import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
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
            TreeMap<Integer, Integer> sortedActivities = new TreeMap<>();

            for (int j = 0; j < numActivities; j++) {
                startTimes[j] = scanner.nextInt();
                endTimes[j] = scanner.nextInt();
                sortedActivities.put(startTimes[j], j);
            }

            int[] sortedStartTimes = new int[numActivities];
            int[] sortedEndTimes = new int[numActivities];
            int index = 0;

            for (int activityIndex : sortedActivities.values()) {
                sortedStartTimes[index] = startTimes[activityIndex];
                sortedEndTimes[index] = endTimes[activityIndex];
                index++;
            }

            StringBuilder result = new StringBuilder();
            for (int j = 0; j < numActivities; j++) {
                if (result.toString().equals("IMPOSSIBLE")) {
                    break;
                }
                if (isSlotAvailable(scheduleC, sortedStartTimes[j], sortedEndTimes[j])) {
                    markSlot(scheduleC, sortedStartTimes[j], sortedEndTimes[j]);
                    result.append("C");
                } else if (isSlotAvailable(scheduleJ, sortedStartTimes[j], sortedEndTimes[j])) {
                    markSlot(scheduleJ, sortedStartTimes[j], sortedEndTimes[j]);
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            if (!result.toString().equals("IMPOSSIBLE")) {
                StringBuilder finalResult = new StringBuilder();
                for (int j = 0; j < numActivities; j++) {
                    finalResult.append(result.charAt(sortedActivities.values().toArray(new Integer[0])[j]));
                }
                results[i] = finalResult.toString();
            } else {
                results[i] = "IMPOSSIBLE";
            }
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

    private static void markSlot(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i]++;
        }
    }
}