import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static java.util.Comparator.comparingInt;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int x = 0; x < t; x++) {
            List<Task> tasks = new ArrayList<>();

            int n = sc.nextInt();

            for (int ni = 0; ni < n; ni++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                tasks.add(new Task(ni, s, e));
            }

            tasks.sort(comparingInt(t2 -> t2.start));

            Map<String, List<AssignedTask>> tmp = new HashMap<>();
            tmp.put("C", new ArrayList<>());
            tmp.put("J", new ArrayList<>());

            boolean impossible = false;
            for (int i=0; i<tasks.size(); i++) {
                Task task = tasks.get(i);
                if (!overlaps(task, tmp.get("C"))) {
                    tmp.get("C").add(new AssignedTask(task, "C"));
                } else if (!overlaps(task, tmp.get("J"))) {
                    tmp.get("J").add(new AssignedTask(task, "J"));
                } else {
                    impossible = true;
                    break;
                }
                impossible = false;
            }

            if (impossible) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", x);
            } else {
                List<AssignedTask> all = new ArrayList<>();
                all.addAll(tmp.get("C"));
                all.addAll(tmp.get("J"));

                String result = all.stream()
                    .sorted(comparingInt(t2 -> t2.task.idx))
                        .map(tx -> tx.assignee)
                        .reduce("", String::concat);
                System.out.printf("Case #%d: %s\n", x, result);
            }
        }
    }

    private static boolean overlaps(Task task, List<AssignedTask> tasks) {
        for (AssignedTask assignedTask : tasks) {
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
        private Task(int idx, int start, int end) {
            this.idx = idx;
            this.start = start;
            this.end = end;
        }
    }

    private static class AssignedTask {
        final Task task;
        final String assignee;
        private AssignedTask(Task task, String assignee) {
            this.task = task;
            this.assignee = assignee;
        }
    }
}
