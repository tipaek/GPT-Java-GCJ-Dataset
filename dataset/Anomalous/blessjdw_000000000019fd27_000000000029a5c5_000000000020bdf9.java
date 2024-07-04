import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    static class Task {
        int start, end, index;
        boolean assigned;

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
            int numTasks = scanner.nextInt();
            Task[] tasks = new Task[numTasks];

            for (int n = 0; n < numTasks; n++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                tasks[n] = new Task(start, end, n + 1);
            }

            Arrays.sort(tasks, (task1, task2) -> {
                if (task1.start == task2.start) return Integer.compare(task1.end, task2.end);
                return Integer.compare(task1.start, task2.start);
            });

            StringBuilder result = new StringBuilder();
            if (isImpossible(tasks)) {
                result.append("IMPOSSIBLE");
            } else {
                assignTasks(tasks);
                Set<Integer> assignedTasks = new HashSet<>();
                for (Task task : tasks) {
                    if (task.assigned) {
                        assignedTasks.add(task.index);
                    }
                }
                for (int i = 1; i <= numTasks; i++) {
                    result.append(assignedTasks.contains(i) ? "C" : "J");
                }
            }
            System.out.println("Case #" + t + ": " + result.toString());
        }
    }

    private static boolean isImpossible(Task[] tasks) {
        for (int i = 0; i <= 1440; i++) {
            if (countConcurrentTasks(tasks, i) > 2) {
                return true;
            }
        }
        return false;
    }

    private static void assignTasks(Task[] tasks) {
        Task currentTask = tasks[0];
        currentTask.assigned = true;

        for (int i = 1; i < tasks.length; i++) {
            if (tasks[i].start < currentTask.end) {
                continue;
            }
            currentTask = tasks[i];
            currentTask.assigned = true;
        }
    }

    private static int countConcurrentTasks(Task[] tasks, int time) {
        int count = 0;
        for (Task task : tasks) {
            if (task.start <= time && task.end > time) {
                count++;
            }
        }
        return count;
    }
}