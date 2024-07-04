import java.util.Scanner;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int[] cameronSchedule = new int[1440];
            int[] jamieSchedule = new int[1440];
            int numberOfActivities = scanner.nextInt();
            boolean isImpossible = false;
            StringBuilder schedule = new StringBuilder();

            for (int activityIndex = 0; activityIndex < numberOfActivities; activityIndex++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                boolean assignedToCameron = false;

                if (isScheduleAvailable(cameronSchedule, start, end)) {
                    assignSchedule(cameronSchedule, start, end);
                    schedule.append("C");
                    assignedToCameron = true;
                }

                if (!assignedToCameron) {
                    if (isScheduleAvailable(jamieSchedule, start, end)) {
                        assignSchedule(jamieSchedule, start, end);
                        schedule.append("J");
                    } else {
                        schedule = new StringBuilder("IMPOSSIBLE");
                        isImpossible = true;
                        break;
                    }
                }
            }

            System.out.println("Case #" + caseNumber + ": " + schedule.toString());
        }
    }

    private static boolean isScheduleAvailable(int[] schedule, int start, int end) {
        for (int time = start; time < end; time++) {
            if (schedule[time] != 0) {
                return false;
            }
        }
        return true;
    }

    private static void assignSchedule(int[] schedule, int start, int end) {
        for (int time = start; time < end; time++) {
            schedule[time] = 1;
        }
    }
}