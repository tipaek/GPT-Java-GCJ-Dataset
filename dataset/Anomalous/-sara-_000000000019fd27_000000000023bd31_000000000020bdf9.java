import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            boolean[] jamieSchedule = new boolean[1441];
            boolean[] cameronSchedule = new boolean[1441];
            int activities = scanner.nextInt();
            StringBuilder result = new StringBuilder();

            for (int j = 0; j < activities; j++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                boolean assigned = false;

                if (isAvailable(jamieSchedule, startTime, endTime)) {
                    assignSchedule(jamieSchedule, startTime, endTime);
                    result.append("J");
                    assigned = true;
                } else if (isAvailable(cameronSchedule, startTime, endTime)) {
                    assignSchedule(cameronSchedule, startTime, endTime);
                    result.append("C");
                    assigned = true;
                }

                if (!assigned) {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + result);
        }

        scanner.close();
    }

    private static boolean isAvailable(boolean[] schedule, int startTime, int endTime) {
        for (int k = startTime; k < endTime; k++) {
            if (schedule[k]) {
                return false;
            }
        }
        return true;
    }

    private static void assignSchedule(boolean[] schedule, int startTime, int endTime) {
        for (int k = startTime; k < endTime; k++) {
            schedule[k] = true;
        }
    }
}