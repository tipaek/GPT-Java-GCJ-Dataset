import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = Integer.parseInt(in.nextLine());
        String[] results = new String[numCases];

        for (int i = 0; i < numCases; i++) {
            int numActivities = in.nextInt();
            int[] start = new int[numActivities];
            int[] end = new int[numActivities];
            TreeMap<Integer, Integer> sortedActivities = new TreeMap<>();

            for (int j = 0; j < numActivities; j++) {
                start[j] = in.nextInt();
                end[j] = in.nextInt();
                sortedActivities.put(start[j], j);
            }

            int[] sortedStart = new int[numActivities];
            int[] sortedEnd = new int[numActivities];
            int index = 0;

            for (int activityIndex : sortedActivities.values()) {
                sortedStart[index] = start[activityIndex];
                sortedEnd[index] = end[activityIndex];
                index++;
            }

            int[] scheduleC = new int[1440];
            int[] scheduleJ = new int[1440];
            StringBuilder assignment = new StringBuilder();

            for (int j = 0; j < numActivities; j++) {
                if (isTimeSlotAvailable(scheduleC, sortedStart[j], sortedEnd[j])) {
                    markTimeSlot(scheduleC, sortedStart[j], sortedEnd[j]);
                    assignment.append("C");
                } else if (isTimeSlotAvailable(scheduleJ, sortedStart[j], sortedEnd[j])) {
                    markTimeSlot(scheduleJ, sortedStart[j], sortedEnd[j]);
                    assignment.append("J");
                } else {
                    assignment.setLength(0);
                    assignment.append("IMPOSSIBLE");
                    break;
                }
            }

            if (!"IMPOSSIBLE".equals(assignment.toString())) {
                StringBuilder finalAssignment = new StringBuilder();
                for (int j = 0; j < numActivities; j++) {
                    finalAssignment.append(assignment.charAt(sortedActivities.get(start[j])));
                }
                results[i] = finalAssignment.toString();
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