import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int[] cameronSchedule = new int[1500];
            int[] jamieSchedule = new int[1500];
            int numberOfActivities = scanner.nextInt();
            boolean isImpossible = false;
            StringBuilder result = new StringBuilder();

            for (int activityIndex = 0; activityIndex < numberOfActivities; activityIndex++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                boolean assignedToCameron = false;

                if (isScheduleAvailable(cameronSchedule, startTime, endTime)) {
                    assignSchedule(cameronSchedule, startTime, endTime);
                    result.append("C");
                    assignedToCameron = true;
                } 

                if (!assignedToCameron && isScheduleAvailable(jamieSchedule, startTime, endTime)) {
                    assignSchedule(jamieSchedule, startTime, endTime);
                    result.append("J");
                } else if (!assignedToCameron) {
                    result = new StringBuilder("IMPOSSIBLE");
                    isImpossible = true;
                    break;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    private static boolean isScheduleAvailable(int[] schedule, int startTime, int endTime) {
        for (int time = startTime; time < endTime; time++) {
            if (schedule[time] == 1) {
                return false;
            }
        }
        return true;
    }

    private static void assignSchedule(int[] schedule, int startTime, int endTime) {
        for (int time = startTime; time < endTime; time++) {
            schedule[time] = 1;
        }
    }
}