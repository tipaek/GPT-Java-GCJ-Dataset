import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCases = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            int numberOfTasks = scanner.nextInt();
            Task[] tasks = new Task[numberOfTasks];
            Task[] originalTasks = new Task[numberOfTasks];

            for (int i = 0; i < numberOfTasks; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                tasks[i] = new Task(start, end);
                originalTasks[i] = new Task(start, end);
            }

            Arrays.sort(tasks);

            int cEndTime = 0;
            int jEndTime = 0;
            boolean isPossible = true;
            char[] assignments = new char[numberOfTasks];
            boolean[] assigned = new boolean[numberOfTasks];

            for (Task task : tasks) {
                if (cEndTime <= task.start) {
                    cEndTime = task.end;
                    assignTask(task, originalTasks, assigned, assignments, 'C');
                } else if (jEndTime <= task.start) {
                    jEndTime = task.end;
                    assignTask(task, originalTasks, assigned, assignments, 'J');
                } else {
                    isPossible = false;
                    break;
                }
            }

            System.out.print("Case #" + caseIndex + ": ");
            if (isPossible) {
                System.out.println(new String(assignments));
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    private static void assignTask(Task task, Task[] originalTasks, boolean[] assigned, char[] assignments, char person) {
        for (int i = 0; i < originalTasks.length; i++) {
            if (!assigned[i] && task.equals(originalTasks[i])) {
                assigned[i] = true;
                assignments[i] = person;
                break;
            }
        }
    }
}

class Task implements Comparable<Task> {
    int start;
    int end;

    public Task(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.start, other.start);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Task task = (Task) obj;
        return start == task.start && end == task.end;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }
}