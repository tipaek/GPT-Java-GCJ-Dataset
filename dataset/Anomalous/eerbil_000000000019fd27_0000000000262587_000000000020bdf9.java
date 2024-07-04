import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
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

            results[i] = scheduleActivities(numActivities, startTimes, endTimes);
        }

        for (int i = 0; i < numCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }

        scanner.close();
    }

    private static String scheduleActivities(int numActivities, int[] startTimes, int[] endTimes) {
        int[] person1Schedule = new int[24 * 60];
        int[] person2Schedule = new int[24 * 60];
        StringBuilder result = new StringBuilder();

        for (int j = 0; j < numActivities; j++) {
            if (isSlotAvailable(person1Schedule, startTimes[j], endTimes[j])) {
                fillSchedule(person1Schedule, startTimes[j], endTimes[j]);
                result.append("J");
            } else if (isSlotAvailable(person2Schedule, startTimes[j], endTimes[j])) {
                fillSchedule(person2Schedule, startTimes[j], endTimes[j]);
                result.append("C");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return result.toString();
    }

    private static boolean isSlotAvailable(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i] > 0) {
                return false;
            }
        }
        return true;
    }

    private static void fillSchedule(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i]++;
            if (schedule[i] > 1) {
                throw new RuntimeException("Schedule conflict detected");
            }
        }
    }
}