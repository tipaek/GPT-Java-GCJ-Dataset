import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + solve(scanner));
        }
    }

    static class Task {
        int number;
        int start;
        int end;
        List<Task> nextTasks;
        boolean visited;

        Task(int number, int start, int end) {
            this.number = number;
            this.start = start;
            this.end = end;
            this.nextTasks = new ArrayList<>();
            this.visited = false;
        }

        boolean conflictsWith(Task task) {
            if ((this.start < task.start && this.end > task.start) || (this.start < task.end && this.end > task.end)) {
                this.nextTasks.add(task);
                task.nextTasks.add(this);
                return true;
            }
            return false;
        }

        boolean hasConflicts() {
            return !nextTasks.isEmpty();
        }
    }

    static String solve(Scanner scanner) {
        int n = scanner.nextInt();
        Task[] tasks = new Task[n];
        char[] assignments = new char[n];

        for (int i = 0; i < n; i++) {
            tasks[i] = new Task(i, scanner.nextInt(), scanner.nextInt());
        }

        // Build the graph
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                tasks[i].conflictsWith(tasks[j]);
            }
        }

        // Assign tasks without conflicts to 'C'
        for (int i = 0; i < n; i++) {
            if (!tasks[i].hasConflicts()) {
                assignments[i] = 'C';
                tasks[i].visited = true;
            }
        }

        // Resolve conflicts
        for (int i = 0; i < n; i++) {
            if (tasks[i].hasConflicts()) {
                char opposite = 'C';
                if (tasks[i].visited) {
                    opposite = assignments[i] == 'C' ? 'J' : 'C';
                } else {
                    assignments[i] = 'J';
                    tasks[i].visited = true;
                }

                for (Task neighbor : tasks[i].nextTasks) {
                    if (assignments[neighbor.number] == assignments[i]) {
                        return "IMPOSSIBLE";
                    } else {
                        assignments[neighbor.number] = opposite;
                        neighbor.visited = true;
                    }
                }
            }
        }

        return new String(assignments);
    }
}