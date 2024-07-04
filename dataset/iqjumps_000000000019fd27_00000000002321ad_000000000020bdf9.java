import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= T; ++t) {
            int n = in.nextInt();
            Task[] tasks = new Task[n];
            for (int i=0; i<n; i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                tasks[i] = new Task(i, start, end);
            }
            System.out.println("Case #" + t + ": " + getSchedule(tasks));
        }
    }

    public static String getSchedule(Task[] tasks) {
        Arrays.sort(tasks, Comparator.comparingInt(t -> t.start));
        int c = 0;
        int j = 0;
        for (Task task : tasks) {
            if (task.start >= c) {
                c = task.end;
                task.user = 'C';
            } else if (task.start >= j) {
                j = task.end;
                task.user = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }
        Arrays.sort(tasks, Comparator.comparingInt(t -> t.id));
        StringBuilder sb = new StringBuilder();
        for (Task task : tasks) {
            sb.append(task.user);
        }
        return sb.toString();
    }

    static class Task {
        int id;
        int start;
        int end;
        char user;

        public Task(int id, int start, int end) {
            this.id = id;
            this.start = start;
            this.end = end;
        }
    }
}

