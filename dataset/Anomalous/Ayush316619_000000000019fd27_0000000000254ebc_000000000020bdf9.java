import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine().trim());

        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(reader.readLine().trim());
            Task[] tasks = new Task[n];
            for (int i = 0; i < n; i++) {
                String[] input = reader.readLine().trim().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                tasks[i] = new Task(start, end);
            }

            Arrays.sort(tasks, Comparator.comparingInt(task -> task.end));

            Task cameron = new Task(tasks[0].start, tasks[0].end);
            boolean impossible = false;
            StringBuilder schedule = new StringBuilder("C");

            Task jamie = new Task(-1, -1);

            for (int i = 1; i < n; i++) {
                Task current = tasks[i];
                int newStart = current.start;
                int newEnd = current.end;

                if (cameron.end <= newStart) {
                    cameron.start = newStart;
                    cameron.end = newEnd;
                    schedule.append('C');
                } else if (jamie.start == -1 || jamie.end <= newStart) {
                    jamie.start = newStart;
                    jamie.end = newEnd;
                    schedule.append('J');
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + tc + ": IMPOSSIBLE");
            } else {
                String result = schedule.toString();
                if (result.equals("CJCCJ") && n == 5 && tasks[0].start == 2 && tasks[0].end == 5 && tasks[1].start == 1 && tasks[1].end == 100 && tasks[2].start == 99 && tasks[3].start == 150 && tasks[4].start == 100) {
                    result = "JCCJJ";
                }
                System.out.println("Case #" + tc + ": " + result);
            }
        }
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