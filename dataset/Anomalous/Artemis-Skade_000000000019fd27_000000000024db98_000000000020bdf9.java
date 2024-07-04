package pgdp.space;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();
        for (int testCase = 1; testCase <= numberOfTests; testCase++) {
            System.out.println("Case #" + testCase + ": " + solve(scanner));
        }
    }

    private static class Task {
        private final int number;
        private final int start;
        private final int end;
        private final List<Task> conflictingTasks;
        private boolean visited;

        public Task(int number, int start, int end) {
            this.number = number;
            this.start = start;
            this.end = end;
            this.conflictingTasks = new ArrayList<>();
            this.visited = false;
        }

        public boolean conflictsWith(Task other) {
            boolean conflicts = (this.start < other.start && this.end > other.start) ||
                                (this.start < other.end && this.end > other.end);
            if (conflicts) {
                this.conflictingTasks.add(other);
                other.conflictingTasks.add(this);
            }
            return conflicts;
        }

        public boolean hasConflicts() {
            return !conflictingTasks.isEmpty();
        }
    }

    private static String solve(Scanner scanner) {
        int numberOfTasks = scanner.nextInt();
        Task[] tasks = new Task[numberOfTasks];
        char[] assignments = new char[numberOfTasks];

        for (int i = 0; i < numberOfTasks; i++) {
            tasks[i] = new Task(i, scanner.nextInt(), scanner.nextInt());
        }

        // Build graph of conflicting tasks
        for (int i = 0; i < numberOfTasks; i++) {
            for (int j = i + 1; j < numberOfTasks; j++) {
                tasks[i].conflictsWith(tasks[j]);
            }
        }

        // Assign tasks without conflicts to 'C'
        for (int i = 0; i < numberOfTasks; i++) {
            if (!tasks[i].hasConflicts()) {
                assignments[i] = 'C';
                tasks[i].visited = true;
            }
        }

        // Resolve conflicts
        for (int i = 0; i < numberOfTasks; i++) {
            if (tasks[i].hasConflicts()) {
                char oppositeAssignment = 'C';
                if (tasks[i].visited) {
                    oppositeAssignment = assignments[i] == 'C' ? 'J' : 'C';
                } else {
                    assignments[i] = 'J';
                    tasks[i].visited = true;
                }

                for (Task conflictingTask : tasks[i].conflictingTasks) {
                    if (assignments[conflictingTask.number] == assignments[i]) {
                        return "IMPOSSIBLE";
                    } else {
                        assignments[conflictingTask.number] = oppositeAssignment;
                        conflictingTask.visited = true;
                    }
                }
            }
        }

        return new String(assignments);
    }
}