import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    static class Task {
        int start;
        int end;
        int initialOrder;
        char assignedTo;

        Task(int start, int end, int initialOrder) {
            this.start = start;
            this.end = end;
            this.initialOrder = initialOrder;
        }
    }

    public static void main(String[] args) {
        new Solution().solve();
    }

    public void solve() {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = scanner.nextInt();
            for (int i = 1; i <= t; ++i) {
                int n = scanner.nextInt();
                List<Task> tasks = new ArrayList<>();

                for (int j = 0; j < n; j++) {
                    int start = scanner.nextInt();
                    int end = scanner.nextInt();
                    tasks.add(new Task(start, end, j));
                }

                System.out.println("Case #" + i + ": " + assignTasks(tasks));
            }
        }
    }

    private String assignTasks(List<Task> tasks) {
        tasks.sort(Comparator.comparingInt(task -> task.start));

        int cBusyUntil = 0;
        int jBusyUntil = 0;

        for (Task task : tasks) {
            if (task.start >= cBusyUntil) {
                task.assignedTo = 'C';
                cBusyUntil = task.end;
            } else if (task.start >= jBusyUntil) {
                task.assignedTo = 'J';
                jBusyUntil = task.end;
            } else {
                return "IMPOSSIBLE";
            }
        }

        tasks.sort(Comparator.comparingInt(task -> task.initialOrder));
        return tasks.stream().map(task -> String.valueOf(task.assignedTo)).collect(Collectors.joining());
    }
}