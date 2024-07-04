import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine().trim());

        for (int tc = 1; tc <= testCases; tc++) {
            int n = Integer.parseInt(reader.readLine().trim());
            Task[] tasks = new Task[n];
            for (int i = 0; i < n; i++) {
                String[] input = reader.readLine().trim().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                tasks[i] = new Task(start, end, i);
            }
            Arrays.sort(tasks, new TaskComparator());

            Task cameron = new Task(tasks[0].start, tasks[0].end, tasks[0].index);
            Task jamie = new Task(-1, -1, -1);
            boolean impossible = false;

            char[] schedule = new char[n];
            schedule[cameron.index] = 'C';

            for (int i = 1; i < n; i++) {
                Task current = tasks[i];
                if (cameron.end <= current.start) {
                    cameron.start = current.start;
                    cameron.end = current.end;
                    schedule[current.index] = 'C';
                } else if (jamie.start == -1 || jamie.end <= current.start) {
                    jamie.start = current.start;
                    jamie.end = current.end;
                    schedule[current.index] = 'J';
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + tc + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + tc + ": " + new String(schedule));
            }
        }
    }

    static class Task {
        int start;
        int end;
        int index;

        public Task(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    static class TaskComparator implements Comparator<Task> {
        @Override
        public int compare(Task a, Task b) {
            return Integer.compare(a.end, b.end);
        }
    }
}