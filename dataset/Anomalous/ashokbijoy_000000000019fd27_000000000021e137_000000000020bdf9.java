import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int numTasks = scanner.nextInt();
            Task[] tasks = new Task[numTasks];

            for (int i = 0; i < numTasks; i++) {
                tasks[i] = new Task(i, scanner.nextInt(), scanner.nextInt());
            }
            System.out.println("Case #" + t + ": " + assignTasks(tasks));
        }
        scanner.close();
    }

    static class Task implements Comparable<Task> {
        int id, start, end;

        Task(int id, int start, int end) {
            this.id = id;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Task other) {
            return Integer.compare(this.end, other.end);
        }
    }

    static String assignTasks(Task[] tasks) {
        final String IMPOSSIBLE = "IMPOSSIBLE";

        if (tasks == null || tasks.length == 0) return IMPOSSIBLE;
        if (tasks.length == 1) return "C";

        Arrays.sort(tasks);

        int[] assignments = new int[tasks.length];
        assignments[0] = 1; // 1 for 'C', 2 for 'J'

        for (int i = 1; i < tasks.length; i++) {
            boolean overlapsC = false, overlapsJ = false;

            for (int j = i - 1; j >= 0; j--) {
                if (tasks[i].start >= tasks[j].end) break;

                if (assignments[j] == 1) overlapsC = true;
                if (assignments[j] == 2) overlapsJ = true;

                if (overlapsC && overlapsJ) return IMPOSSIBLE;
            }

            if (overlapsC) {
                assignments[i] = 2;
            } else if (overlapsJ) {
                assignments[i] = 1;
            } else {
                assignments[i] = assignments[i - 1] == 1 ? 2 : 1;
            }
        }

        char[] result = new char[tasks.length];
        for (int i = 0; i < tasks.length; i++) {
            result[tasks[i].id] = assignments[i] == 1 ? 'C' : 'J';
        }

        return new String(result);
    }
}