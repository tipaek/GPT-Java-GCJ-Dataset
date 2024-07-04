import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; ++testCase) {
            StringBuilder jamieSchedule = new StringBuilder("0".repeat(1440));
            StringBuilder cameronSchedule = new StringBuilder("0".repeat(1440));
            int activities = scanner.nextInt();
            StringBuilder result = new StringBuilder();

            for (int activity = 0; activity < activities; activity++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (isAvailable(jamieSchedule, start, end) && !result.toString().equals("IMPOSSIBLE")) {
                    result.append("J");
                    updateSchedule(jamieSchedule, start, end);
                } else if (isAvailable(cameronSchedule, start, end) && !result.toString().equals("IMPOSSIBLE")) {
                    result.append("C");
                    updateSchedule(cameronSchedule, start, end);
                } else if (!result.toString().equals("IMPOSSIBLE")) {
                    result = new StringBuilder("IMPOSSIBLE");
                }
            }

            System.out.println("Case #" + testCase + ": " + result);
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