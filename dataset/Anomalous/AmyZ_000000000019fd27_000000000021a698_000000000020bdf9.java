import java.util.*;
import java.io.*;

public class Solution {
    static class Task implements Comparable<Task> {
        int start;
        int end;
        int order;

        Task(int order, int start, int end) {
            this.order = order;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Task other) {
            return Integer.compare(this.start, other.start);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = Integer.parseInt(scanner.nextLine());

        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            int taskCount = Integer.parseInt(scanner.nextLine());
            Task[] tasks = new Task[taskCount];

            for (int taskIndex = 0; taskIndex < taskCount; taskIndex++) {
                String[] taskDetails = scanner.nextLine().split(" ");
                int start = Integer.parseInt(taskDetails[0]);
                int end = Integer.parseInt(taskDetails[1]);
                tasks[taskIndex] = new Task(taskIndex, start, end);
            }

            String result = assignTasks(tasks);
            System.out.println("Case #" + caseIndex + ": " + result);
        }
    }

    public static String assignTasks(Task[] tasks) {
        Arrays.sort(tasks);
        int cEnd = 0;
        int jEnd = 0;
        char[] assignments = new char[tasks.length];

        for (Task task : tasks) {
            if (cEnd <= task.start) {
                cEnd = task.end;
                assignments[task.order] = 'C';
            } else if (jEnd <= task.start) {
                jEnd = task.end;
                assignments[task.order] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }

        return new String(assignments);
    }
}