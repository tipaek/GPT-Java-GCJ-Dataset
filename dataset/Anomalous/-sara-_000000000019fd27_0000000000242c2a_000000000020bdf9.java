import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            boolean[] jamie = new boolean[1440];
            boolean[] cameron = new boolean[1440];
            int activities = scanner.nextInt();
            StringBuilder schedule = new StringBuilder();

            boolean possible = true;

            for (int i = 0; i < activities; i++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();

                if (isAvailable(jamie, startTime, endTime)) {
                    markTime(jamie, startTime, endTime);
                    schedule.append('J');
                } else if (isAvailable(cameron, startTime, endTime)) {
                    markTime(cameron, startTime, endTime);
                    schedule.append('C');
                } else {
                    schedule.setLength(0); // Clear the schedule
                    schedule.append("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            System.out.println("Case #" + t + ": " + schedule.toString());
        }

        scanner.close();
    }

    private static boolean isAvailable(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i]) {
                return false;
            }
        }
        return true;
    }

    private static void markTime(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i] = true;
        }
    }
}