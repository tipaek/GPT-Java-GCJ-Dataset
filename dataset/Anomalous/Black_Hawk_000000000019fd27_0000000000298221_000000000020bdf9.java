import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Task {
    int index;
    int start;
    int end;
    char assignedTo;
}

class StartComparator implements Comparator<Task> {
    public int compare(Task a, Task b) {
        return Integer.compare(a.start, b.start);
    }
}

class EndComparator implements Comparator<Task> {
    public int compare(Task a, Task b) {
        return Integer.compare(a.end, b.end);
    }
}

public class Solution {

    Task[] tasks;
    int taskCount;

    public Solution(int taskCount) {
        this.taskCount = taskCount;
        this.tasks = new Task[taskCount];
    }

    void assignTasks() {
        boolean isCFree = true, isJFree = true;
        boolean isPossible = true;
        int cEndTime = 0, jEndTime = 0;

        for (int i = 0; i < taskCount && isPossible; i++) {
            if (cEndTime <= tasks[i].start) isCFree = true;
            if (jEndTime <= tasks[i].start) isJFree = true;

            if (isCFree) {
                tasks[i].assignedTo = 'C';
                cEndTime = tasks[i].end;
                isCFree = false;
            } else if (isJFree) {
                tasks[i].assignedTo = 'J';
                jEndTime = tasks[i].end;
                isJFree = false;
            } else {
                isPossible = false;
            }
        }

        if (isPossible) {
            Arrays.sort(tasks, Comparator.comparingInt(task -> task.index));
            for (Task task : tasks) {
                System.out.print(task.assignedTo);
            }
        } else {
            System.out.print("IMPOSSIBLE");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine().trim());
        Solution[] solutions = new Solution[testCases];

        for (int t = 0; t < testCases; t++) {
            int n = Integer.parseInt(reader.readLine().trim());
            solutions[t] = new Solution(n);

            for (int i = 0; i < n; i++) {
                String[] input = reader.readLine().trim().split(" ");
                solutions[t].tasks[i] = new Task();
                solutions[t].tasks[i].index = i;
                solutions[t].tasks[i].start = Integer.parseInt(input[0]);
                solutions[t].tasks[i].end = Integer.parseInt(input[1]);
            }

            Arrays.sort(solutions[t].tasks, new EndComparator());
            Arrays.sort(solutions[t].tasks, new StartComparator());
        }

        for (int t = 0; t < testCases; t++) {
            System.out.print("Case #" + (t + 1) + ": ");
            solutions[t].assignTasks();
            System.out.println();
        }
    }
}