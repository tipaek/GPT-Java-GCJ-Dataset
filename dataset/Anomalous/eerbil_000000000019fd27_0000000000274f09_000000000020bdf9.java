import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
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
            boolean isPossible = true;
            for (int j = 0; j < numActivities && isPossible; j++) {
                if (isEmpty(p1, sortedStartTimes[j], sortedEndTimes[j])) {
                    markBusy(p1, sortedStartTimes[j], sortedEndTimes[j]);
                    result.append("C");
                } else if (isEmpty(p2, sortedStartTimes[j], sortedEndTimes[j])) {
                    markBusy(p2, sortedStartTimes[j], sortedEndTimes[j]);
                    result.append("J");
                } else {
                    results[i] = "IMPOSSIBLE";
                    isPossible = false;
                }
            }

            if (isPossible) {
                List<Integer> activityOrder = new ArrayList<>(sortedActivities.values());
                StringBuilder finalResult = new StringBuilder();
                for (int j = 0; j < numActivities; j++) {
                    finalResult.append(result.charAt(activityOrder.indexOf(j)));
                }
                results[i] = finalResult.toString();
            }
        }

        for (int i = 0; i < numCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }
        scanner.close();
    }

    private static boolean isEmpty(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i] > 0) {
                return false;
            }
        }
        return true;
    }

    private static void markBusy(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i]++;
        }
    }
}