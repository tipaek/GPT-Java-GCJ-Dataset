import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            System.out.print("Case #" + i + ": ");
            solve();
        }
    }

    public static void solve() throws Exception {
        int n = scanner.nextInt();
        char[] who = new char[n];
        Task[] tasks = new Task[n];

        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            tasks[i] = new Task(start, end, i);
        }

        Arrays.sort(tasks);

        StringBuilder result = assignTasks(0, tasks, 0, 0);

        if (result == null) {
            System.out.println("IMPOSSIBLE");
        } else {
            for (int i = 0; i < n; i++) {
                who[tasks[i].id] = result.charAt(i);
            }
            for (char c : who) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static StringBuilder assignTasks(int idx, Task[] tasks, int C, int J) {
        if (idx >= tasks.length) {
            return new StringBuilder();
        }

        if (C <= tasks[idx].start) {
            StringBuilder sb = assignTasks(idx + 1, tasks, tasks[idx].end, J);
            if (sb != null) {
                sb.append('C');
                return sb;
            }
        }

        if (J <= tasks[idx].start) {
            StringBuilder sb = assignTasks(idx + 1, tasks, C, tasks[idx].end);
            if (sb != null) {
                sb.append('J');
                return sb;
            }
        }

        return null;
    }

    public static class Task implements Comparable<Task> {
        int start, end, id;

        Task(int start, int end, int id) {
            this.start = start;
            this.end = end;
            this.id = id;
        }

        @Override
        public int compareTo(Task other) {
            int compareStart = Integer.compare(this.start, other.start);
            return compareStart != 0 ? compareStart : Integer.compare(this.end, other.end);
        }

        @Override
        public String toString() {
            return "{" + start + " " + end + "}";
        }
    }

    private static final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    private static final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
    private static final Scanner scanner = new Scanner(System.in);
}