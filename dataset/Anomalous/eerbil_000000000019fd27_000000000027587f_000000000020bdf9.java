import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

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

            StringBuilder resultBuilder = new StringBuilder();
            boolean isPossible = true;

            for (int j = 0; j < numActivities && isPossible; j++) {
                if (isSlotAvailable(scheduleC, sortedStartTimes[j], sortedEndTimes[j])) {
                    fillSlot(scheduleC, sortedStartTimes[j], sortedEndTimes[j]);
                    resultBuilder.append("C");
                } else if (isSlotAvailable(scheduleJ, sortedStartTimes[j], sortedEndTimes[j])) {
                    fillSlot(scheduleJ, sortedStartTimes[j], sortedEndTimes[j]);
                    resultBuilder.append("J");
                } else {
                    results[i] = "IMPOSSIBLE";
                    isPossible = false;
                }
            }

            if (isPossible) {
                ArrayList<Integer> originalOrder = new ArrayList<>(sortedActivities.values());
                StringBuilder finalResult = new StringBuilder();

                for (int j = 0; j < numActivities; j++) {
                    finalResult.append(resultBuilder.charAt(originalOrder.indexOf(j)));
                }

                results[i] = finalResult.toString();
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

    private static void fillSlot(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i]++;
        }
    }
}