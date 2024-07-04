import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static class Task implements Comparable<Task> {
        public int start;
        public int end;

        public Task(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Task other) {
            if (this.start != other.start) {
                return Integer.compare(this.start, other.start);
            }
            return Integer.compare(this.end, other.end);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            Task[] tasks = new Task[N];

            for (int n = 0; n < N; n++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                tasks[n] = new Task(start, end);
            }

            Arrays.sort(tasks);

            StringBuilder result = new StringBuilder();
            int cEnd = 0, jEnd = 0;

            for (Task task : tasks) {
                if (cEnd <= task.start) {
                    result.append('C');
                    cEnd = task.end;
                } else if (jEnd <= task.start) {
                    result.append('J');
                    jEnd = task.end;
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println(String.format("Case #%d: %s", t, result));
        }

        scanner.close();
    }
}