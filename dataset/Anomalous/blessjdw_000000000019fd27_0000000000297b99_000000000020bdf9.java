import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    static class Task {
        int start, end, index;
        boolean isAssigned;

        public Task(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int taskCount = scanner.nextInt();
            Task[] tasks = new Task[taskCount];

            for (int i = 0; i < taskCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                tasks[i] = new Task(start, end, i + 1);
            }

            Arrays.sort(tasks, (task1, task2) -> {
                if (task1.start == task2.start) {
                    return Integer.compare(task1.end, task2.end);
                }
                return Integer.compare(task1.start, task2.start);
            });

            StringBuilder result = new StringBuilder();
            boolean isPossible = true;

            for (int i = 0; i < taskCount - 2; i++) {
                if (tasks[i + 2].start < Math.min(tasks[i].end, tasks[i + 1].end)) {
                    result.append("IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                Task lastAssignedTask = tasks[0];
                lastAssignedTask.isAssigned = true;

                for (int i = 1; i < taskCount; i++) {
                    if (tasks[i].start >= lastAssignedTask.end) {
                        lastAssignedTask = tasks[i];
                        lastAssignedTask.isAssigned = true;
                    }
                }

                Set<Integer> assignedTasks = new HashSet<>();
                for (Task task : tasks) {
                    if (task.isAssigned) {
                        assignedTasks.add(task.index);
                    }
                }

                for (int i = 1; i <= taskCount; i++) {
                    if (assignedTasks.contains(i)) {
                        result.append("C");
                    } else {
                        result.append("J");
                    }
                }
            }

            System.out.println("Case #" + t + ": " + result.toString());
        }
    }
}