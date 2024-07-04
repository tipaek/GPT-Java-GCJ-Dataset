import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();

        for (int caseIndex = 0; caseIndex < cases; caseIndex++) {
            int tasks = scanner.nextInt();
            Task[] tasksArray = new Task[tasks];
            Task[] originalTasksArray = new Task[tasks];

            for (int i = 0; i < tasks; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                tasksArray[i] = new Task(start, end);
                originalTasksArray[i] = new Task(start, end);
            }

            Arrays.sort(tasksArray, Comparator.comparingInt(task -> task.start));

            int cEnd = 0;
            int jEnd = 0;
            boolean possible = true;
            char[] assignment = new char[tasks];
            boolean[] assigned = new boolean[tasks];

            for (Task task : tasksArray) {
                if (cEnd <= task.start) {
                    cEnd = task.end;
                    assignTask(task, 'C', originalTasksArray, assignment, assigned);
                } else if (jEnd <= task.start) {
                    jEnd = task.end;
                    assignTask(task, 'J', originalTasksArray, assignment, assigned);
                } else {
                    possible = false;
                    break;
                }
            }

            System.out.print("Case #" + (caseIndex + 1) + ": ");
            if (possible) {
                System.out.println(new String(assignment));
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    private static void assignTask(Task task, char person, Task[] originalTasksArray, char[] assignment, boolean[] assigned) {
        for (int i = 0; i < originalTasksArray.length; i++) {
            if (!assigned[i] && task.start == originalTasksArray[i].start && task.end == originalTasksArray[i].end) {
                assigned[i] = true;
                assignment[i] = person;
                break;
            }
        }
    }
}

class Task {
    int start;
    int end;

    public Task(int start, int end) {
        this.start = start;
        this.end = end;
    }
}