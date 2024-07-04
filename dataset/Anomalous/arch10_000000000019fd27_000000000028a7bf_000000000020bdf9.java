import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        String[] results = new String[testCases];

        for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
            int taskCount = scanner.nextInt();
            int[][] tasks = new int[taskCount][2];

            for (int taskIndex = 0; taskIndex < taskCount; taskIndex++) {
                tasks[taskIndex][0] = scanner.nextInt();
                tasks[taskIndex][1] = scanner.nextInt();
            }

            results[caseIndex] = "Case #" + (caseIndex + 1) + ": " + assignTasks(tasks);
        }

        for (String result : results) {
            System.out.println(result);
        }
    }

    private static String assignTasks(int[][] tasks) {
        StringBuilder schedule = new StringBuilder();
        int[] jamieSchedule = new int[1441];
        int[] cameronSchedule = new int[1441];

        for (int[] task : tasks) {
            int start = task[0];
            int end = task[1];

            if (isAvailable(jamieSchedule, start, end)) {
                markSchedule(jamieSchedule, start, end);
                schedule.append("J");
            } else if (isAvailable(cameronSchedule, start, end)) {
                markSchedule(cameronSchedule, start, end);
                schedule.append("C");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return schedule.toString();
    }

    private static boolean isAvailable(int[] schedule, int start, int end) {
        for (int time = start + 1; time < end; time++) {
            if (schedule[time] == 1) {
                return false;
            }
        }
        return true;
    }

    private static void markSchedule(int[] schedule, int start, int end) {
        for (int time = start; time <= end; time++) {
            schedule[time] = 1;
        }
    }
}