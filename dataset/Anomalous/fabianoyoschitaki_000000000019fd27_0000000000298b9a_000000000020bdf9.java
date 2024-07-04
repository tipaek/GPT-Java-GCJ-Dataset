import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int numberOfTests = scanner.nextInt();
        for (int testIndex = 0; testIndex < numberOfTests; testIndex++) {
            int numberOfTasks = scanner.nextInt();
            int[][] tasks = new int[numberOfTasks][2];
            for (int taskIndex = 0; taskIndex < numberOfTasks; taskIndex++) {
                tasks[taskIndex][0] = scanner.nextInt();
                tasks[taskIndex][1] = scanner.nextInt();
            }
            System.out.println("Case #" + (testIndex + 1) + ": " + assignTasks(tasks));
        }
    }

    private static String assignTasks(int[][] tasks) {
        StringBuilder taskAssignments = new StringBuilder();
        int jEndTime = 0;
        int cEndTime = 0;
        for (int[] task : tasks) {
            int startTime = task[0];
            int endTime = task[1];
            if (jEndTime <= startTime) {
                taskAssignments.append("J");
                jEndTime = endTime;
            } else if (cEndTime <= startTime) {
                taskAssignments.append("C");
                cEndTime = endTime;
            } else {
                return "IMPOSSIBLE";
            }
        }
        return taskAssignments.toString();
    }
}