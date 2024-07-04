import java.util.*;
import java.io.*;

// Parenting Partnering Returns
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            Task[] tasks = new Task[n];
            for (int k = 0; k < n; k++) {
                int s = in.nextInt();
                int e = in.nextInt();
                Task task = new Task(k, s, e);
                tasks[k] = task;
            }
            Arrays.sort(tasks, new Comparator<Task>() {
                @Override
                public int compare(Task task, Task t1) {
                    return task.startTime - t1.startTime;
                }
            });
            String res = solve(tasks);
            System.out.println("Case #" + i + ": " + res);
        }
    }

    private static String solve(Task[] tasks) {
        int endC = 0;
        int endJ = 0;
        for (int i = 0; i < tasks.length; i++) {
            Task task = tasks[i];
            if (endC <= task.startTime) {
                endC = task.endTime;
                task.setParent('C');
                continue;
            }
            if (endJ <= task.startTime) {
                endJ = task.endTime;
                task.setParent('J');
                continue;
            }
            return "IMPOSSIBLE";
        }
        Arrays.sort(tasks, new Comparator<Task>() {
            @Override
            public int compare(Task task, Task t1) {
                return task.idx - t1.idx;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tasks.length; i++) {
            sb.append(tasks[i].parent);
        }
        return sb.toString();
    }

    static class Task {
        int idx;
        int startTime;
        int endTime;
        char parent;

        public Task(int idx, int startTime, int endTime) {
            this.idx = idx;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public void setParent(char parent) {
            this.parent = parent;
        }
    }
}