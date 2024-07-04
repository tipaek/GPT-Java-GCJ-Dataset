import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = Integer.parseInt(scanner.nextLine());
        String[] results = new String[numCases];

        for (int i = 0; i < numCases; i++) {
            int[] p1 = new int[1440];
            int[] p2 = new int[1440];

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
                if (!result.toString().equals("IMPOSSIBLE")) {
                    if (isTimeSlotEmpty(p1, sortedStartTimes[j], sortedEndTimes[j])) {
                        fillTimeSlot(p1, sortedStartTimes[j], sortedEndTimes[j]);
                        result.append("C");
                    } else if (isTimeSlotEmpty(p2, sortedStartTimes[j], sortedEndTimes[j])) {
                        fillTimeSlot(p2, sortedStartTimes[j], sortedEndTimes[j]);
                        result.append("J");
                    } else {
                        results[i] = "IMPOSSIBLE";
                        result = new StringBuilder("IMPOSSIBLE");
                    }
                }
            }

            if (!result.toString().equals("IMPOSSIBLE")) {
                StringBuilder finalResult = new StringBuilder();
                for (int j = 0; j < numActivities; j++) {
                    int originalIndex = sortedActivities.get(startTimes[j]);
                    finalResult.append(result.charAt(originalIndex));
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

    public static boolean isTimeSlotEmpty(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i] > 0) {
                return false;
            }
        }
        return true;
    }

    public static void fillTimeSlot(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i]++;
        }
    }
}