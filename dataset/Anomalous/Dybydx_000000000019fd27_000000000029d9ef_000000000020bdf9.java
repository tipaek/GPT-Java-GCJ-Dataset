import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            int[] scheduleJ = new int[1440];
            int[] scheduleC = new int[1440];
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }

            boolean possible = true;
            for (int i = 0; i < n; i++) {
                if (isAvailable(scheduleJ, startTimes[i], endTimes[i])) {
                    result.append('J');
                    markSchedule(scheduleJ, startTimes[i], endTimes[i]);
                } else if (isAvailable(scheduleC, startTimes[i], endTimes[i])) {
                    result.append('C');
                    markSchedule(scheduleC, startTimes[i], endTimes[i]);
                } else {
                    result.setLength(0);
                    result.append("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + result);
            caseNumber++;
        }

        scanner.close();
    }

    private static boolean isAvailable(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i] == 1) {
                return false;
            }
        }
        return true;
    }

    private static void markSchedule(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i] = 1;
        }
    }
}