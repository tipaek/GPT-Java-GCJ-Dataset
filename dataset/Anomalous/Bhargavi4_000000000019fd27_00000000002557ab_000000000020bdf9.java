import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

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

            for (int k = 0; k < n; k++) {
                String task = br.readLine();
                int[] times = Arrays.stream(task.split(" ")).mapToInt(Integer::parseInt).toArray();
                tasks[k] = new Task(times[0], times[1]);
            }

            char[] taskAssignments = new char[n];
            if (assignTasks(tasks, taskAssignments)) {
                for (int k = 0; k < taskAssignments.length; k++) {
                    if (taskAssignments[k] == 0) taskAssignments[k] = 'J';
                }
                sb.append("Case #").append(i).append(": ").append(String.valueOf(taskAssignments));
            } else {
                sb.append("Case #").append(i).append(": IMPOSSIBLE");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    private static boolean assignTasks(Task[] tasks, char[] taskAssignments) {
        int[] overlapCount = new int[tasks.length];

        for (int i = 0; i < tasks.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (isOverlap(tasks[i], tasks[j])) {
                    if (tasks[i].start > tasks[j].start && tasks[i].end < tasks[j].end) {
                        overlapCount[j]++;
                    }
                    taskAssignments[i] = taskAssignments[j] == 'C' ? 'J' : 'C';
                }
            }
        }

        for (int count : overlapCount) {
            if (count >= 2) return false;
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