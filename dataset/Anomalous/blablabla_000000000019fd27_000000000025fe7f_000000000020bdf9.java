import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int numSchedules = scanner.nextInt();
            StringBuilder scheduleResult = new StringBuilder();

            boolean[] cameronSchedule = new boolean[24 * 60 + 1];
            boolean[] jamieSchedule = new boolean[24 * 60 + 1];

            for (int i = 0; i < numSchedules; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (isAvailable(cameronSchedule, start, end)) {
                    assignSchedule(cameronSchedule, start, end);
                    scheduleResult.append('C');
                } else if (isAvailable(jamieSchedule, start, end)) {
                    assignSchedule(jamieSchedule, start, end);
                    scheduleResult.append('J');
                } else {
                    scheduleResult = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + scheduleResult);
        }
    }

    private static void assignSchedule(boolean[] schedule, int start, int end) {
        for (int i = start; i <= end; i++) {
            schedule[i] = true;
        }
    }

    private static boolean isAvailable(boolean[] schedule, int start, int end) {
        for (int i = start + 1; i < end; i++) {
            if (schedule[i]) {
                return false;
            }
        }
        return true;
    }
}