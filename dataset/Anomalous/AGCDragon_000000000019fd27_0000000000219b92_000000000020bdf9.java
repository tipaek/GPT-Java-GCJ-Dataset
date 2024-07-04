import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            Task[] tasks = new Task[n];
            for (int i = 0; i < n; i++) {
                tasks[i] = new Task(scanner.nextInt(), scanner.nextInt());
            }

            Arrays.sort(tasks);
            String result = assignTasks(tasks);
            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static String assignTasks(Task[] tasks) {
        int cEnd = 0, jEnd = 0;
        StringBuilder schedule = new StringBuilder();

        for (Task task : tasks) {
            if (task.start >= cEnd) {
                schedule.append('C');
                cEnd = task.end;
            } else if (task.start >= jEnd) {
                schedule.append('J');
                jEnd = task.end;
            } else {
                return "IMPOSSIBLE";
            }
        }

        return schedule.toString();
    }
}

class Task implements Comparable<Task> {
    int start;
    int end;

    Task(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.start, other.start);
    }

    @Override
    public String toString() {
        return "[" + start + " " + end + "]";
    }
}