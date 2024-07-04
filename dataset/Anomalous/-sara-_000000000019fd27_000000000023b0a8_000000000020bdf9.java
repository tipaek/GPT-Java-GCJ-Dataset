import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            StringBuilder jamie = new StringBuilder("0".repeat(1441));
            StringBuilder cameron = new StringBuilder("0".repeat(1441));
            int n = scanner.nextInt();
            StringBuilder solution = new StringBuilder();

            boolean isPossible = true;

            for (int j = 0; j < n; j++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();

                if (isPossible) {
                    if (isAvailable(jamie, startTime, endTime)) {
                        solution.append("J");
                        updateSchedule(jamie, startTime, endTime);
                    } else if (isAvailable(cameron, startTime, endTime)) {
                        solution.append("C");
                        updateSchedule(cameron, startTime, endTime);
                    } else {
                        solution = new StringBuilder("IMPOSSIBLE");
                        isPossible = false;
                    }
                }
            }

            System.out.println("Case #" + t + ": " + solution);
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