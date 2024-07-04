package codejam2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = Integer.parseInt(scanner.nextLine());
        String[] results = new String[numCases];

        for (int i = 0; i < numCases; i++) {
            int numActivities = scanner.nextInt();
            int[] startTimes = new int[numActivities];
            int[] endTimes = new int[numActivities];

            for (int j = 0; j < numActivities; j++) {
                startTimes[j] = scanner.nextInt();
                endTimes[j] = scanner.nextInt();
            }

            results[i] = assignActivities(numActivities, startTimes, endTimes);
        }

        for (int i = 0; i < numCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }

        scanner.close();
    }

    private static String assignActivities(int numActivities, int[] startTimes, int[] endTimes) {
        int[] cameronSchedule = new int[1440];
        int[] jamieSchedule = new int[1440];
        StringBuilder schedule = new StringBuilder();

        for (int j = 0; j < numActivities; j++) {
            if (isTimeSlotAvailable(cameronSchedule, startTimes[j], endTimes[j])) {
                updateSchedule(cameronSchedule, startTimes[j], endTimes[j]);
                schedule.append("C");
            } else if (isTimeSlotAvailable(jamieSchedule, startTimes[j], endTimes[j])) {
                updateSchedule(jamieSchedule, startTimes[j], endTimes[j]);
                schedule.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }
        return schedule.toString();
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
            schedule[i] = 1;
        }
    }
}