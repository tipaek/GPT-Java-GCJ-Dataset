import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int[] cameronSchedule = new int[100];
            int[] jamieSchedule = new int[100];
            int numberOfActivities = scanner.nextInt();
            boolean isImpossible = false;
            StringBuilder schedule = new StringBuilder();

            for (int activity = 0; activity < numberOfActivities; activity++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                boolean assignedToCameron = false;

                if (isAvailable(cameronSchedule, startTime, endTime)) {
                    assignSchedule(cameronSchedule, startTime, endTime);
                    schedule.append("C");
                    assignedToCameron = true;
                } else if (isAvailable(jamieSchedule, startTime, endTime)) {
                    assignSchedule(jamieSchedule, startTime, endTime);
                    schedule.append("J");
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    isImpossible = true;
                    break;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + schedule);
        }
    }

    private static boolean isAvailable(int[] schedule, int start, int end) {
        for (int time = start; time < end; time++) {
            if (schedule[time] == 1) {
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