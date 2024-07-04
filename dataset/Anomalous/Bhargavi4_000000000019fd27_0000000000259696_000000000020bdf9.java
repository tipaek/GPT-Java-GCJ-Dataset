import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String tests = br.readLine();
        if (tests == null) return;

        int t = Integer.parseInt(tests);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= t; i++) {
            String in = br.readLine();
            if (in == null) return;

            int n = Integer.parseInt(in);
            Task[] tasks = new Task[n];
            char[] taskAssignments = new char[n];

            for (int k = 0; k < n; k++) {
                String task = br.readLine();
                int[] times = Stream.of(task.split(" ")).mapToInt(Integer::parseInt).toArray();
                tasks[k] = new Task(times[0], times[1]);
            }

            if (assignTasks(tasks, taskAssignments)) {
                for (int k = 0; k < taskAssignments.length; k++) {
                    if (taskAssignments[k] == 0) taskAssignments[k] = 'C';
                }
                sb.append("Case #").append(i).append(": ").append(new String(taskAssignments));
            } else {
                sb.append("Case #").append(i).append(": IMPOSSIBLE");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString().trim());
    }

    private static boolean assignTasks(Task[] tasks, char[] taskAssignments) {
        for (int i = 0; i < tasks.length; i++) {
            boolean[] conflictFlag = new boolean[taskAssignments.length];
            for (int j = i - 1; j >= 0; j--) {
                if (isOverlap(tasks[i], tasks[j])) {
                    if (conflictFlag[i] && taskAssignments[j] == taskAssignments[i]) {
                        return false;
                    }
                    taskAssignments[i] = (taskAssignments[j] == 'C') ? 'J' : 'C';
                    conflictFlag[i] = true;
                }
            }
            if (taskAssignments[i] == 0) {
                taskAssignments[i] = 'C';
            }
        }
        return true;
    }

    private static boolean isOverlap(Task t1, Task t2) {
        return (t1.start < t2.end && t1.end > t2.start);
    }

    static class Task {
        int start;
        int end;

        Task(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}