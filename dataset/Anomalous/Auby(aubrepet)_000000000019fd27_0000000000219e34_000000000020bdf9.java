package qualification;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private Scanner scanner;

    public void run() {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < testCases; i++) {
            List<Task> tasks = parseTasks();
            String result = processTestCase(tasks);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private String processTestCase(List<Task> tasks) {
        tasks.sort(Comparator.comparingInt(task -> task.start));

        int cEndTime = 0;
        int jEndTime = 0;
        for (Task task : tasks) {
            if (cEndTime <= task.start) {
                task.assignedTo = 'C';
                cEndTime = task.end;
            } else if (jEndTime <= task.start) {
                task.assignedTo = 'J';
                jEndTime = task.end;
            } else {
                return "IMPOSSIBLE";
            }
        }

        tasks.sort(Comparator.comparingInt(task -> task.index));
        StringBuilder resultBuilder = new StringBuilder();
        for (Task task : tasks) {
            resultBuilder.append(task.assignedTo);
        }
        return resultBuilder.toString();
    }

    private List<Task> parseTasks() {
        int numberOfTasks = scanner.nextInt();
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < numberOfTasks; i++) {
            tasks.add(new Task(i, scanner.nextInt(), scanner.nextInt()));
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