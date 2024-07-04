import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
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

            System.out.println("Case #" + caseNum + ": " + result);
        }

        scanner.close();
    }

    private static boolean isAvailable(StringBuilder schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule.charAt(i) == '1') {
                return false;
            }
        }
        return true;
    }

    private static void updateSchedule(StringBuilder schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule.setCharAt(i, '1');
        }
    }
}