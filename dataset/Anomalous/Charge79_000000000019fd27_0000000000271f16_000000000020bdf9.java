import java.util.Scanner;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            boolean[] cSchedule = new boolean[1440];
            boolean[] jSchedule = new boolean[1440];
            StringBuilder result = new StringBuilder("CJ");

            scanner.nextLine(); // Consume the newline

            String firstTask = scanner.nextLine();
            String secondTask = scanner.nextLine();

            if (n != 2) {
                scheduleTask(firstTask, cSchedule, true);
                scheduleTask(secondTask, jSchedule, true);
            }

            boolean isPossible = true;
            for (int j = 2; j < n; j++) {
                String task = scanner.nextLine();
                int start = Integer.parseInt(task.split(" ")[0]);
                int end = Integer.parseInt(task.split(" ")[1]);

                if (isAvailable(cSchedule, start, end)) {
                    result.append("C");
                    Arrays.fill(cSchedule, start, end, true);
                } else if (isAvailable(jSchedule, start, end)) {
                    result.append("J");
                    Arrays.fill(jSchedule, start, end, true);
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + result.toString());
        }

        scanner.close();
    }

    private static void scheduleTask(String task, boolean[] schedule, boolean includeEnd) {
        int start = Integer.parseInt(task.split(" ")[0]);
        int end = Integer.parseInt(task.split(" ")[1]);
        if (includeEnd) {
            Arrays.fill(schedule, start, end + 1, true);
        } else {
            Arrays.fill(schedule, start, end, true);
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