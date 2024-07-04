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
            sb.append("case #").append(i).append(": ");
            String in = br.readLine();
            if (in == null) return;

            int n = Integer.parseInt(in);
            Task[] tasks = new Task[n];

            for (int k = 0; k < n; k++) {
                String task = br.readLine();
                int[] times = Arrays.stream(task.split(" ")).mapToInt(Integer::parseInt).toArray();
                tasks[k] = new Task(times[0], times[1], k, null);
            }

            Arrays.sort(tasks, (o1, o2) -> Integer.compare(o1.start, o2.start));

            int cEnd = 0, jEnd = 0;
            boolean isPossible = true;
            for (Task task : tasks) {
                if (cEnd <= task.start) {
                    task.person = "C";
                    cEnd = task.end;
                } else if (jEnd <= task.start) {
                    task.person = "J";
                    jEnd = task.end;
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                Arrays.sort(tasks, (t1, t2) -> Integer.compare(t1.task, t2.task));
                for (Task task : tasks) {
                    sb.append(task.person);
                }
            } else {
                sb.append("IMPOSSIBLE");
            }

            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static class Task {
        int start;
        int end;
        int task;
        String person;

        Task(int start, int end, int task, String person) {
            this.start = start;
            this.end = end;
            this.task = task;
            this.person = person;
        }
    }
}