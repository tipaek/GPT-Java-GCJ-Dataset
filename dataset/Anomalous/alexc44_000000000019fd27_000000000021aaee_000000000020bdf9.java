import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.hasNextLine() ? Integer.parseInt(scanner.nextLine()) : 0;

        for (int i = 0; i < cases; i++) {
            int times = Integer.parseInt(scanner.nextLine());
            Task[] tasks = new Task[times];

            for (int j = 0; j < times; j++) {
                String[] input = scanner.nextLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                tasks[j] = new Task(start, end, j);
            }

            System.out.println("Case #" + (i + 1) + ": " + scheduleTasks(tasks));
        }
    }

    private static String scheduleTasks(Task[] tasks) {
        Arrays.sort(tasks, Comparator.comparingInt((Task t) -> t.start).thenComparingInt(t -> t.end));

        int cEnd = 0;
        int jEnd = 0;
        String[] result = new String[tasks.length];

        for (Task task : tasks) {
            if (task.start >= cEnd) {
                cEnd = task.end;
                result[task.index] = "C";
            } else if (task.start >= jEnd) {
                jEnd = task.end;
                result[task.index] = "J";
            } else {
                return "IMPOSSIBLE";
            }
        }

        return String.join("", result);
    }

    private static class Task {
        int start;
        int end;
        int index;

        Task(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}