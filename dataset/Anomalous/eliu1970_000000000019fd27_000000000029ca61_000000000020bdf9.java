import java.io.*;
import java.util.*;

public class CodeJamParenting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int testCases = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCases; t++) {
            int N = Integer.parseInt(br.readLine());
            Task[] tasks = new Task[N];
            Task[] originalTasks = new Task[N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                tasks[i] = new Task(start, end, i);
                originalTasks[i] = new Task(start, end, i);
            }

            Arrays.sort(tasks, Comparator.comparingInt(task -> task.start));

            String[] result = new String[N];
            int cEndTime = 0;
            int jEndTime = 0;
            boolean possible = true;

            for (Task task : tasks) {
                if (task.start >= cEndTime) {
                    result[task.index] = "C";
                    cEndTime = task.end;
                } else if (task.start >= jEndTime) {
                    result[task.index] = "J";
                    jEndTime = task.end;
                } else {
                    possible = false;
                    break;
                }
            }

            out.print("Case #" + t + ": ");
            if (possible) {
                for (String res : result) {
                    out.print(res);
                }
                out.println();
            } else {
                out.println("IMPOSSIBLE");
            }
        }
        out.close();
    }

    static class Task {
        int start;
        int end;
        int index;

        Task(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}