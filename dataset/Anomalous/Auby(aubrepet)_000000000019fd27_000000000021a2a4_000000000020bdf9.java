package qualification;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private Scanner in;

    private void run() {
        in = new Scanner(System.in);
        int testCases = in.nextInt();
        in.nextLine();
        for (int i = 0; i < testCases; i++) {
            List<Task> tasks = readTasks();
            String result = assignTasks(tasks);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private String assignTasks(List<Task> tasks) {
        tasks.sort(Comparator.comparingInt(task -> task.start));

        int cEnd = 0;
        int jEnd = 0;
        for (Task task : tasks) {
            if (cEnd <= task.start) {
                task.assignedTo = 'C';
                cEnd = task.end;
            } else if (jEnd <= task.start) {
                task.assignedTo = 'J';
                jEnd = task.end;
            } else {
                return "IMPOSSIBLE";
            }
        }

        tasks.sort(Comparator.comparingInt(task -> task.index));
        StringBuilder result = new StringBuilder();
        for (Task task : tasks) {
            result.append(task.assignedTo);
        }
        return result.toString();
    }

    private List<Task> readTasks() {
        int numberOfTasks = in.nextInt();
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < numberOfTasks; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            tasks.add(new Task(i, start, end));
        }
        return tasks;
    }

    private static class Task {
        private final int index;
        private final int start;
        private final int end;
        private char assignedTo;

        public Task(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }
    }
}