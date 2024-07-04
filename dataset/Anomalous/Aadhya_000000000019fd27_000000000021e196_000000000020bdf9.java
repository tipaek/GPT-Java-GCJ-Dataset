import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTestCases = scanner.nextInt();
        String[] results = new String[numTestCases];

        for (int testCase = 0; testCase < numTestCases; testCase++) {
            int numTasks = scanner.nextInt();
            int[][] tasks = new int[numTasks][3];
            int[][] events = new int[2 * numTasks][2];

            for (int task = 0; task < numTasks; task++) {
                tasks[task][0] = scanner.nextInt(); // Start
                tasks[task][1] = scanner.nextInt(); // End
                tasks[task][2] = task;

                events[2 * task][0] = tasks[task][0];
                events[2 * task][1] = 1; // Start event

                events[2 * task + 1][0] = tasks[task][1];
                events[2 * task + 1][1] = -1; // End event
            }

            Arrays.sort(events, Comparator.comparingInt(a -> a[0]));

            int concurrentTasks = 0;
            boolean isImpossible = false;
            for (int[] event : events) {
                concurrentTasks += event[1];
                if (concurrentTasks > 2) {
                    results[testCase] = "IMPOSSIBLE";
                    isImpossible = true;
                    break;
                }
            }

            if (!isImpossible) {
                Arrays.sort(tasks, Comparator.comparingInt(a -> a[0]));

                int[] cBusy = {0, 0};
                int[] jBusy = {0, 0};
                char[] taskAssignments = new char[numTasks];

                for (int[] task : tasks) {
                    if (cBusy[1] <= task[0]) {
                        cBusy[0] = task[0];
                        cBusy[1] = task[1];
                        taskAssignments[task[2]] = 'C';
                    } else if (jBusy[1] <= task[0]) {
                        jBusy[0] = task[0];
                        jBusy[1] = task[1];
                        taskAssignments[task[2]] = 'J';
                    } else {
                        results[testCase] = "IMPOSSIBLE";
                        isImpossible = true;
                        break;
                    }
                }

                if (!isImpossible) {
                    results[testCase] = new String(taskAssignments);
                }
            }
        }

        for (int i = 0; i < numTestCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }
    }
}