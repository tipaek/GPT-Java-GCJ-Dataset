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
        int totalCases = scanner.nextInt();
        int caseNumber = totalCases;

        while (totalCases > 0) {
            int numTasks = scanner.nextInt();
            Task[] tasks = new Task[numTasks];

            for (int i = 0; i < numTasks; ++i) {
                tasks[i] = new Task(scanner.nextInt(), scanner.nextInt(), i);
            }

            Arrays.sort(tasks, Comparator.comparingInt(task -> task.start));

            boolean isImpossible = false;
            tasks[0].assignedTo = 'C';

            for (int i = 1; i < numTasks; ++i) {
                char previousAssigned = tasks[i - 1].assignedTo;
                if ((i + 1 < numTasks) && (tasks[i + 1].start < tasks[i - 1].end) && tasks[i + 1].start < tasks[i].end) {
                    isImpossible = true;
                    break;
                } else {
                    if (tasks[i].start < tasks[i - 1].end) {
                        tasks[i].assignedTo = (previousAssigned == 'C') ? 'J' : 'C';
                    } else {
                        tasks[i].assignedTo = previousAssigned;
                    }
                }
            }

            Arrays.sort(tasks, Comparator.comparingInt(task -> task.index));
            StringBuilder answer = new StringBuilder();

            for (Task task : tasks) {
                answer.append(task.assignedTo);
            }

            if (isImpossible) {
                System.out.println("Case #" + (caseNumber - totalCases + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (caseNumber - totalCases + 1) + ": " + answer.toString());
            }

            totalCases--;
        }
    }
}