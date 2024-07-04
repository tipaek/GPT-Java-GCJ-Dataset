import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int c = 1; c <= t; c++) {
            int n = in.nextInt();
            List<Task> tasks = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Task task = new Task();
                task.start = in.nextInt();
                task.end = in.nextInt();
                task.i = i;
                tasks.add(task);
            }
            Collections.sort(tasks, (t1, t2) -> { return t1.start - t2.start; });
            List<Character> workers = new ArrayList<>();
            workers.add('C');
            workers.add('J');
            List<Task> runningTasks = new ArrayList<>();
            boolean isImpossible = false;
            StringBuilder schedule = new StringBuilder();
            for (Task task: tasks) {
                List<Task> toRemove = new ArrayList<>();
                for (Task rt: runningTasks) {
                    if (rt.end <= task.start) {
                        toRemove.add(rt);
                        workers.add(rt.worker);
                    }
                }
                runningTasks.removeAll(toRemove);

                if (workers.isEmpty()) {
                    isImpossible = true;
                    break;
                }

                task.worker = workers.remove(0);
                runningTasks.add(task);
            }
            Collections.sort(tasks, (t1, t2) -> { return t1.i - t2.i; });
            for (Task task: tasks) {
                schedule.append(task.worker);
            }
            if (isImpossible) {
                System.out.println(String.format("Case #%d: IMPOSSIBLE", c));
            } else {
                System.out.println(String.format("Case #%d: %s", c, schedule.toString()));
            }
        }
    }

    public static class Task {
        int start;
        int end;
        char worker;
        int i;
    }
}