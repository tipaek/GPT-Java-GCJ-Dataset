import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int x = 0; x < t; x++) {
            List<Task> tasks = new ArrayList<>();
            int n = sc.nextInt();

            for (int ni = 0; ni < n; ni++) {
                tasks.add(new Task(ni, sc.nextInt(), sc.nextInt()));
            }

            tasks.sort(Comparator.comparingInt(task -> task.start));

            Map<String, List<AssignedTask>> assignedTasks = new HashMap<>();
            assignedTasks.put("C", new ArrayList<>());
            assignedTasks.put("J", new ArrayList<>());

            boolean impossible = false;
            for (Task task : tasks) {
                if (!hasOverlap(task, assignedTasks.get("C"))) {
                    assignedTasks.get("C").add(new AssignedTask(task, "C"));
                } else if (!hasOverlap(task, assignedTasks.get("J"))) {
                    assignedTasks.get("J").add(new AssignedTask(task, "J"));
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", x);
            } else {
                List<AssignedTask> allAssignedTasks = new ArrayList<>();
                allAssignedTasks.addAll(assignedTasks.get("C"));
                allAssignedTasks.addAll(assignedTasks.get("J"));

                String result = allAssignedTasks.stream()
                        .sorted(Comparator.comparingInt(at -> at.task.idx))
                        .map(at -> at.assignee)
                        .reduce("", String::concat);

                System.out.printf("Case #%d: %s\n", x, result);
            }
        }
    }

    private static boolean hasOverlap(Task task, List<AssignedTask> assignedTasks) {
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