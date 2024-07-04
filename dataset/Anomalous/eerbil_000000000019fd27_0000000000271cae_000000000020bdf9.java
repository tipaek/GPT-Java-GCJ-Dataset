import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = Integer.parseInt(in.nextLine());
        String[] results = new String[numCases];

        for (int i = 0; i < numCases; i++) {
            int[] cameronSchedule = new int[1440];
            int[] jamieSchedule = new int[1440];

            int numActivities = in.nextInt();
            int[] startTimes = new int[numActivities];
            int[] endTimes = new int[numActivities];
            TreeMap<Integer, Integer> sortedActivities = new TreeMap<>();

            for (int j = 0; j < numActivities; j++) {
                startTimes[j] = in.nextInt();
                endTimes[j] = in.nextInt();
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
            boolean isPossible = true;

            for (int j = 0; j < numActivities && isPossible; j++) {
                if (isSlotAvailable(cameronSchedule, sortedStartTimes[j], sortedEndTimes[j])) {
                    markSlot(cameronSchedule, sortedStartTimes[j], sortedEndTimes[j]);
                    result.append("C");
                } else if (isSlotAvailable(jamieSchedule, sortedStartTimes[j], sortedEndTimes[j])) {
                    markSlot(jamieSchedule, sortedStartTimes[j], sortedEndTimes[j]);
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    isPossible = false;
                }
            }

            if (isPossible) {
                char[] finalResult = new char[numActivities];
                for (int j = 0; j < numActivities; j++) {
                    finalResult[sortedActivities.get(startTimes[j])] = result.charAt(j);
                }
                results[i] = new String(finalResult);
            } else {
                results[i] = "IMPOSSIBLE";
            }
        }

        for (int i = 0; i < numCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }

        in.close();
    }

    public static boolean isSlotAvailable(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i] > 0) {
                return false;
            }
        }
        return true;
    }

    public static void markSlot(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i]++;
        }
    }
}