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

            StringBuilder resultBuilder = new StringBuilder();
            for (int j = 0; j < numActivities; j++) {
                if (resultBuilder.toString().equals("IMPOSSIBLE")) {
                    break;
                }
                if (isTimeSlotAvailable(p1, sortedStartTimes[j], sortedEndTimes[j])) {
                    assignTimeSlot(p1, sortedStartTimes[j], sortedEndTimes[j]);
                    resultBuilder.append("C");
                } else if (isTimeSlotAvailable(p2, sortedStartTimes[j], sortedEndTimes[j])) {
                    assignTimeSlot(p2, sortedStartTimes[j], sortedEndTimes[j]);
                    resultBuilder.append("J");
                } else {
                    results[i] = "IMPOSSIBLE";
                    resultBuilder = new StringBuilder("IMPOSSIBLE");
                }
            }

            if (!resultBuilder.toString().equals("IMPOSSIBLE")) {
                char[] finalResult = new char[numActivities];
                for (int j = 0; j < numActivities; j++) {
                    int originalIndex = sortedActivities.get(startTimes[j]);
                    finalResult[originalIndex] = resultBuilder.charAt(j);
                }
                results[i] = new String(finalResult);
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

    private static void assignTimeSlot(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i]++;
        }
    }
}