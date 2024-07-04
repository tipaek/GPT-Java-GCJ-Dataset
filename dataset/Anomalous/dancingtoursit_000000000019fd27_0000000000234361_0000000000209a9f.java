import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ParentinPartneringReturns {

    private static boolean overlaps(int[] task1, int[] task2) {
        return task1[0] < task2[1] && task1[1] > task2[0];
    }

    private static String assignTasks(int[][] tasks, int taskCount) {
        Set<Integer> jennieTasks = new HashSet<>();
        Set<Integer> cameronTasks = new HashSet<>();

        for (int i = 0; i < taskCount; i++) {
            int j = i + 1;
            boolean foundOverlap = false;
            int taskA = -1;
            int taskB = -1;
            while (j < taskCount) {
                if (overlaps(tasks[i], tasks[j])) {
                    taskA = i + 1;
                    taskB = j + 1;
                    foundOverlap = true;
                }
                j++;
            }
            if (foundOverlap) {
                jennieTasks.add(taskA);
                cameronTasks.add(taskB);
                break;
            }
        }

        StringBuilder result = new StringBuilder();

        if (cameronTasks.isEmpty()) {
            for (int task = 0; task < taskCount; task++) {
                result.append(task % 2 == 0 ? 'C' : 'J');
            }
            return result.toString();
        }

        for (int i = 0; i < taskCount; i++) {
            boolean overlapsWithJennie = false;
            boolean overlapsWithCameron = false;

            for (int task : jennieTasks) {
                if (i + 1 != task && overlaps(tasks[task - 1], tasks[i])) {
                    overlapsWithJennie = true;
                }
            }

            for (int task : cameronTasks) {
                if (i + 1 != task && overlaps(tasks[task - 1], tasks[i])) {
                    overlapsWithCameron = true;
                }
            }

            if (overlapsWithJennie && overlapsWithCameron) {
                return "IMPOSSIBLE";
            }

            if (overlapsWithJennie) {
                cameronTasks.add(i + 1);
            } else if (overlapsWithCameron) {
                jennieTasks.add(i + 1);
            } else {
                jennieTasks.add(i + 1);
            }
        }

        char[] taskAssignments = new char[taskCount];
        for (int task : jennieTasks) {
            taskAssignments[task - 1] = 'J';
        }
        for (int task : cameronTasks) {
            taskAssignments[task - 1] = 'C';
        }

        return new String(taskAssignments);
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int taskCount = scanner.nextInt();
            int[][] tasks = new int[taskCount][2];
            for (int task = 0; task < taskCount; task++) {
                tasks[task][0] = scanner.nextInt();
                tasks[task][1] = scanner.nextInt();
            }
            String result = assignTasks(tasks, taskCount);
            writer.write(String.format("Case #%d: %s\n", testCase, result));
            writer.flush();
        }
    }
}