import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Solution
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];

            for (int j = 0; j < n; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
            }

            System.out.println("Case #" + i + ": " + assignTasks(intervals, n));
        }
    }

    public static String assignTasks(int[][] intervals, int n) {
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tasks.add(new Task(intervals[i][0], intervals[i][1]));
        }

        tasks.sort(Comparator.comparingInt(task -> task.start));

        int lastC = 0;
        int lastJ = 0;
        Map<Task, Character> taskAssignment = new HashMap<>();

        for (Task task : tasks) {
            if (task.start >= lastC) {
                taskAssignment.put(task, 'C');
                lastC = task.end;
            } else if (task.start >= lastJ) {
                taskAssignment.put(task, 'J');
                lastJ = task.end;
            } else {
                return "IMPOSSIBLE";
            }
        }

        StringBuilder result = new StringBuilder();
        for (Task task : tasks) {
            result.append(taskAssignment.get(task));
        }

        return result.toString();
    }

    static class Task {
        int start;
        int end;

        Task(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}