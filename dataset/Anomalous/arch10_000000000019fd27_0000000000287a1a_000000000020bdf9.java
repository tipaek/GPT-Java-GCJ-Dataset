import java.util.Scanner;

public class TaskScheduler {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] tasks = new int[n][2];

            for (int i = 0; i < n; i++) {
                tasks[i][0] = scanner.nextInt();
                tasks[i][1] = scanner.nextInt();
            }

            System.out.println("Case #" + (t + 1) + ": " + getSchedule(tasks, n));
        }
    }

    private static String getSchedule(int[][] tasks, int n) {
        StringBuilder schedule = new StringBuilder();
        int[] jamie = new int[1441];
        int[] cameron = new int[1441];

        for (int i = 0; i < n; i++) {
            int start = tasks[i][0];
            int end = tasks[i][1];

            if (isAvailable(jamie, start, end)) {
                assignTask(jamie, start, end);
                schedule.append("J");
            } else if (isAvailable(cameron, start, end)) {
                assignTask(cameron, start, end);
                schedule.append("C");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return schedule.toString();
    }

    private static boolean isAvailable(int[] schedule, int start, int end) {
        for (int i = start + 1; i < end; i++) {
            if (schedule[i] == 1) {
                return false;
            }
        }
        return true;
    }

    private static void assignTask(int[] schedule, int start, int end) {
        for (int i = start; i <= end; i++) {
            schedule[i] = 1;
        }
    }
}