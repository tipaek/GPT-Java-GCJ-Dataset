import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = Integer.parseInt(in.nextLine());
        String[] results = new String[numCases];
        
        for (int i = 0; i < numCases; i++) {
            int[] scheduleC = new int[1440];
            int[] scheduleJ = new int[1440];
            
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
            
            StringBuilder assignment = new StringBuilder();
            boolean possible = true;
            
            for (int j = 0; j < numActivities && possible; j++) {
                if (isTimeSlotAvailable(scheduleC, sortedStartTimes[j], sortedEndTimes[j])) {
                    updateSchedule(scheduleC, sortedStartTimes[j], sortedEndTimes[j]);
                    assignment.append("C");
                } else if (isTimeSlotAvailable(scheduleJ, sortedStartTimes[j], sortedEndTimes[j])) {
                    updateSchedule(scheduleJ, sortedStartTimes[j], sortedEndTimes[j]);
                    assignment.append("J");
                } else {
                    possible = false;
                    assignment.setLength(0);
                    assignment.append("IMPOSSIBLE");
                }
            }
            
            if (possible) {
                char[] finalAssignment = new char[numActivities];
                for (int j = 0; j < numActivities; j++) {
                    finalAssignment[sortedActivities.get(startTimes[j])] = assignment.charAt(j);
                }
                results[i] = new String(finalAssignment);
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

    private static void updateSchedule(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i]++;
        }
    }
}