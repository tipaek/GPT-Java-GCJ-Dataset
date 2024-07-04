import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int testcase = 1; testcase <= t; testcase++) {
            int n = scanner.nextInt();
            StringBuilder schedule = new StringBuilder();
            Set<Task> cameronTasks = new HashSet<>();
            Set<Task> jamieTasks = new HashSet<>();
            boolean isImpossible = false;

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                Task newTask = new Task(start, end);

                if (canAssignTask(cameronTasks, newTask)) {
                    cameronTasks.add(newTask);
                    schedule.append('C');
                } else if (canAssignTask(jamieTasks, newTask)) {
                    jamieTasks.add(newTask);
                    schedule.append('J');
                } else {
                    System.out.println("Case #" + testcase + ": IMPOSSIBLE");
                    isImpossible = true;
                    break;
                }
            }

            if (!isImpossible) {
                System.out.println("Case #" + testcase + ": " + schedule.toString());
            }
        }

        scanner.close();
    }

    private static boolean canAssignTask(Set<Task> tasks, Task newTask) {
        for (Task task : tasks) {
            if (task.overlapsWith(newTask)) {
                return false;
            }
        }
        return true;
    }

    private static class Task {
        private final int start;
        private final int end;

        public Task(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean overlapsWith(Task other) {
            return this.start < other.end && this.end > other.start;
        }
    }
}