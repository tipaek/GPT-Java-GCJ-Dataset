import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String testCasesInput = br.readLine();
        if (testCasesInput == null) return;

        int testCases = Integer.parseInt(testCasesInput);
        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= testCases; i++) {
            String numberOfTasksInput = br.readLine();
            if (numberOfTasksInput == null) return;

            int numberOfTasks = Integer.parseInt(numberOfTasksInput);
            Task[] tasks = new Task[numberOfTasks];
            char[] taskAssignments = new char[numberOfTasks];

            for (int j = 0; j < numberOfTasks; j++) {
                String taskInput = br.readLine();
                int[] times = Arrays.stream(taskInput.split(" ")).mapToInt(Integer::parseInt).toArray();
                tasks[j] = new Task(times[0], times[1]);
            }

            if (assignTasks(tasks, taskAssignments)) {
                for (int k = 0; k < taskAssignments.length; k++) {
                    if (taskAssignments[k] == 0) taskAssignments[k] = 'J';
                }
                result.append("Case #").append(i).append(": ").append(new String(taskAssignments));
            } else {
                result.append("Case #").append(i).append(": IMPOSSIBLE");
            }
            result.append("\n");
        }

        System.out.print(result.toString());
    }

    private static boolean assignTasks(Task[] tasks, char[] taskAssignments) {
        int[] overlapCount = new int[tasks.length];

        for (int i = 0; i < tasks.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (isOverlap(tasks[i], tasks[j])) {
                    if (tasks[i].start > tasks[j].start && tasks[i].end < tasks[j].end) {
                        overlapCount[j]++;
                    }
                    if (taskAssignments[j] == 0) {
                        taskAssignments[i] = 'C';
                    } else {
                        taskAssignments[i] = (taskAssignments[j] == 'C') ? 'J' : 'C';
                    }
                }
            }
        }

        for (int count : overlapCount) {
            if (count >= 2) return false;
        }

        return true;
    }

    private static boolean isOverlap(Task t1, Task t2) {
        return (t1.start < t2.end && t1.end > t2.start);
    }

    static class Task {
        int start;
        int end;

        Task(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}