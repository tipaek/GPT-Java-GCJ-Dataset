import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int t = 0; t < testCases; t++) {
            int numTasks = scanner.nextInt();
            List<Task> tasks = new ArrayList<>();

            for (int i = 0; i < numTasks; i++) {
                tasks.add(new Task(scanner.nextInt(), scanner.nextInt(), i));
            }
            Collections.sort(tasks);

            Parent cameron = new Parent('C');
            Parent jamie = new Parent('J');

            char[] assignment = new char[numTasks];
            boolean possible = true;
            
            for (Task task : tasks) {
                if (cameron.isAvailable(task)) {
                    cameron.assign(task);
                    assignment[task.index] = cameron.getName();
                } else if (jamie.isAvailable(task)) {
                    jamie.assign(task);
                    assignment[task.index] = jamie.getName();
                } else {
                    possible = false;
                    break;
                }
            }
            
            System.out.println("Case #" + (t + 1) + ": " + (possible ? new String(assignment) : "IMPOSSIBLE"));
        }

        scanner.close();
    }

    private static class Parent {
        private final char name;
        private final List<Task> assignedTasks;

        public Parent(char name) {
            this.name = name;
            this.assignedTasks = new ArrayList<>();
        }

        public char getName() {
            return name;
        }

        public void assign(Task task) {
            assignedTasks.add(task);
        }

        public boolean isAvailable(Task task) {
            for (Task assignedTask : assignedTasks) {
                if (task.overlaps(assignedTask)) {
                    return false;
                }
            }
            return true;
        }
    }

    private static class Task implements Comparable<Task> {
        private final int start;
        private final int end;
        private final int index;

        public Task(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        public boolean overlaps(Task other) {
            return this.start < other.end && other.start < this.end;
        }

        @Override
        public int compareTo(Task other) {
            return Integer.compare(this.start, other.start);
        }
    }
}