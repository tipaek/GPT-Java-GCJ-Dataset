import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int test = 1; test <= testCases; test++) {
            int n = scanner.nextInt();
            int cameronEnd = 0, jamieEnd = 0;
            boolean impossible = false;
            char[] schedule = new char[n];
            Task[] tasks = new Task[n];

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                tasks[i] = new Task(start, end, i);
            }

            Arrays.sort(tasks, Comparator.comparingInt(task -> task.end));

            for (Task task : tasks) {
                if (task.start >= cameronEnd) {
                    schedule[task.index] = 'C';
                    cameronEnd = task.end;
                } else if (task.start >= jamieEnd) {
                    schedule[task.index] = 'J';
                    jamieEnd = task.end;
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + test + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + test + ": " + new String(schedule));
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