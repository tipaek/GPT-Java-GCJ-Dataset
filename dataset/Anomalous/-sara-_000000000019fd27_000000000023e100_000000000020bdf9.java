import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            StringBuilder jamieSchedule = new StringBuilder("0".repeat(1441));
            StringBuilder cameronSchedule = new StringBuilder("0".repeat(1441));
            int activities = scanner.nextInt();
            StringBuilder result = new StringBuilder();

            for (int activity = 0; activity < activities; activity++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();

                if (isAvailable(jamieSchedule, startTime, endTime)) {
                    result.append("J");
                    updateSchedule(jamieSchedule, startTime, endTime);
                } else if (isAvailable(cameronSchedule, startTime, endTime)) {
                    result.append("C");
                    updateSchedule(cameronSchedule, startTime, endTime);
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            System.out.println("Case #" + caseNumber + ": " + result);
        }
        scanner.close();
    }

    private static boolean isAvailable(StringBuilder schedule, int startTime, int endTime) {
        for (int i = startTime; i < endTime; i++) {
            if (schedule.charAt(i) == '1') {
                return false;
            }
        }
        return true;
    }

    private static void updateSchedule(StringBuilder schedule, int startTime, int endTime) {
        for (int i = startTime; i < endTime; i++) {
            schedule.setCharAt(i, '1');
        }
    }
}