import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int tasksCount = scanner.nextInt();
            int[][] tasks = new int[tasksCount][2];

            for (int i = 0; i < tasksCount; i++) {
                tasks[i][0] = scanner.nextInt();
                tasks[i][1] = scanner.nextInt();
            }

            String result = assignTasks(tasks, tasksCount);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    private static String assignTasks(int[][] tasks, int tasksCount) {
        StringBuilder scheduleBuilder = new StringBuilder();
        int[] jamieSchedule = new int[1441];
        int[] cameronSchedule = new int[1441];

        for (int i = 0; i < tasksCount; i++) {
            int start = tasks[i][0];
            int end = tasks[i][1];

            if (isAvailable(jamieSchedule, start, end)) {
                markSchedule(jamieSchedule, start, end);
                scheduleBuilder.append("J");
            } else if (isAvailable(cameronSchedule, start, end)) {
                markSchedule(cameronSchedule, start, end);
                scheduleBuilder.append("C");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return scheduleBuilder.toString();
    }

    private static boolean isAvailable(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i] == 1) {
                return false;
            }
        }
        return true;
    }

    private static void markSchedule(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i] = 1;
        }
    }
}