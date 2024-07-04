import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = Integer.parseInt(in.nextLine());
        String[] results = new String[numCases];

        for (int i = 0; i < numCases; i++) {
            int[] person1 = new int[1440];
            int[] person2 = new int[1440];

            int numActivities = in.nextInt();
            int[] startTimes = new int[numActivities];
            int[] endTimes = new int[numActivities];
            TreeMap<Integer, Integer> activityMap = new TreeMap<>();

            for (int j = 0; j < numActivities; j++) {
                startTimes[j] = in.nextInt();
                endTimes[j] = in.nextInt();
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

            StringBuilder resultBuilder = new StringBuilder();
            for (int j = 0; j < numActivities; j++) {
                if (!resultBuilder.toString().equals("IMPOSSIBLE")) {
                    if (isTimeSlotAvailable(person1, sortedStartTimes[j], sortedEndTimes[j])) {
                        markTimeSlot(person1, sortedStartTimes[j], sortedEndTimes[j]);
                        resultBuilder.append("C");
                    } else if (isTimeSlotAvailable(person2, sortedStartTimes[j], sortedEndTimes[j])) {
                        markTimeSlot(person2, sortedStartTimes[j], sortedEndTimes[j]);
                        resultBuilder.append("J");
                    } else {
                        resultBuilder.setLength(0);
                        resultBuilder.append("IMPOSSIBLE");
                    }
                }
            }

            if (!resultBuilder.toString().equals("IMPOSSIBLE")) {
                StringBuilder finalResult = new StringBuilder();
                List<Integer> originalOrder = new ArrayList<>(activityMap.values());

                for (int j = 0; j < numActivities; j++) {
                    finalResult.append(resultBuilder.charAt(originalOrder.indexOf(j)));
                }

                results[i] = finalResult.toString();
            } else {
                results[i] = "IMPOSSIBLE";
            }
        }

        for (int i = 0; i < numCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }

        in.close();
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