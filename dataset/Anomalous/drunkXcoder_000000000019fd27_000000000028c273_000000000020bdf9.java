import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int c = 1; c <= t; c++) {
            int n = Integer.parseInt(br.readLine());
            Task[] tasks = new Task[n];

            for (int i = 0; i < n; i++) {
                String[] time = br.readLine().trim().split("\\s+");
                int start = Integer.parseInt(time[0]);
                int end = Integer.parseInt(time[1]);
                tasks[i] = new Task(start, end, i);
            }

            Arrays.sort(tasks, (a, b) -> Integer.compare(a.start, b.start));

            int cEnd = -1, jEnd = -1;
            String[] result = new String[n];
            boolean isPossible = true;

            for (Task task : tasks) {
                if (task.start >= cEnd) {
                    result[task.index] = "C";
                    cEnd = task.end;
                } else if (task.start >= jEnd) {
                    result[task.index] = "J";
                    jEnd = task.end;
                } else {
                    System.out.println("Case #" + c + ": IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                System.out.println("Case #" + c + ": " + String.join("", result));
            }
        }
    }

    static class Task {
        int start, end, index;

        Task(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}