import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int testcase = 1; testcase <= t; testcase++) {
            int n = sc.nextInt();
            StringBuilder result = new StringBuilder();
            Set<Task> cameronTasks = new HashSet<>();
            Set<Task> jamieTasks = new HashSet<>();
            boolean isImpossible = false;

            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                Task newTask = new Task(start, end);

                if (!isImpossible) {
                    if (!hasConflict(cameronTasks, newTask)) {
                        cameronTasks.add(newTask);
                        result.append('C');
                    } else if (!hasConflict(jamieTasks, newTask)) {
                        jamieTasks.add(newTask);
                        result.append('J');
                    } else {
                        System.out.println("Case #" + testcase + ": IMPOSSIBLE");
                        isImpossible = true;
                    }
                } else {
                    sc.nextInt();
                    sc.nextInt();
                }
            }

            if (!isImpossible) {
                System.out.println("Case #" + testcase + ": " + result.toString());
            }
        }

        sc.close();
    }

    private static boolean hasConflict(Set<Task> tasks, Task newTask) {
        for (Task task : tasks) {
            if (newTask.overlapsWith(task)) {
                return true;
            }
        }
        return false;
    }

    static class Task {
        private final int start;
        private final int end;

        public Task(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean overlapsWith(Task other) {
            return !(this.end <= other.start || this.start >= other.end);
        }
    }
}