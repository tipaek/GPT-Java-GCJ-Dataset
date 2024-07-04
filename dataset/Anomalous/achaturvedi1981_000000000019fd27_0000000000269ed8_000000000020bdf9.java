import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after the integer input

            for (int i = 0; i < testCases; i++) {
                int taskCount = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character after the integer input
                String[] tasks = new String[taskCount];

                for (int j = 0; j < taskCount; j++) {
                    tasks[j] = scanner.nextLine();
                }

                String result = processSchedule(taskCount, tasks);
                System.out.println("Case #" + (i + 1) + ": " + result);
            }
        }
    }

    private static String processSchedule(int taskCount, String[] tasks) {
        StringBuilder schedule = new StringBuilder();
        int[] cSchedule = new int[1440];
        int[] jSchedule = new int[1440];

        for (String task : tasks) {
            String[] times = task.split(" ");
            int startTime = Integer.parseInt(times[0]);
            int endTime = Integer.parseInt(times[1]);

            if (allocateTask(cSchedule, startTime, endTime)) {
                schedule.append('C');
            } else if (allocateTask(jSchedule, startTime, endTime)) {
                schedule.append('J');
            } else {
                return "IMPOSSIBLE";
            }
        }
        return schedule.toString();
    }

    private static boolean allocateTask(int[] schedule, int startTime, int endTime) {
        for (int i = startTime; i < endTime; i++) {
            if (schedule[i] == 1) {
                // Reset the allocated time if the task cannot be scheduled
                for (int j = startTime; j < i; j++) {
                    schedule[j] = 0;
                }
                return false;
            }
            schedule[i] = 1;
        }
        return true;
    }
}