import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    static class Task {
        int start, end, index;
        boolean isChecked;

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

            for (int i = 0; i < numTasks; i++) {
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

            for (int i = 0; i < numTasks - 2; i++) {
                if (tasks[i + 2].start < Math.min(tasks[i].end, tasks[i + 1].end)) {
                    result.append("IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                Task previousTask = tasks[0];
                previousTask.isChecked = true;

                for (int i = 1; i < numTasks; i++) {
                    if (tasks[i].start < previousTask.end) {
                        continue;
                    }
                    previousTask = tasks[i];
                    previousTask.isChecked = true;
                }

                Set<Integer> checkedTasks = new HashSet<>();
                for (Task task : tasks) {
                    if (task.isChecked) {
                        checkedTasks.add(task.index);
                    }
                }

                for (int i = 1; i <= numTasks; i++) {
                    if (checkedTasks.contains(i)) {
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