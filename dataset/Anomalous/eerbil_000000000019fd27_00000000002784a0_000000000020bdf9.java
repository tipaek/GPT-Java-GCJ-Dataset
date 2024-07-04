import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
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
                if (!resultBuilder.toString().equals("IMPOSSIBLE")) {
                    if (isSlotAvailable(person1, sortedStartTimes[j], sortedEndTimes[j])) {
                        occupySlot(person1, sortedStartTimes[j], sortedEndTimes[j]);
                        resultBuilder.append("C");
                    } else if (isSlotAvailable(person2, sortedStartTimes[j], sortedEndTimes[j])) {
                        occupySlot(person2, sortedStartTimes[j], sortedEndTimes[j]);
                        resultBuilder.append("J");
                    } else {
                        results[i] = "IMPOSSIBLE";
                        resultBuilder = new StringBuilder("IMPOSSIBLE");
                    }
                }
            }

            List<Integer> originalOrder = new ArrayList<>(sortedActivities.values());
            StringBuilder finalResult = new StringBuilder();

            if (!resultBuilder.toString().equals("IMPOSSIBLE")) {
                for (int j = 0; j < numActivities; j++) {
                    int position = originalOrder.indexOf(j);
                    if (position != -1) {
                        finalResult.append(resultBuilder.charAt(position));
                    } else {
                        finalResult.append("C");
                    }
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

    private static void occupySlot(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i]++;
        }
    }
}