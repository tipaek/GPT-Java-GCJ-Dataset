
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = s.nextInt();
        s.nextLine();
        for (int t = 1; t <= testCases; t++) {

            int n = s.nextInt();
            Task[] tasks = IntStream.range(0, n)
                    .mapToObj(i -> new Task(s.nextInt(), s.nextInt()))
                    .toArray(l -> new Task[l]);

            String answer = solve(tasks);
            System.out.format("Case #%d: %s\n", t, answer);
        }
    }

    private static String solve(Task[] tasks) {
        Task[] sorted = Arrays.copyOf(tasks, tasks.length);
        Arrays.sort(sorted);

        Task jTask = new Task(-1, -1);
        Task cTask = new Task(-1, -1);

        for (Task task : sorted) {
            if (!jTask.overlaps(task)) {
                jTask = task;
                task.owner = 'J';
            } else if (!cTask.overlaps(task)) {
                cTask = task;
                task.owner = 'C';
            } else return "IMPOSSIBLE";
        }

        StringBuilder answer = new StringBuilder();
        Arrays.stream(tasks).forEach(t -> answer.append(t.owner));
        return answer.toString();
    }


    static class Task implements Comparable {
        int start;
        int end;
        char owner;

        Task(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Object o) {
            Task other = (Task) o;
            return this.start - other.start;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }

        public boolean overlaps(Task other) {
            return other.start < this.end && other.end > this.start;
        }
    }
}
