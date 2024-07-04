import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            List<Task> taskList = new ArrayList<>();

            for (int x = 0; x < n; x++) {
                Task task = new Task(x, in.nextInt(), in.nextInt());
                taskList.add(task);
            }

            System.out.println("Case #" + i + ": " + solve(n, taskList));
        }
    }

    public static String solve(int n, List<Task> taskList) {
        taskList.sort((t1, t2) -> t1.start == t2.start ? t1.end - t2.end : t1.start - t2.start);

        Map<Integer, Task> taskMap = new HashMap<>();

        String cameron = "C";
        String jamie = "J";

        Task t = taskList.get(0);
        int cameronEnd = t.end;
        t.setOwner(cameron);
        taskMap.put(t.id, t);

        int jamieEnd = 0;

        for (int i = 1; i < taskList.size(); i++) {
            Task task = taskList.get(i);

            if (canAssign(task, cameronEnd)) {
                cameronEnd = Math.max(cameronEnd, task.end);
                task.setOwner(cameron);
                taskMap.put(task.id, task);
            } else if (canAssign(task, jamieEnd)) {
                jamieEnd = Math.max(jamieEnd, task.end);
                task.setOwner(jamie);
                taskMap.put(task.id, task);
            } else {
                return "IMPOSSIBLE";
            }
        }

        StringBuffer out = new StringBuffer();
        for (int i = 0; i < n; i++) {
            out.append(taskMap.get(i).getOwner());
        }
        return out.toString();
    }

    public static boolean canAssign(Task task, int end) {
        return task.start >= end;
    }

    public static class Task {

        int start;
        int end;
        int id;
        String owner;

        public Task(int id, int s, int e) {
            this.id = id;
            this.start = s;
            this.end = e;
        }

        public void setOwner(String s) {
            this.owner = s;
        }

        public String getOwner() {
            return this.owner;
        }
    }
}
