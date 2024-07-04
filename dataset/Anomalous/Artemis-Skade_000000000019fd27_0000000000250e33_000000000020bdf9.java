import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int t = 0; t < testCases; t++) {
            System.out.println("Case #" + (t + 1) + ": " + solve(scanner));
        }
    }

    static class Task {
        int id;
        int startTime;
        int endTime;
        List<Task> conflictingTasks;
        boolean assigned;

        Task(int id, int startTime, int endTime) {
            this.id = id;
            this.startTime = startTime;
            this.endTime = endTime;
            this.conflictingTasks = new ArrayList<>();
            this.assigned = false;
        }

        boolean conflictsWith(Task other) {
            if ((this.startTime < other.startTime && this.endTime > other.startTime) || 
                (this.startTime < other.endTime && this.endTime > other.startTime)) {
                this.conflictingTasks.add(other);
                other.conflictingTasks.add(this);
                return true;
            }
            return false;
        }

        boolean hasConflicts() {
            return !conflictingTasks.isEmpty();
        }
    }

    private static String solve(Scanner scanner) {
        int n = scanner.nextInt();
        Task[] tasks = new Task[n];
        char[] assignments = new char[n];

        for (int i = 0; i < n; i++) {
            tasks[i] = new Task(i, scanner.nextInt(), scanner.nextInt());
        }

        // Build conflict graph
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                tasks[i].conflictsWith(tasks[j]);
            }
        }

        // Assign tasks without conflicts to 'C'
        for (int i = 0; i < n; i++) {
            if (!tasks[i].hasConflicts()) {
                assignments[i] = 'C';
                tasks[i].assigned = true;
            }
        }

        // Resolve conflicts
        for (int i = 0; i < n; i++) {
            if (tasks[i].hasConflicts()) {
                char oppositeChar = 'C';
                if (tasks[i].assigned) {
                    oppositeChar = assignments[i] == 'C' ? 'J' : 'C';
                } else {
                    assignments[i] = 'J';
                    tasks[i].assigned = true;
                }

                for (Task neighbor : tasks[i].conflictingTasks) {
                    if (assignments[neighbor.id] == assignments[i]) {
                        return "IMPOSSIBLE";
                    } else {
                        assignments[neighbor.id] = oppositeChar;
                        neighbor.assigned = true;
                    }
                }
            }
        }

        return new String(assignments);
    }
}