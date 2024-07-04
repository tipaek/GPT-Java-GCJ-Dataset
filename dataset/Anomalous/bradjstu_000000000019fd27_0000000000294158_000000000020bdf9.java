import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= testCases; i++) {
            processTestCase(i, scanner);
        }
    }

    private static void processTestCase(int testCaseNumber, Scanner scanner) {
        int testCaseSize = scanner.nextInt();
        Task[] tasks = new Task[testCaseSize];

        for (int i = 0; i < testCaseSize; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            tasks[i] = new Task(start, end, i);
        }

        Arrays.sort(tasks);

        Scheduler jScheduler = new Scheduler();
        Scheduler cScheduler = new Scheduler();
        boolean isImpossible = false;

        for (Task task : tasks) {
            if (!jScheduler.hasOverlap(task)) {
                jScheduler.addTask(task);
            } else if (!cScheduler.hasOverlap(task)) {
                cScheduler.addTask(task);
            } else {
                isImpossible = true;
                break;
            }
        }

        if (isImpossible) {
            printResult(testCaseNumber, "IMPOSSIBLE");
        } else {
            char[] result = new char[tasks.length];
            jScheduler.assignTasks(result, 'J');
            cScheduler.assignTasks(result, 'C');
            printResult(testCaseNumber, new String(result));
        }
    }

    private static class Scheduler {
        private final List<Task> tasks;

        public Scheduler() {
            tasks = new ArrayList<>();
        }

        public void addTask(Task task) {
            tasks.add(task);
        }

        public boolean hasOverlap(Task task) {
            for (Task t : tasks) {
                if (t.overlapsWith(task)) {
                    return true;
                }
            }
            return false;
        }

        public void assignTasks(char[] result, char label) {
            for (Task task : tasks) {
                result[task.originalIndex] = label;
            }
        }
    }

    private static class Task implements Comparable<Task> {
        final int start;
        final int end;
        final int originalIndex;

        public Task(int start, int end, int originalIndex) {
            this.start = start;
            this.end = end;
            this.originalIndex = originalIndex;
        }

        public boolean overlapsWith(Task other) {
            return (this.start < other.end && this.end > other.start);
        }

        @Override
        public int compareTo(Task other) {
            return Integer.compare(this.start, other.start);
        }
    }

    private static void printResult(int testCaseNumber, String result) {
        System.out.println("Case #" + testCaseNumber + ": " + result);
    }
}