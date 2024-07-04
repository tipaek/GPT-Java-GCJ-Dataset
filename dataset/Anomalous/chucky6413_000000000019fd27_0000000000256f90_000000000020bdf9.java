import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    private static final PrintWriter writer = new PrintWriter(System.out);
    private static final StringBuilder resultBuilder = new StringBuilder();
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int numTasks = scanner.nextInt();
            int[][] taskTimes = new int[numTasks][2];
            for (int i = 0; i < numTasks; i++) {
                taskTimes[i][0] = scanner.nextInt();
                taskTimes[i][1] = scanner.nextInt();
            }

            resultBuilder.append(String.format("Case #%d: ", t))
                          .append(assignTasks(taskTimes))
                          .append(NEW_LINE);
        }
        writer.print(resultBuilder.toString());
        writer.close();
    }

    private static String assignTasks(int[][] taskTimes) {
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < taskTimes.length; i++) {
            tasks.add(new Task(taskTimes[i][0], taskTimes[i][1], i));
        }
        Collections.sort(tasks);

        char[] assignment = new char[taskTimes.length];
        Task cameron = new Task(0, 0, 0);
        Task jamie = new Task(0, 0, 0);
        for (Task task : tasks) {
            if (cameron.end <= task.start) {
                cameron = task;
                assignment[task.index] = 'C';
            } else if (jamie.end <= task.start) {
                jamie = task;
                assignment[task.index] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }

        return new String(assignment);
    }

    private static class Task implements Comparable<Task> {
        int start;
        int end;
        int index;

        public Task(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Task other) {
            if (this.start == other.start) {
                return Integer.compare(this.end, other.end);
            }
            return Integer.compare(this.start, other.start);
        }
    }
}