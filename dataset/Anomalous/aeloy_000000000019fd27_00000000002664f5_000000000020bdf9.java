import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int x = 0; x < t; x++) {
            int n = sc.nextInt();
            Task[] tasks = new Task[n];

            for (int i = 0; i < n; i++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                tasks[i] = new Task(i, s, e);
            }

            Arrays.sort(tasks, Comparator.comparingInt(task -> task.start));

            List<AssignedTask> cTasks = new ArrayList<>();
            List<AssignedTask> jTasks = new ArrayList<>();

            boolean impossible = false;
            for (Task task : tasks) {
                if (!overlaps(task, cTasks)) {
                    cTasks.add(new AssignedTask(task, "C"));
                } else if (!overlaps(task, jTasks)) {
                    jTasks.add(new AssignedTask(task, "J"));
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", x + 1);
            } else {
                AssignedTask[] allTasks = new AssignedTask[n];
                for (AssignedTask assignedTask : cTasks) {
                    allTasks[assignedTask.task.idx] = assignedTask;
                }
                for (AssignedTask assignedTask : jTasks) {
                    allTasks[assignedTask.task.idx] = assignedTask;
                }

                StringBuilder result = new StringBuilder();
                for (AssignedTask assignedTask : allTasks) {
                    result.append(assignedTask.assignee);
                }
                System.out.printf("Case #%d: %s\n", x + 1, result.toString());
            }
        }
    }

    private static boolean overlaps(Task task, List<AssignedTask> assignedTasks) {
        for (AssignedTask assignedTask : assignedTasks) {
            if (task.start < assignedTask.task.end) {
                return true;
            }
        }
        return false;
    }

    private static class Task {
        final int idx;
        final int start;
        final int end;

        Task(int idx, int start, int end) {
            this.idx = idx;
            this.start = start;
            this.end = end;
        }
    }

    private static class AssignedTask {
        final Task task;
        final String assignee;

        AssignedTask(Task task, String assignee) {
            this.task = task;
            this.assignee = assignee;
        }
    }
}