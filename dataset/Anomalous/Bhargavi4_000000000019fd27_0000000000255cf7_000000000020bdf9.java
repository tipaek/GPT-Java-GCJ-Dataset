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
            char[] taskAssignments = new char[n];

            for (int k = 0; k < n; k++) {
                String task = br.readLine();
                int[] times = Arrays.stream(task.split(" "))
                                    .mapToInt(Integer::parseInt)
                                    .toArray();
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
        System.out.println(sb.toString());
    }

    private static boolean assignTasks(Task[] tasks, char[] taskAssignments) {
        int[] overlapCount = new int[tasks.length];

        for (int i = 0; i < tasks.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (isOverlap(tasks[i], tasks[j])) {
                    overlapCount[j]++;
                    taskAssignments[i] = (taskAssignments[j] == 0) ? 'C' : (taskAssignments[j] == 'C' ? 'J' : 'C');
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