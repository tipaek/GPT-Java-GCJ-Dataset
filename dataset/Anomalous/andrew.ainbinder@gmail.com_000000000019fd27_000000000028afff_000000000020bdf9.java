import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            short[] cameronSchedule = new short[1500];
            short[] jamieSchedule = new short[1500];
            int numberOfActivities = scanner.nextInt();
            boolean isPossible = true;
            StringBuilder result = new StringBuilder();

            for (int activityIndex = 0; activityIndex < numberOfActivities; activityIndex++) {
                short startTime = scanner.nextShort();
                short endTime = scanner.nextShort();
                boolean scheduled = false;

                if (isAvailable(cameronSchedule, startTime, endTime)) {
                    scheduleActivity(cameronSchedule, startTime, endTime);
                    result.append("C");
                    scheduled = true;
                } else if (isAvailable(jamieSchedule, startTime, endTime)) {
                    scheduleActivity(jamieSchedule, startTime, endTime);
                    result.append("J");
                    scheduled = true;
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }
    }

    private static boolean isAvailable(short[] schedule, short start, short end) {
        for (int time = start; time < end; time++) {
            if (schedule[time] == 1) {
                return false;
            }
        }
        return true;
    }

    private static void scheduleActivity(short[] schedule, short start, short end) {
        for (int time = start; time < end; time++) {
            schedule[time] = 1;
        }
    }
}