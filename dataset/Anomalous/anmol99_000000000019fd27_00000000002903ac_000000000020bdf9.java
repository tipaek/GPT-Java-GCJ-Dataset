import java.util.*;
import java.io.*;

public class Solution {

    static class Task {
        int start;
        int end;
        int index;
        char assignedTo;

        Task(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
            this.assignedTo = '/';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int currentCase = testCases;

        while (testCases > 0) {
            int numTasks = scanner.nextInt();
            Task[] tasks = new Task[numTasks];

            for (int i = 0; i < numTasks; i++) {
                tasks[i] = new Task(scanner.nextInt(), scanner.nextInt(), i);
            }

            Arrays.sort(tasks, Comparator.comparingInt(task -> task.start));

            boolean isPossible = true;
            int endC = 0, endJ = 0;

            tasks[0].assignedTo = 'C';
            endC = tasks[0].end;

            for (int i = 1; i < numTasks; i++) {
                if (tasks[i].start >= endC) {
                    tasks[i].assignedTo = 'C';
                    endC = tasks[i].end;
                } else if (tasks[i].start >= endJ) {
                    tasks[i].assignedTo = 'J';
                    endJ = tasks[i].end;
                } else {
                    isPossible = false;
                    break;
                }
            }

            Arrays.sort(tasks, Comparator.comparingInt(task -> task.index));
            StringBuilder result = new StringBuilder();

            for (Task task : tasks) {
                result.append(task.assignedTo);
            }

            if (isPossible) {
                System.out.println("Case #" + (currentCase - testCases + 1) + ": " + result);
            } else {
                System.out.println("Case #" + (currentCase - testCases + 1) + ": IMPOSSIBLE");
            }

            testCases--;
        }
    }
}