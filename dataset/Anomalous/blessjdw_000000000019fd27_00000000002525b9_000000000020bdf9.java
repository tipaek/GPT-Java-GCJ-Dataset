import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    static class Task {
        int start, end, index;
        boolean isAssignedToCameron;

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
            int numberOfTasks = scanner.nextInt();
            Task[] tasks = new Task[numberOfTasks];

            for (int i = 0; i < numberOfTasks; i++) {
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
            boolean isImpossible = false;

            for (int i = 0; i < tasks.length - 2; i++) {
                Task task1 = tasks[i];
                Task task2 = tasks[i + 1];
                Task task3 = tasks[i + 2];

                int latestStart = Math.max(Math.max(task1.start, task2.start), task3.start);
                int earliestEnd = Math.min(Math.min(task1.end, task2.end), task3.end);

                if (latestStart < earliestEnd) {
                    result.append("IMPOSSIBLE");
                    isImpossible = true;
                    break;
                }
            }

            if (!isImpossible) {
                Task currentTask = tasks[0];
                currentTask.isAssignedToCameron = true;

                for (int i = 1; i < tasks.length; i++) {
                    if (tasks[i].start < currentTask.end) {
                        continue;
                    }
                    currentTask = tasks[i];
                    currentTask.isAssignedToCameron = true;
                }

                Set<Integer> cameronTasks = new HashSet<>();
                for (Task task : tasks) {
                    if (task.isAssignedToCameron) {
                        cameronTasks.add(task.index);
                    }
                }

                for (int i = 1; i <= numberOfTasks; i++) {
                    if (cameronTasks.contains(i)) {
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