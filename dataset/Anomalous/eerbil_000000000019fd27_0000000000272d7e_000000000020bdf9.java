import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = Integer.parseInt(scanner.nextLine());
        String[] results = new String[numCases];

        for (int i = 0; i < numCases; i++) {
            int[] person1 = new int[1440];
            int[] person2 = new int[1440];

            int numActivities = scanner.nextInt();
            int[] startTimes = new int[numActivities];
            int[] endTimes = new int[numActivities];
            TreeMap<Integer, Integer> activityMap = new TreeMap<>();

            for (int j = 0; j < numActivities; j++) {
                startTimes[j] = scanner.nextInt();
                endTimes[j] = scanner.nextInt();
                activityMap.put(startTimes[j], j);
            }

            int[] sortedStartTimes = new int[numActivities];
            int[] sortedEndTimes = new int[numActivities];
            int index = 0;

            for (int activityIndex : activityMap.values()) {
                sortedStartTimes[index] = startTimes[activityIndex];
                sortedEndTimes[index] = endTimes[activityIndex];
                index++;
            }

            StringBuilder result = new StringBuilder();
            boolean impossible = false;

            for (int j = 0; j < numActivities; j++) {
                if (isTimeSlotAvailable(person1, sortedStartTimes[j], sortedEndTimes[j])) {
                    markTimeSlot(person1, sortedStartTimes[j], sortedEndTimes[j]);
                    result.append("C");
                } else if (isTimeSlotAvailable(person2, sortedStartTimes[j], sortedEndTimes[j])) {
                    markTimeSlot(person2, sortedStartTimes[j], sortedEndTimes[j]);
                    result.append("J");
                } else {
                    results[i] = "IMPOSSIBLE";
                    impossible = true;
                    break;
                }
            }

            if (!impossible) {
                StringBuilder finalResult = new StringBuilder();
                List<Integer> sortedIndices = new ArrayList<>(activityMap.values());

                for (int j = 0; j < numActivities; j++) {
                    finalResult.append(result.charAt(sortedIndices.indexOf(j)));
                }

                results[i] = finalResult.toString();
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

    private static void markTimeSlot(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i]++;
        }
    }
}