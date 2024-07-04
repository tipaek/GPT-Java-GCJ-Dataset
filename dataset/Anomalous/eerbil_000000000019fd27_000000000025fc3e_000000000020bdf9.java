import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = Integer.parseInt(scanner.nextLine());
        String[] results = new String[numCases];

        for (int i = 0; i < numCases; i++) {
            int[] scheduleC = new int[1440];
            int[] scheduleJ = new int[1440];
            int numActivities = scanner.nextInt();
            int[] startTimes = new int[numActivities];
            int[] endTimes = new int[numActivities];

            for (int j = 0; j < numActivities; j++) {
                startTimes[j] = scanner.nextInt();
                endTimes[j] = scanner.nextInt();
            }

            StringBuilder result = new StringBuilder();
            boolean possible = true;

            for (int j = 0; j < numActivities; j++) {
                if (isAvailable(scheduleC, startTimes[j], endTimes[j])) {
                    fillSchedule(scheduleC, startTimes[j], endTimes[j]);
                    result.append("C");
                } else if (isAvailable(scheduleJ, startTimes[j], endTimes[j])) {
                    fillSchedule(scheduleJ, startTimes[j], endTimes[j]);
                    result.append("J");
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                results[i] = "IMPOSSIBLE";
            } else {
                results[i] = result.toString();
            }
        }

        for (int i = 0; i < numCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }

        scanner.close();
    }

    private static boolean isAvailable(int[] schedule, int start, int end) {
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
        }
    }
}