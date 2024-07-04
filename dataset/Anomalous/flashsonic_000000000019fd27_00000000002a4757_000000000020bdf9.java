import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();

        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            int numberOfTasks = scanner.nextInt();
            Task[] tasks = new Task[numberOfTasks];
            Task[] originalTasks = new Task[numberOfTasks];

            for (int taskIndex = 0; taskIndex < numberOfTasks; taskIndex++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                tasks[taskIndex] = new Task(startTime, endTime);
                originalTasks[taskIndex] = new Task(startTime, endTime);
            }

            Arrays.sort(tasks);

            int cameronEndTime = 0;
            int jamieEndTime = 0;
            boolean isPossible = true;
            char[] assignments = new char[numberOfTasks];
            boolean[] assigned = new boolean[numberOfTasks];

            for (Task task : tasks) {
                if (cameronEndTime <= task.startTime) {
                    cameronEndTime = task.endTime;
                    assignTask(originalTasks, assigned, assignments, task, 'C');
                } else if (jamieEndTime <= task.startTime) {
                    jamieEndTime = task.endTime;
                    assignTask(originalTasks, assigned, assignments, task, 'J');
                } else {
                    isPossible = false;
                    break;
                }
            }

            System.out.print("Case #" + (caseIndex + 1) + ": ");
            if (isPossible) {
                System.out.println(new String(assignments));
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    private static void assignTask(Task[] originalTasks, boolean[] assigned, char[] assignments, Task task, char assignee) {
        for (int i = 0; i < originalTasks.length; i++) {
            if (!assigned[i] && originalTasks[i].equals(task)) {
                assigned[i] = true;
                assignments[i] = assignee;
                break;
            }
        }
    }
}

class Task implements Comparable<Task> {
    int startTime;
    int endTime;

    public Task(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.startTime, other.startTime);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Task task = (Task) obj;
        return startTime == task.startTime && endTime == task.endTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startTime, endTime);
    }
}