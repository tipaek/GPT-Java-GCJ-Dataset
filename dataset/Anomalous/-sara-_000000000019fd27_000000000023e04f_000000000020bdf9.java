import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            boolean[] jamie = new boolean[1441];
            boolean[] cameron = new boolean[1441];
            int n = scanner.nextInt();
            StringBuilder solution = new StringBuilder();

            boolean possible = true;
            for (int j = 0; j < n; j++) {
                int beginTime = scanner.nextInt();
                int endTime = scanner.nextInt();

                if (isAvailable(jamie, beginTime, endTime)) {
                    markSchedule(jamie, beginTime, endTime);
                    solution.append("J");
                } else if (isAvailable(cameron, beginTime, endTime)) {
                    markSchedule(cameron, beginTime, endTime);
                    solution.append("C");
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                solution = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println("Case #" + i + ": " + solution);
        }

        scanner.close();
    }

    private static boolean isAvailable(boolean[] schedule, int beginTime, int endTime) {
        for (int k = beginTime; k < endTime; k++) {
            if (schedule[k]) {
                return false;
            }
        }
        return true;
    }

    private static void markSchedule(boolean[] schedule, int beginTime, int endTime) {
        for (int k = beginTime; k < endTime; k++) {
            schedule[k] = true;
        }
    }
}