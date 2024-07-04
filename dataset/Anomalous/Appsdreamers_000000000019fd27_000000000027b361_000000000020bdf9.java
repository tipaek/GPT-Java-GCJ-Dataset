import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseNumber = scanner.nextInt();

        for (int i = 0; i < testCaseNumber; i++) {
            int totalTask = scanner.nextInt();
            int[][] schedule = new int[totalTask][2];

            for (int j = 0; j < totalTask; j++) {
                schedule[j][0] = scanner.nextInt();
                schedule[j][1] = scanner.nextInt();
            }

            System.out.println(getSchedule(schedule, totalTask, i + 1));
        }

        scanner.close();
    }

    public static String getSchedule(int[][] schedule, int totalTask, int caseNumber) {
        StringBuilder result = new StringBuilder("Case #" + caseNumber + ": ");
        StringBuilder taskString = new StringBuilder();

        int[] cameron = new int[totalTask];
        int[] jamie = new int[totalTask];
        int cameronTaskCount = 0;
        int jamieTaskCount = 0;

        for (int i = 0; i < totalTask; i++) {
            if (cameronTaskCount == 0) {
                cameron[cameronTaskCount++] = i;
                taskString.append("C");
            } else if (jamieTaskCount == 0) {
                jamie[jamieTaskCount++] = i;
                taskString.append("J");
            } else {
                int secondTaskStart = schedule[i][0];
                int secondTaskEnd = schedule[i][1];

                if (canAssignTask(cameron, cameronTaskCount, schedule, secondTaskStart, secondTaskEnd)) {
                    cameron[cameronTaskCount++] = i;
                    taskString.append("C");
                } else if (canAssignTask(jamie, jamieTaskCount, schedule, secondTaskStart, secondTaskEnd)) {
                    jamie[jamieTaskCount++] = i;
                    taskString.append("J");
                } else {
                    taskString = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
        }

        result.append(taskString);
        return result.toString();
    }

    public static boolean canAssignTask(int[] tasks, int taskCount, int[][] schedule, int start, int end) {
        for (int i = 0; i < taskCount; i++) {
            int firstTaskStart = schedule[tasks[i]][0];
            int firstTaskEnd = schedule[tasks[i]][1];
            if (isOverlap(firstTaskStart, firstTaskEnd, start, end)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isOverlap(int firstTaskStart, int firstTaskEnd, int secondTaskStart, int secondTaskEnd) {
        return secondTaskStart < firstTaskEnd && secondTaskEnd > firstTaskStart;
    }
}