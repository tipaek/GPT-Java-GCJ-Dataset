import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTestCases = scanner.nextInt();
        String[] results = new String[numTestCases];

        for (int testCase = 0; testCase < numTestCases; testCase++) {
            int numTasks = scanner.nextInt();
            int[][] tasks = new int[numTasks][3];

            for (int task = 0; task < numTasks; task++) {
                tasks[task][0] = scanner.nextInt(); // Start time
                tasks[task][1] = scanner.nextInt(); // End time
                tasks[task][2] = task; // Original index
            }

            Arrays.sort(tasks, Comparator.comparingInt(a -> a[0]));

            int[] cBusyUntil = {0}; // C's busy end time
            int[] jBusyUntil = {0}; // J's busy end time
            char[] taskAssignments = new char[numTasks];
            boolean possible = true;

            for (int[] task : tasks) {
                int startTime = task[0];
                int endTime = task[1];
                int originalIndex = task[2];

                if (cBusyUntil[0] <= startTime) {
                    cBusyUntil[0] = endTime;
                    taskAssignments[originalIndex] = 'C';
                } else if (jBusyUntil[0] <= startTime) {
                    jBusyUntil[0] = endTime;
                    taskAssignments[originalIndex] = 'J';
                } else {
                    results[testCase] = "IMPOSSIBLE";
                    possible = false;
                    break;
                }
            }

            if (possible) {
                results[testCase] = new String(taskAssignments);
            }
        }

        for (int i = 0; i < numTestCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }
    }
}