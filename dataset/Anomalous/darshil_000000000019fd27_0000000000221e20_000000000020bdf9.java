import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            boolean[] cameronSchedule = new boolean[1441];
            boolean[] jamieSchedule = new boolean[1441];
            int n = scanner.nextInt();
            StringBuilder schedule = new StringBuilder();
            boolean isPossible = true;

            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (j == 0) {
                    assignSchedule(cameronSchedule, start, end);
                    schedule.append('C');
                } else {
                    if (isAvailable(cameronSchedule, start, end)) {
                        assignSchedule(cameronSchedule, start, end);
                        schedule.append('C');
                    } else if (isAvailable(jamieSchedule, start, end)) {
                        assignSchedule(jamieSchedule, start, end);
                        schedule.append('J');
                    } else {
                        isPossible = false;
                        break;
                    }
                }
            }

            if (isPossible) {
                System.out.println("Case #" + (i + 1) + ": " + schedule);
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
    }

    private static void assignSchedule(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i] = true;
        }
    }

    private static boolean isAvailable(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i]) {
                return false;
            }
        }
        return true;
    }
}